package com.vacaciones.services.detailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vacaciones.models.security.SecurityUser;
import com.vacaciones.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifyDocument) throws UsernameNotFoundException {
        return repository.findByDocument(identifyDocument)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("document not found" + identifyDocument));
    }

}
