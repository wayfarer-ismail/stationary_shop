package org.elbahja.stationery_shop.service;

import org.elbahja.stationery_shop.model.CartItem;
import org.elbahja.stationery_shop.model.UserDAO;
import org.elbahja.stationery_shop.repository.CartRepository;
import org.elbahja.stationery_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminService {

    @Autowired
    private CartRepository cartRepository;

//    @Autowired
//    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CartItem> getAllCarts() {
        return cartRepository.findAll();
    }

    public Map<Long, List<CartItem>> getAllCartsGroupedByUserId() {
        return cartRepository.findAll().stream()
                .collect(Collectors.groupingBy(CartItem::getUserId));
    }

//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }

    public List<UserDAO> getAllAccounts() {
        return userRepository.findAll();
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

//    public void deleteOrder(Long id) {
//        orderRepository.deleteById(id);
//    }
//
    public void deleteAccount(Long id) {
        userRepository.deleteById(id);
    }
}