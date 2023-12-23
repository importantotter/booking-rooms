package com.example.bookingrooms.model;

import com.example.bookingrooms.model.permission.Permission;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.bookingrooms.model.permission.Permission.*;

public enum Role {

    ADMIN(Set.of(CREATE, READ, UPDATE, DELETE, WRITE)),
    MANAGER(Set.of(READ, UPDATE, DELETE)),
    USER(Set.of(READ, WRITE));
    private final Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
