package com.vacaciones.services.adminActionsServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vacaciones.models.Role;
import com.vacaciones.models.User;
import com.vacaciones.repositories.UserRepository;

@Service
public class AdminCreateTeamsService {
    
    private UserRepository userRepository;

    public AdminCreateTeamsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User asignEmployesToResponsable(String idResponsable, String idUser){

        User responsableDB = userRepository.findByDocument(idResponsable).orElseThrow();
        User userDB = userRepository.findByDocument(idUser).orElseThrow();

        Set<User> employes = responsableDB.getEmployes();

        employes.add(userDB);

        responsableDB.setEmployes(employes);

        return userRepository.save(responsableDB);
    }

    public List<User> listUsers(String document){
        List<User> allUsers = userRepository.findAll();


        allUsers.removeIf(user -> user.getDocument().equals(document));

        return allUsers;
    }

    public Set<User> listEmployesOfResponsable(String document){
        User userDB = userRepository.findByDocument(document).orElseThrow();


        Set<User> employes = userDB.getEmployes();

        return employes;
    }

    public List<User> listAllResponsables(){
        List<User> allUsers = userRepository.findAll();
        List<User> responsable = new ArrayList<>();
        
        for (User user : allUsers) {
            if(isResponsable(user.getRoles())) responsable.add(user);
        }
        return responsable;
    }
    private boolean isResponsable(Set<Role> roles){

        for (Role role : roles) {
            if(role.getName().equals("ROLE_RESPONSABLE")) return true;
        }

        return false;
    }
}
