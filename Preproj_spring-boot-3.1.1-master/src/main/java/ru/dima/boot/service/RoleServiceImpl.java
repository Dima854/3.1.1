package ru.dima.boot.service;

import org.springframework.stereotype.Service;
import ru.dima.boot.model.Role;
import ru.dima.boot.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void createRoles(Set<Role> roles) {
        roleRepository.saveAll(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(role -> set.add(role));
        return set;
    }
}
