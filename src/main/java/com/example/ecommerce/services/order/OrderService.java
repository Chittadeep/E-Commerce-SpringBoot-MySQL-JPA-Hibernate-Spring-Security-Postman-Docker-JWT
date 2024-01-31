package com.example.ecommerce.services.order;

import java.sql.Timestamp;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.buyer.BuyerAddress;
import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.order.OrderPayment;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.models.order.OrderResponse;
import com.example.ecommerce.repositories.buyer.BuyerAddressRepository;
import com.example.ecommerce.repositories.buyer.BuyerRepository;
import com.example.ecommerce.repositories.order.OrderPaymentRepository;
import com.example.ecommerce.repositories.order.OrderRepository;
import com.example.ecommerce.repositories.product.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;


@RestController
public class OrderService {

    private OrderRepository orderRepository;
    private BuyerRepository buyerRepository;
    private BuyerAddressRepository buyerAddressRepository;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private OrderPaymentRepository orderPaymentRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, EntityManagerFactory entityManagerFactory, 
    EntityManager entityManager, BuyerRepository buyerRepository, 
    BuyerAddressRepository buyerAddressRepository, OrderPaymentRepository orderPaymentRepository,
    ProductRepository productRepository)
    {
        this.orderRepository = orderRepository;
        this.buyerAddressRepository = buyerAddressRepository;
        this.buyerRepository = buyerRepository;
        this.entityManager=entityManager;
        this.entityManagerFactory=entityManagerFactory;
        this.orderPaymentRepository=orderPaymentRepository;
        this.productRepository=productRepository;
    }

    public List<OrderResponse> getAllOrders() 
    {
        return ((List<OrderCustom>) orderRepository.findAll()).stream().map(OrderResponse::new).toList();
    }

    @Transactional
    public OrderResponse createOrderCustom(OrderCustom order) 
    {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = entityManager.unwrap(Session.class);
        Buyer buyer = session.get(Buyer.class, order.getBuyer().getId());
        BuyerAddress buyerAddress = session.get(BuyerAddress.class, order.getBuyerAddress().getId());
        if(buyer==null) throw new RuntimeException("No buyer exists with this id");
        if(buyerAddress==null) throw new RuntimeException("No buyer address exists with this id");
        if(buyerAddress.getBuyerId()!=buyer.getId()) throw new RuntimeException("buyer does not have this address");
        List<OrderItem> items = updatePriceAndQuantity(order.getOrderItems(), session);
        items.stream().forEach((item)->{
            item.setOrder(order);
            item.setBuyer(buyer);
        });
        order.setOrderItems(items);
        order.setOrderState(OrderState.INITIATED);
        order.setBasePrice(calculateBasePrice(items));
        order.setDeliveryPrice(20);
        order.setSaasFee(20);
        order.setTotalPrice(order.getBasePrice()+order.getDeliveryPrice()+order.getSaasFee());
        //System.out.println(items);
        /*
        int id = (int) session.save(order);
        session.flush();
        OrderCustom orderCustom = session.get(OrderCustom.class, id);
        */
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setOrderCustom(order);
        orderPayment.setOrderPaymentInitiated(new Timestamp(System.currentTimeMillis()));
        orderPayment.setBuyer(buyer);
        orderPaymentRepository.save(orderPayment);
        order.setOrderPayment(orderPayment);
        orderRepository.save(order);
        return new OrderResponse(order);
    }

    private List<OrderItem> updatePriceAndQuantity(List<OrderItem> orderItems, Session session)
    {
        orderItems.forEach((orderItem)->{
            if(orderItem.getProduct()==null) throw new RuntimeException("No product has been passed to the order item");
            Product product = session.get(Product.class, orderItem.getProduct().getId());
            if(product==null) throw new RuntimeException("product with this id "+ orderItem.getProduct().getId()+ " is not available");
            if(!product.isAvailable()) throw new RuntimeException("product "+product.getName() + " id "+ product.getId()+" is not available");
            if(product.getQuantity()<orderItem.getQuantity()) throw new RuntimeException("product "+product.getName()+" does not exist in the quantity needed");
            product.setQuantity(product.getQuantity()-orderItem.getQuantity());
            productRepository.save(product);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setTotalPrice(product.getPrice()*orderItem.getQuantity());
    
        });
        return orderItems;
    }

    private double calculateBasePrice(List<OrderItem> orderItems)
    {
        double bp=0;
        for(OrderItem orderItem : orderItems)
            bp+=orderItem.getTotalPrice();
        return bp;
    }

    public OrderCustom updateOrderCustom(OrderCustom order)
    {
        getOrderCustomById(order.getId());
        return orderRepository.save(order);
    }
    
    public OrderResponse getOrderCustomById(int orderId)
    {
        return new OrderResponse(orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("Order with this Id does not exist")));
    }

    public List<OrderCustom> getOrderCustomByBuyerId(int buyerId)
    {
        if(!buyerRepository.existsById(buyerId)) throw new RuntimeException("No such buyer with this id exists");
        return orderRepository.getOrderCustomByBuyerId(buyerId);
    }

    public List<OrderCustom> getOrderCustomByBasePrice(double basePrice)
    {
        return orderRepository.getOrderCustomByBasePrice(basePrice);
    }

    public List<OrderCustom> getOrderCustomByDeliveryPrice(double deliveryPrice)
    {
        return orderRepository.getOrderCustomByDeliveryPrice(deliveryPrice);
    }

    public List<OrderCustom> getOrderCustomByTotalPrice(double totalPrice)
    {
        return orderRepository.getOrderCustomByTotalPrice(totalPrice);
    }

    public List<OrderCustom> getOrderCustomByOrderState(OrderState orderState)
    {
        return orderRepository.getOrderCustomByOrderState(orderState);
    }

    public List<OrderCustom> getOrderCustomBySaasFee(double saasFee)
    {
        return orderRepository.getOrderCustomBySaasFee(saasFee);
    }
}
