package org.elbahja.stationery_shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;

    public UserDAO() {
    }

    public UserDAO(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

}
