package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.model.CartItem;
import org.elbahja.stationery_shop.service.CartService;
import org.springframework.http.ResponseEntity;
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

        double totalPrice = cart.stream().mapToDouble(i -> i.getItem().getPrice() * i.getQuantity()).sum();
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("itemId") Long itemId) {
        // get user id from session
        cartService.addToCart(itemId, 1);
        return "redirect:/cart";
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
        System.out.println("remove");
        cartService.removeFromCart(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/increase/{id}")
    @ResponseBody
    public int increaseQuantity(@PathVariable Long id) {
        return cartService.increaseQuantity(id);
    }

    @PatchMapping("/decrease/{id}")
    @ResponseBody
    public int decreaseQuantity(@PathVariable Long id) {
        return cartService.decreaseQuantity(id);
    }
}
