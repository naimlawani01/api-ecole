package com.example.app.service;

import com.example.app.dao.EcoleRepository;
import com.example.app.model.Ecole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcoleService {

    @Autowired
    private EcoleRepository ecoleRepository;

    //Add a Get method for getting every data
    public Iterable<Ecole> getEcole() {
        return ecoleRepository.findAll();
    }


    //Add a Post method for sending data
    public Ecole addEcole(Ecole Ecole){
        Ecole savedEcole = ecoleRepository.save(Ecole);
        return savedEcole;
    }


    // Add a Get by id method, for getting data with number id
    public Optional<Ecole> getEcole(Long id) {
        return  ecoleRepository.findById(Long.valueOf(id));
    }


    //Delete method, for deleting every post you've done
    public Optional<Ecole> deleteEcole(final Long id) {
        ecoleRepository.deleteById(id);
        return null;
    }


}
