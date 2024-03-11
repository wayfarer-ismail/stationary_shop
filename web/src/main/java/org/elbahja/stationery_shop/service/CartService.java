package org.elbahja.stationery_shop.service;

import org.elbahja.stationery_shop.config.SecurityConfig;
import org.elbahja.stationery_shop.model.CartItem;
import org.elbahja.stationery_shop.model.UserDAO;
import org.elbahja.stationery_shop.repository.CartRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final SecurityConfig securityConfig;

    public CartService(CartRepository cartRepository, UserDetailsServiceImpl userDetailsService, SecurityConfig securityConfig) {
        this.cartRepository = cartRepository;
        this.userDetailsService = userDetailsService;
        this.securityConfig = securityConfig;
    }

    public void addToCart(Long itemId, int quantity) {
        Optional<UserDAO> user = findCurrentUser();
        user.ifPresent(userDAO -> cartRepository.save(new CartItem(userDAO.getId(), itemId, quantity)));
    }

    @Transactional
    public List<CartItem> getCart(Long userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public void removeFromCart(Long userId, Long itemId) {
        cartRepository.deleteByUserIdAndItemId(userId, itemId);
    }

    @Transactional
    public List<CartItem> getCartForCurrentUser() {
        Optional<UserDAO> user = findCurrentUser();
        if (user.isPresent()) {
            return getCart(user.get().getId());
        }
        return List.of();
    }

    private Optional<UserDAO> findCurrentUser() {
        Optional<UserDetails> userDetails = securityConfig.getCurrentUser();
        if (userDetails.isPresent()) {
            return userDetailsService.findByUsername(userDetails.get().getUsername());
        }
        return Optional.empty();
    }
}
