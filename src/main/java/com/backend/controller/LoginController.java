package com.backend.controller;

import com.backend.model.Users;
import com.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/user")
    public Users getUserDetailsAfterLogin(Principal user) {
        List<Users> customers = usersRepository.findByUserName(user.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }

    }

}