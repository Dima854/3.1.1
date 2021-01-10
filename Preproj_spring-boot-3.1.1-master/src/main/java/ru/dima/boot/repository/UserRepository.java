package ru.dima.boot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dima.boot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}

