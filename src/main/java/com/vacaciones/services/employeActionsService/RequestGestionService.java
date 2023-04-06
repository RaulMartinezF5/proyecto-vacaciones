package com.vacaciones.services.employeActionsService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Cause;
import com.vacaciones.models.Request;
import com.vacaciones.models.TypeOfRequest;
import com.vacaciones.models.User;
import com.vacaciones.payLoads.CreateRequestPayload;
import com.vacaciones.repositories.CauseRepository;
import com.vacaciones.repositories.RequestRepository;
import com.vacaciones.repositories.TypeOfRequestRepository;
import com.vacaciones.repositories.UserRepository;
import com.vacaciones.services.baseServices.AdminService;

@Service
public class RequestGestionService implements AdminService<Request>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CauseRepository causeRepository;

    @Autowired
    private TypeOfRequestRepository typeOfRequestRepository;

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


    public User save(CreateRequestPayload entity, String idUser) {

        Cause causeDB = causeRepository.findByDescription(entity.getDescriptionCauseRequest()).orElseThrow();
        
        Request requestToCreate = new Request(null, entity.getIssue(), entity.getState(), entity.getStartDate(), entity.getEndDate());

        Set<Cause> listCauseToRequest = new HashSet<>();
        listCauseToRequest.add(causeDB);

        requestToCreate.setCauses(listCauseToRequest);

        User userDB = userRepository.findByDocument(idUser).orElseThrow();

        List<Request> requestList = new ArrayList<>();

        requestList.add(requestToCreate);

        userDB.setRequests(requestList);

        TypeOfRequest typeOfRequestDB = typeOfRequestRepository.findByName(entity.getNameTypeOfRequest()).orElseThrow();

        typeOfRequestDB.addRequest(requestToCreate);

        requestRepository.save(requestToCreate);
        typeOfRequestRepository.save(typeOfRequestDB);

        return userRepository.save(userDB);

    }
    
}
