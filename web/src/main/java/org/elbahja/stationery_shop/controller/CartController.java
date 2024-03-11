package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.model.CartItem;
import org.elbahja.stationery_shop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String cart(Model model) {
        List<CartItem> cart = cartService.getCartForCurrentUser();
        model.addAttribute("cartItems", cart);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("itemId") Long itemId) {
        // get user id from session
        cartService.addToCart(itemId, 1);
        return "redirect:/cart";
    }
}
