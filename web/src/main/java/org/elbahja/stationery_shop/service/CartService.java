package org.elbahja.stationery_shop.service;

import org.elbahja.stationery_shop.model.Cart;
import org.elbahja.stationery_shop.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(Long userId, Long itemId, int quantity) {
        Cart cart = new Cart(userId, itemId, quantity);
        cartRepository.save(cart);
    }

    public List<Cart> getCart(Long userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public void removeFromCart(Long userId, Long itemId) {
        cartRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}
