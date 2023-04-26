package com.vacaciones.services;

import java.util.List;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vacaciones.models.User;
import com.vacaciones.repositories.UserRepository;
import com.vacaciones.services.baseServices.AdminService;
import com.vacaciones.services.baseServices.BasicService;

@Service
public class UserService implements BasicService<User>, AdminService<User, String> {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());

        user.setPassword(encodePassword);
        user.setContractedUser("active");

        repository.save(user);
    }

    public User findByDocument(String id) {
        return repository.findByDocument(id).orElseThrow();
    }

    @Override
    public void delete(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<User> findAll() {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public User update(String id, User entity) {
        return repository.findById(id).map(userUpdate -> {
            userUpdate.setPassword(entity.getPassword());
            return repository.save(userUpdate);
        }).orElseThrow();
    }

}
