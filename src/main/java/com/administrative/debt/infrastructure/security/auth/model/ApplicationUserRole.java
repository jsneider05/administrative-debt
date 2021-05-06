package com.administrative.debt.infrastructure.security.auth.model;

import static com.administrative.debt.infrastructure.security.auth.model.ApplicationUserPermission.DEBT_READ;
import static com.administrative.debt.infrastructure.security.auth.model.ApplicationUserPermission.DEBT_CREATE;
import static com.administrative.debt.infrastructure.security.auth.model.ApplicationUserPermission.DEBT_DELETE;
import static com.administrative.debt.infrastructure.security.auth.model.ApplicationUserPermission.DEBT_UPDATE;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(DEBT_CREATE, DEBT_READ, DEBT_UPDATE, DEBT_DELETE)),
    ADMINTRAINEE(Sets.newHashSet(DEBT_READ, DEBT_UPDATE)),
    USER(Sets.newHashSet(DEBT_READ));

    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
