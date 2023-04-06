package com.vacaciones.services.employeActionsService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Request;
import com.vacaciones.models.User;
import com.vacaciones.repositories.RequestRepository;
import com.vacaciones.repositories.UserRepository;
import com.vacaciones.services.baseServices.AdminService;

@Service
public class RequestGestionService implements AdminService<Request>{

    @Autowired
    private UserRepository userRepository;

    private RequestRepository requestRepository;

    
    public RequestGestionService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public void delete(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Request> findAll() {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Request update(Long id, Request entity) {

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    public Request findById(String idUser, Long idRequest) {

        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    public User save(Request entity, String idUser) {
        
        User userDB = userRepository.findByDocument(idUser).orElseThrow();

        Set<Request> requestList = new HashSet<>();

        requestList.add(entity);

        userDB.setRequests(requestList);

        requestRepository.save(entity);

        return userRepository.save(userDB);
    }
    
}
