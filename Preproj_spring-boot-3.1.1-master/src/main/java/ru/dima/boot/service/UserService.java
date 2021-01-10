package ru.dima.boot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.dima.boot.model.User;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void createUser(User user);
    Iterable<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUserById(Long id);
}
