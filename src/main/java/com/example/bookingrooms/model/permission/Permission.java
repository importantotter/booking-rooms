package com.example.bookingrooms.model.permission;

public enum Permission {
    CREATE("create"),
    READ("read"),
    UPDATE("update"),
    DELETE("delete"),
    WRITE("write");
    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}
