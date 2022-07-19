package com.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/home","/"})
    public String HelloEveryOne() {
        return "hello.html";
    }

    @GetMapping(value = "/user")
    public String LoggedIn() {
        return "Home.html";
    }

}
