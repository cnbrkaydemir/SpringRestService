
package com.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         * Custom configurations as per our requirement
         */
        http.authorizeHttpRequests((auth) -> auth
                .antMatchers("/api", "/myProfile", "/myOrders", "/newOrder").authenticated()
                .antMatchers("/home","/singup").permitAll()
        ).formLogin().and().httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
