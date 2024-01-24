package com.example.ecommerce.controllers.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.services.order.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/allOrders")
    public ResponseEntity<List<OrderCustom>> getOrderCustom() 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderCustom> createOrderCustom(@PathVariable OrderCustom orderCustom) 
    {
        return new ResponseEntity<OrderCustom>(orderService.createOrderCustom(orderCustom), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateOrder")
    public ResponseEntity<OrderCustom> updateOrderCustom(@RequestBody OrderCustom order) 
    {
        return new ResponseEntity<OrderCustom>(orderService.updateOrderCustom(order), HttpStatus.OK);
    }

    @GetMapping("/getOrderCustomById/{orderCustomId}")
    public ResponseEntity<OrderCustom> getOrderCustomById(@PathVariable int orderCustomId)
    {
        return new ResponseEntity<OrderCustom>(orderService.getOrderCustomById(orderCustomId), HttpStatus.OK);
    }
    
    @GetMapping("/getOrderCustomByBuyerId/{buyerId}")
    public ResponseEntity<List<OrderCustom>> getOrderCustomByBuyerId(@PathVariable int buyerId) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomByBuyerId(buyerId), HttpStatus.OK);
    }

    @GetMapping("/getOrderCustomByBasePrice/{basePrice}")
    public ResponseEntity<List<OrderCustom>> getOrderCustomByBasePrice(@PathVariable double basePrice) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomByBasePrice(basePrice), HttpStatus.OK);
    }

    @GetMapping("/getOrderCustomByDeliveryPrice/{deliveryPrice}")
    public ResponseEntity<List<OrderCustom>> geOrderCustomByDeliveryPrice(@PathVariable double deliveryPrice) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomByDeliveryPrice(deliveryPrice), HttpStatus.OK);
    }
    
    @GetMapping("/getOrderCustomByTotalPrice/{totalPrice}")
    public ResponseEntity<List<OrderCustom>> getOrderCustomByTotalPrice(@PathVariable double totalPrice) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomByTotalPrice(totalPrice), HttpStatus.OK);
    }

    @GetMapping("/getOrderCustomByOrderState/{orderState}")
    public ResponseEntity<List<OrderCustom>> getOrderCustomByOrderState(@PathVariable OrderState orderState) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomByOrderState(orderState), HttpStatus.OK);
    }
    
    @GetMapping("/getOrderCustomBySaasFee/{saasFee}")
    public ResponseEntity<List<OrderCustom>> getOrderCustomBySaasFee(@PathVariable double saasFee) 
    {
        return new ResponseEntity<List<OrderCustom>>(orderService.getOrderCustomBySaasFee(saasFee), HttpStatus.OK);
    }
    
}
