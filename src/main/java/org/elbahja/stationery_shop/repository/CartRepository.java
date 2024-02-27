package org.elbahja.stationery_shop.repository;

import org.elbahja.stationery_shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(Long userId);

    void deleteByUserIdAndItemId(Long userId, Long itemId);
}
