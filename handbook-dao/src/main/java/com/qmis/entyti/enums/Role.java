package com.qmis.entyti.enums;

import java.util.Set;

import static java.util.Set.of;

public enum Role {
    USER(Set.of(Permission.USER)),
    MODERATOR(of(Permission.USER, Permission.MODERATE)),
    ADMIN(of(Permission.USER, Permission.MODERATE, Permission.ADMIN));
    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

//    public Set<SimpleGrantedAuthority> getAuthorities() {
//        return permissions.stream().map(p -> new SimpleGrantedAuthority(p.getPermission()))
//                .collect(Collectors.toSet());
//    }
}
