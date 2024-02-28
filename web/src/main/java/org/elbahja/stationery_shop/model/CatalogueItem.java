package org.elbahja.stationery_shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CatalogueItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public CatalogueItem(String name, String description, double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
