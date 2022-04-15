package com.qmis.entyti.enums;

public enum Permission {
    USER("user:read,search"),
    MODERATE("user:moderate"),
    ADMIN("user:administrate");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
