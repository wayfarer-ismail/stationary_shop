package org.elbahja.stationery_shop.repository;

import org.elbahja.stationery_shop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUserId(Long userId);

    void deleteByUserIdAndItemId(Long userId, Long itemId);
}
