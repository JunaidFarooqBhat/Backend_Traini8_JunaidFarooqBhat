package com.buyogo.assessment.Service;

import com.buyogo.assessment.Model.TraningCenter;
import com.buyogo.assessment.Repo.TraningCenterRepo;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Service

public class TraningCenterService {

    @Autowired
    private TraningCenterRepo traningCenterRepo;

    public TraningCenter createNewTraningCenter(TraningCenter newTraningCenter) {

        newTraningCenter.setCreatedOn(new Date());
        traningCenterRepo.save(newTraningCenter);
        return newTraningCenter;

    }

    public List<TraningCenter> getCenters() {

        List<TraningCenter> traningCenters= traningCenterRepo.findAll();
        return traningCenters;

    }
}
