package com.backend.repository;

import com.backend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findAllByOrderItem(String item);

    Orders findByOrderId(int id);

    List<Orders> findByOrderPriceGreaterThan(double target);

    List<Orders> findByOrderItemIsLike(String isLike);

    Orders findFirstByOrderPrice(@NotBlank(message = "Price cannot be 0") double orderPrice);

    List<Orders> findByOrderPriceBetween(double start,double end);






}
