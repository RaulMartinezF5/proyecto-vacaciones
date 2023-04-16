package com.vacaciones.services.responsableActionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.models.Request;
import com.vacaciones.models.User;
import com.vacaciones.repositories.RequestRepository;
import com.vacaciones.repositories.UserRepository;

@Service
public class StateRequestsService {

    @Autowired
    private UserRepository userRepository;
    
    private RequestRepository requestRepository;

    public StateRequestsService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void changeState(String idUser, Long idRequest, String newstate){

        User userDB = userRepository.findByDocument(idUser).orElseThrow();

        Request requestToUpdate = findRequestInUser(userDB, idRequest);

        requestToUpdate.setState(newstate);

        List<Request> updatedList = updateListRequest(userDB.getRequests(), requestToUpdate);
        
        userDB.setRequests(updatedList);

        if(newstate.equals("Accept")) userDB.getProfile().setHollydays(userDB.getProfile().getHollydays()-requestToUpdate.getQuantityOfDays());

        requestRepository.save(requestToUpdate);

        userRepository.save(userDB);

    }
    private Request findRequestInUser(User userToFind, Long idRequest){

        for (Request request : userToFind.getRequests()) {
            
            if(request.getId()==idRequest) return request;
        }
        
        return null;
    }

    private List<Request> updateListRequest(List<Request> list, Request requestUpdate){
        int index = list.indexOf(requestUpdate);

        list.get(index).setState(requestUpdate.getState());

        return list;
    }
}
