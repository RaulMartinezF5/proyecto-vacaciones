package com.vacaciones.services.detailsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vacaciones.models.Role;
import com.vacaciones.models.User;
import com.vacaciones.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class JpaUserDetailsServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks 
    JpaUserDetailsService jpaUserDetailsService;

    @BeforeEach
    void setup(){

    }

    @Test
    void load_user_by_document(){
        String document ="1234567L";

        Set<Role> roles = new HashSet<>();

        Role role = new Role(1L, "ROLE_ADMIN");
        
        roles.add(role);

        User user = new User("1234567L", "password", roles);
        
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());

        when(userRepository.findByDocument(document)).thenReturn(Optional.of(user));

        UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(document);

        assertThat(userDetails, is(notNullValue()));
        assertThat(userDetails.getUsername(), equalTo(document));
        assertThat(userDetails.getPassword(), equalTo("password"));
        assertThat(userDetails.getAuthorities().size(), is(equalTo(1)));
        assertThat(userDetails.getAuthorities(), contains(authority));

    }
}
