package com.vacaciones.services.adminActionsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Profile;
import com.vacaciones.models.School;
import com.vacaciones.models.User;
import com.vacaciones.payLoads.CreateUserPayload;
import com.vacaciones.repositories.ProfileRepository;
import com.vacaciones.repositories.SchoolRepository;
import com.vacaciones.repositories.UserRepository;
import com.vacaciones.services.baseServices.AdminService;

@Service
public class ProfileModificationsService implements AdminService<CreateUserPayload, String> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private UserRepository userRepository;

    private ProfileRepository profileRepository;

    public ProfileModificationsService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void delete(String id) {
 
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<CreateUserPayload> findAll() {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public CreateUserPayload update(String id, CreateUserPayload entity) {

        User userDB = userRepository.findByDocument(id).orElseThrow();

        Profile profileDB = modifyProfile(userDB.getProfile(), entity);

        modifySchooOfUser(userDB, entity.getLocation());

        userDB.setProfile(profileDB);

        profileRepository.save(profileDB);

        userRepository.save(userDB);

        CreateUserPayload response = new CreateUserPayload(userDB.getDocument(), profileDB.getFirstName()
        , profileDB.getLastName(), profileDB.getEmail(), null, profileDB.getHollydays(), profileDB.getPosition()
        , entity.getUserType(), entity.getLocation(), profileDB.getSingUpDate(), profileDB.getDateOfWithdrawal());

        return response;

    }

    private Profile modifyProfile(Profile profileToUpdate, CreateUserPayload payload){
        return profileRepository.findById(profileToUpdate.getId()).map(profileUpdate ->{
            profileUpdate.setFirstName(payload.getName());
            profileUpdate.setLastName(payload.getLastName());
            profileUpdate.setEmail(payload.getEmail());
            profileUpdate.setPosition(payload.getPosition());
            profileUpdate.setSingUpDate(payload.getSingInDate());
            profileUpdate.setDateOfWithdrawal(payload.getWithdrawalDate());
            return profileUpdate;
        }).orElseThrow();
    }
    
    public void fireUser(String document){
        User userDB = userRepository.findByDocument(document).orElseThrow();

        userDB.setContractedUser("inactive");

        userRepository.save(userDB);
    }

    public void restoreUser(String document){
        User userDB = userRepository.findByDocument(document).orElseThrow();

        userDB.setContractedUser("active");

        userRepository.save(userDB);
    }

    private void modifySchooOfUser(User userDB, String schoolName){
        /*  */
        removeUserOfSchools(userDB);
        
        School schoolOfUserDB = schoolRepository.findByName(schoolName).orElseThrow();

        schoolOfUserDB.addProfile(userDB.getProfile());

        schoolRepository.save(schoolOfUserDB);

    }
    private void removeUserOfSchools(User userDB){
        List<School> allShools = schoolRepository.findAll();
        
        for (School school : allShools) {
            if(userExistInSchool(school.getProfiles(), userDB.getProfile().getId())){
                school.getProfiles().remove(userDB.getProfile());
                schoolRepository.save(school);
            } 
        }
    }
    private boolean userExistInSchool(List<Profile> profilesOfSchool, Long id){

        for (Profile profile : profilesOfSchool) {
            if(profile.getId() == id) return true;
        }

        return false;
    }

}
