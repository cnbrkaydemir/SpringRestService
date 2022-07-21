package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="users")
@JsonIgnoreProperties(value = {"authorities","userPassword","userId"})
public class Users  {
    @Id
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_email")
    @Size(min=6, message = "Email should be at least 6 characters")
    @NotBlank
    private String userEmail;

    @Column(name = "user_password")
    @Size(min=5, message = "Password should be at least 5 characters")
    @NotBlank
    private String userPassword;


    @Column(name = "user_name")
    @NotBlank
    private String userName;


    @Column(name = "user_city")
    @NotBlank
    private String userCity;


    @Column(name = "user_phone")
    @Size(min=10,max = 15, message = "Inappropriate length of phone number")
    @NotBlank
    private String userPhone;



    @Column(name="role")
    @NotBlank
    private String role;

    @OneToMany(mappedBy = "user",targetEntity = Orders.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Orders> orders;


    @OneToMany(mappedBy="users",fetch=FetchType.EAGER)
    private Set<Authority> authorities;


    public Users() {
    }



    public Users(int userId, String userEmail, String userPassword, String userName, String userCity, String userPhone) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userCity = userCity;
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
