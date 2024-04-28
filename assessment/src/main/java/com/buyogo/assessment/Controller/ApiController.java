package com.buyogo.assessment.Controller;

import com.buyogo.assessment.Model.TraningCenter;
import com.buyogo.assessment.Service.TraningCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@Validated
public class ApiController {

     @Autowired
    TraningCenterService traningCenterService;

     // This api is to create the new training center.
    //it validates the all properties if validation fails it will throw exception
    @PostMapping("trainingcenter")
    public ResponseEntity<TraningCenter> createNewTraningCenter
    (@Valid @RequestBody TraningCenter newTraningCenter, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Validation exception");
            }

            var respTS= traningCenterService.createNewTraningCenter(newTraningCenter);
            return ResponseEntity.status(HttpStatus.OK).body(respTS);

        }catch (Exception e){

            var respTS= traningCenterService.createNewTraningCenter(newTraningCenter);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respTS);
        }

    }

    //this api is used to get the traning centers
    // It also uses filters on the basis of limit,pincode and state,
     // means you can find the traning center by pincode, state, or you get the limited results using limit
    // NOTE:- the above mentioned filter properties are not required to get results they are optional
    @GetMapping("getcenters")
    public List<TraningCenter> getCenters
    (@RequestParam(required = false) String state, @RequestParam(required = false) Integer pincode,
     @RequestParam(required = false, defaultValue = "10") int limit){
        List<TraningCenter> traningCenters= traningCenterService.getCenters();
        boolean checkCentersEmpty=false;

        //here i am appling the filter on the bases of state means give me traning centers of any particular state
        if(state!=null && !state.isEmpty()){

            traningCenters = traningCenters.stream()
                    .filter(center -> center.getAddress().getState().equalsIgnoreCase(state))
                    .collect(Collectors.toList());


            if(traningCenters.isEmpty()){
                checkCentersEmpty=true;
            }
        }
        //this filter filters the result on the basis of pincode
        if(pincode!=null){

            traningCenters = traningCenters.stream()
                    .filter(center -> center.getAddress().getPinCode().equals(pincode))
                    .collect(Collectors.toList());

        }

        //this one is to get the limited results
        if (!checkCentersEmpty && limit > 0 && limit <= traningCenters.size()) {
            return traningCenters.subList(0,limit);
        } else {
            return traningCenters; // Return all traningCenters if limit is invalid or not provided
        }

    }
}
