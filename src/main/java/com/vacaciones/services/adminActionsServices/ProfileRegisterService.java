package com.vacaciones.services.adminActionsServices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Profile;
import com.vacaciones.models.Role;
import com.vacaciones.models.School;
import com.vacaciones.models.User;
import com.vacaciones.payLoads.CreateUserPayload;
import com.vacaciones.repositories.ProfileRepository;
import com.vacaciones.repositories.SchoolRepository;
import com.vacaciones.repositories.UserRepository;

@Service
public class ProfileRegisterService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    private UserRepository userRepository;

    public ProfileRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUserAndProfile(CreateUserPayload payload) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodePassword = encoder.encode(payload.getPassword());

        String typeUser = payload.getUserType();


        Set<Role> rolesToUser = chooseRolesForNewUser(typeUser);

        User userToSave = new User(payload.getDocument(), encodePassword, rolesToUser );
        Profile profileToSave = new Profile(null, payload.getName(), payload.getLastName(), payload.getPosition(),
                payload.getEmail(), payload.getSingInDate(), payload.getWithdrawalDate(), payload.getHolyDays());

        School schoolDB = schoolRepository.findByName(payload.getLocation()).orElseThrow();

        schoolDB.addProfile(profileToSave);

        userToSave.setProfile(profileToSave);

        profileRepository.save(profileToSave);

        schoolRepository.save(schoolDB);

        User userDB = userRepository.save(userToSave);

        return userDB;
    }

    private Set<Role> chooseRolesForNewUser(String selector) {
        
        
        Set<Role> roles = new HashSet<>();
        Role adminRole = new Role(1L, "ROLE_ADMIN");
        Role userRole = new Role(2L, "ROLE_USER");
        Role responsableRole = new Role(3L, "ROLE_RESPONSABLE");
        
        System.out.println(selector);
        if(selector.equals("Empleado")) roles.add(userRole);  
        if(selector.equals("Responsable")) { 
            roles.add(responsableRole);
            roles.add(userRole);
        }
        if(selector.equals("Admin")) {
            roles.add(adminRole);
        }

        return roles;
    }
}
