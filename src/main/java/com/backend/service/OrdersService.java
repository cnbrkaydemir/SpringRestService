package com.backend.service;

import com.backend.model.Orders;
import com.backend.model.Users;
import com.backend.repository.OrdersRepository;
import com.backend.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, UsersRepository usersRepository) {

        this.ordersRepository = ordersRepository;
        this.usersRepository=usersRepository;
    }


    public Orders findByOrdersId(int id){
        return ordersRepository.findByOrderId(id);
    }

    public List<Orders> findByPricesGreater(double target){
        return ordersRepository.findByOrderPriceGreaterThan(target);
    }


    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public List<Orders> findByUser(Users user){
        return ordersRepository.findByUser(user);
    }


    public Orders addOrders(Orders orders){
        Orders temp=ordersRepository.save(orders);
        System.out.println("Order created:"+temp.getOrderItem());
        return temp;
    }

    public void deleteOrders(int id){
        String itemDeleted=ordersRepository.findByOrderId(id).getOrderItem();
        ordersRepository.deleteById(id);
        System.out.println("Deleted Order: "+itemDeleted);
    }

    public List<Orders> findByItemNameLike(String s){
        return ordersRepository.findByOrderItemIsLike(s);
    }

    public List<Orders> findAllBYOrderItem(String item){
        return ordersRepository.findAllByOrderItem(item);
    }
    public Orders greatestPrice(double amount){
        return ordersRepository.findFirstByOrderPrice(amount);
    }

    public List<Orders> OrdersBetween(double start,double end){
        return ordersRepository.findByOrderPriceBetween(start,end);
    }

    public void linkUser(int orderId,int userId){
        Orders order=ordersRepository.findByOrderId(orderId);
        Users user=usersRepository.findByUserId(userId);
        order.setUser(user);
        ordersRepository.save(order);

    }

    public Users findOrderUser(int id){
        Orders order=ordersRepository.findByOrderId(id);
        return order.getUser();
    }




}
