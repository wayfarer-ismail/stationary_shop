package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.model.UserRequest;
import org.elbahja.stationery_shop.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.http.HttpResponse;

@Controller
public class UserDetailsController {

    UserDetailsServiceImpl userDetailsServiceImpl;

    public UserDetailsController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @PostMapping("/register")
    public String registerUser(UserRequest userReq) {
        userDetailsServiceImpl.registerUser(userReq);
        return "redirect:/login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(UserRequest userReq) {
//        userDetailsServiceImpl.loadUserByUsername(userReq.username());
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
}
