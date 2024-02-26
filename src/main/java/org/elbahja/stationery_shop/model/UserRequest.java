package org.elbahja.stationery_shop.model;

public record UserRequest(String name, String username, String password) {
    public boolean hasEmptyFields() {
        return  name == null || username == null || password == null ||
                name.isBlank() || username.isBlank() || password.isBlank();
    }
}
