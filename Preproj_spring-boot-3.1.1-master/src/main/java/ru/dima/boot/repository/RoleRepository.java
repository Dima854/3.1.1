package ru.dima.boot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dima.boot.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
