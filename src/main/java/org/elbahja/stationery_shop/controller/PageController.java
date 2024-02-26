package org.elbahja.stationery_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
