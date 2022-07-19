package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@EnableWebSecurity(debug = true)
@EnableJpaRepositories("com.backend.repository")
@EntityScan("com.backend.model")
@ComponentScans({ @ComponentScan("com.backend.controller"), @ComponentScan("com.backend.config")})
public class UserRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRestApplication.class, args);
    }

}
