package org.elbahja.stationery_shop.model;

public record UserRequest(String username, String password) {
    public boolean hasEmptyFields() {
        return  username == null || password == null ||
                username.isBlank() || password.isBlank();
    }
}
