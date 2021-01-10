package ru.dima.boot.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dima.boot.model.User;
import ru.dima.boot.model.Role;
import ru.dima.boot.repository.RoleRepository;
import ru.dima.boot.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public SetupDataLoader (UserRepository userRepository,
                            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role[] rolesArray = new Role[]{new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.addAll(Arrays.asList(rolesArray));
        roleRepository.saveAll(rolesSet);
        User admin = new User("admin", "admin", rolesSet);
        userRepository.save(admin);
    }
}
