package com.administrative.debt.infrastructure.security.auth.model;

public enum ApplicationUserPermission {
    DEBT_CREATE("debt:create"),
    DEBT_READ("debt:read"),
    DEBT_UPDATE("debt:update"),
    DEBT_DELETE("debt:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
