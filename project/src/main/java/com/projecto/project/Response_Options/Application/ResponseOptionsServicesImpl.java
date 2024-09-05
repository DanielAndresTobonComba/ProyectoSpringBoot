package com.projecto.project.Response_Options.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Response_Options.Domain.IResponseOptions;
import com.projecto.project.Response_Options.Domain.ResponseOptions;
import com.projecto.project.Response_Options.Infrasctructure.ResponseOptionsRepository;

@Service
public class ResponseOptionsServicesImpl implements IResponseOptions {

    @Autowired
    ResponseOptionsRepository responseOptionsRepository;

    @Override
    public ResponseOptions createOne(ResponseOptions responseOption) {
        
        return  responseOptionsRepository.save(responseOption);
    }

}
