package com.example.bookingrooms.security;

import com.example.bookingrooms.model.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SecurityCustomer implements UserDetails {
    private final String firstName;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;

    public SecurityCustomer(String firstName, String password, List<SimpleGrantedAuthority> authorities) {
        this.firstName = firstName;
        this.password = password;
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityCustomer that = (SecurityCustomer) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(password, that.password) && Objects.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, password, authorities);
    }

    @Override
    public String toString() {
        return "SecurityCustomer{" +
                "username='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
    public static UserDetails fromUser(Customer customer) {
        return new org.springframework.security.core.userdetails.User(
                customer.getEmail(),
                customer.getPassword(),
                customer.getRole().getAuthorities()
        );
    }
}
