package ru.dima.boot.service;

import ru.dima.boot.model.Role;

import java.util.Set;

public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}
