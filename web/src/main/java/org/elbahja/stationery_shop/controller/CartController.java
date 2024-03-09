package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String cart() {
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("itemId") Long itemId) {
        // get user id from session
        cartService.addToCart(0L, itemId, 1);
        return "redirect:/cart";
    }
}
