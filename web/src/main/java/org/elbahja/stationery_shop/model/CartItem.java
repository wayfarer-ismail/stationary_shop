package org.elbahja.stationery_shop.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long itemId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "id", insertable = false, updatable = false)
    private CatalogueItem item;

    public CartItem(Long userId, Long itemId, int quantity) {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public CartItem() {
    }

}
