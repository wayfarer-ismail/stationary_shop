package org.elbahja.stationery_shop.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class UserAdapter implements UserDetails {
    private String username;
    private String password;
    private String role;

    public UserAdapter(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserAdapter(UserDAO user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setRole(String role) {
    }

    public void setAccountNonLocked(boolean b) {
    }
}
