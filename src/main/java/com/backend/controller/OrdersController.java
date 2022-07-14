package com.backend.controller;

import com.backend.exception.OrdersNotFoundException;
import com.backend.model.Orders;
import com.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping(path = "/api/orders")
    public List<Orders> findAll(){
        return ordersService.findAll();
    }

    @GetMapping(path="/api/get-order/{id}")
    public Orders getOrder(@PathVariable int id){
        Orders order=ordersService.findByOrdersId(id);

        if(order==null){
            throw  new OrdersNotFoundException("Could not find order with id-"+id);
        }

        return order;
    }

    @GetMapping(path="/api/get-order-users/{orderId}")
    public String getUserOfOrder(@PathVariable int orderId) {
        Orders target=ordersService.findByOrdersId(orderId);
        return target.getUser().getUserName();
    }

    @PostMapping(path="/api/add-order")
    public ResponseEntity<Object> createOrder(@Valid @RequestBody Orders order) {
        Orders temp=ordersService.addOrders(order);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(temp.getOrderId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping(path="/api/link-order-users/{orderId}/{userId}")
    //Method for filling the user foreign key of order
    public void LinkUser(@PathVariable int orderId,
                                             @PathVariable int userId) {

        ordersService.linkUser(orderId,userId);

    }


    @DeleteMapping(path="/api/delete-order/{id}")
    public void deleteOrder(@PathVariable Integer id){
        ordersService.deleteOrders(id);
        System.out.println("Deleted the order with id:"+id);
    }

}
