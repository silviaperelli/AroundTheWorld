package com.example.aroundtheworld.appcontroller;

import com.example.aroundtheworld.bean.ResidenceRequestBean;
import com.example.aroundtheworld.dao.ResidenceDAO;
import com.example.aroundtheworld.dao.ResidenceRequestDAO;
import com.example.aroundtheworld.exception.DuplicateRequestException;
import com.example.aroundtheworld.exception.MessageException;
import com.example.aroundtheworld.exception.NotFoundException;
import com.example.aroundtheworld.model.Residence;
import com.example.aroundtheworld.model.ResidenceRequest;

import java.time.LocalDate;

public class BookingResidenceController {
    public void sendRequest(ResidenceRequestBean residenceRequestBean) throws NotFoundException, MessageException,  DuplicateRequestException {
        checkRequestDate(residenceRequestBean.getArrival(), residenceRequestBean.getDeparture());
        Residence residence = ResidenceDAO.retrieveResidence(residenceRequestBean.getCity());
        ResidenceRequest residenceRequest = new ResidenceRequest(residenceRequestBean.getCity(), residenceRequestBean.getArrival(), residenceRequestBean.getDeparture(), residenceRequestBean.getRoom(), residenceRequestBean.getIdStudent(), 0);
        residenceRequest.setIdResidence(residence.getId());
        ResidenceRequestDAO.newRequest(residenceRequest);
    }

    private void checkRequestDate(String arrival, String departure) throws MessageException {
        LocalDate dateA = LocalDate.parse(arrival);
        LocalDate dateD = LocalDate.parse(departure);
        LocalDate currentDate = LocalDate.now();

        if(dateA.isBefore(currentDate.plusDays(7))){
            throw new MessageException("Arrival must be at least \n 7 days from today!");
        }
        if(dateD.isBefore(dateA.plusDays(7))){
            throw new MessageException("Departure must be at least \n 7 days from arrival!");
        }
    }
}
