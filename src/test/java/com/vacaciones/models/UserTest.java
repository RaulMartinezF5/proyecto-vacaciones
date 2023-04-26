package com.vacaciones.models;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.vacaciones.repositories.RoleRepository;
import com.vacaciones.repositories.UserRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void test_user_have_roles(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("12345");
        
        Role role = new Role(null, "ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User("1234567L", password, roles);

        roleRepository.save(role);
        userRepository.save(user);

        User userDB = entityManager.find(User.class, user.getDocument());

        assertThat(userDB.getDocument(), equalTo("1234567L"));
        assertThat(userDB.getRoles().size(), equalTo(1));
    }
}
