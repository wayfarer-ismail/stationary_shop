package org.elbahja.stationery_shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Base64;
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
    @Lob
    private byte[] image;

    public CatalogueItem(String name, String description, double price, byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getImageBase64() {
        return Base64.getEncoder().encodeToString(image);
    }
}
