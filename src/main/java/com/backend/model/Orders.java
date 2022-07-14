package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = {"user"})
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_item")
    @Size(min =4, message = "Minimum 4 characters")
    @NotBlank(message = "Item cannot be empty")
    private String orderItem;


    @Column(name = "order_price")
    private double orderPrice;


    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn(name = "user_id")
    private Users user;


    public Orders(int orderId, String orderItem, double orderPrice) {
        this.orderId = orderId;
        this.orderItem = orderItem;
        this.orderPrice = orderPrice;
    }

    public Orders(){

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
