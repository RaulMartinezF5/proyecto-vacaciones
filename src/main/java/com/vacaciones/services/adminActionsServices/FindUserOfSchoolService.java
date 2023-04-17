package com.vacaciones.services.adminActionsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Profile;
import com.vacaciones.models.School;
import com.vacaciones.models.User;
import com.vacaciones.repositories.SchoolRepository;
import com.vacaciones.repositories.UserRepository;

@Service
public class FindUserOfSchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    private UserRepository userRepository;

    public FindUserOfSchoolService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public School schoolOfUser(String document){

        User userDB = userRepository.findByDocument(document).orElseThrow();
        List<School> schoolsDB = listAllSchools();

        for (School school : schoolsDB) {
            if(userExistInSchool(school.getProfiles(), userDB.getProfile().getId())) return school;
        }

        return null;
    }

    private boolean userExistInSchool(List<Profile> profilesOfSchool, Long id){

        for (Profile profile : profilesOfSchool) {
            if(profile.getId() == id) return true;
        }

        return false;
    }

    private List<School> listAllSchools(){
        return schoolRepository.findAll();
    }
}
