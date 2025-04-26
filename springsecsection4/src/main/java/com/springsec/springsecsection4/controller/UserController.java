package com.springsec.springsecsection4.controller;

import com.springsec.springsecsection4.model.Customer;
import com.springsec.springsecsection4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    public ResponseEntity<String> resgisterUser(@RequestBody Customer customer) {
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("gIVEN USER dETAILS are saved succesfully".toLowerCase());
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User Registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured: " + ex.getMessage());
        }
    }

}
