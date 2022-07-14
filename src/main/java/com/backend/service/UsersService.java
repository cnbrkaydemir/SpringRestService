package com.backend.service;

import com.backend.model.Orders;
import com.backend.model.Users;
import com.backend.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersService {


   private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findByUserId(int id){
    return usersRepository.findByUserId(id);
    }

    public Users findByUserEmail(String email){
        return usersRepository.findByUserEmail(email);
    }


    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users addUsers(Users user){
        usersRepository.save(user);
        System.out.println("User created:"+user.getUserName());
        return user;
    }

    public void deleteUsers(int id){
        String nameDeleted=usersRepository.findByUserId(id).getUserName();
        usersRepository.deleteById(id);
        System.out.println("Deleted user: "+nameDeleted);
    }

    public List<Orders> ordersOfUser(int id){
    Users target=usersRepository.findByUserId(id);

        System.out.println(target.getOrders().size());
    return target.getOrders();
    }



}
