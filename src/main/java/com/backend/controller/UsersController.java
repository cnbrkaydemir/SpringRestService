package com.backend.controller;

import com.backend.exception.UsersNotFoundException;
import com.backend.model.Orders;
import com.backend.model.Users;
import com.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UsersController {

   private final UsersService usersService;

   @Autowired
   public UsersController(UsersService usersService){
       this.usersService=usersService;
   }

   @GetMapping("/api/users")
   public List<Users> retrieveAllUsers(){
       return usersService.findAll();
   }


    @GetMapping(path="/api/get-user/{id}")
    public Users getUser(@PathVariable int id){
       Users user=usersService.findByUserId(id);

       if(user==null){
           throw  new UsersNotFoundException("Could not find user with id-"+id);
       }

       return user;
    }

    @GetMapping(path="/api/get-user-orders/{id}")
    public List<Orders> getOrders(@PathVariable int id){
        return usersService.ordersOfUser(id);
   }


    @PostMapping(path="/api/add-user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
        Users temp=usersService.addUsers(user);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(temp.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path="/api/delete-user/{id}")
    public void deleteUser(@PathVariable Integer id){
        usersService.deleteUsers(id);
        System.out.println("Deleted the user with id:"+id);
    }


    }




