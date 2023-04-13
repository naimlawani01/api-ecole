package com.example.app.service;

import com.example.app.dao.VoitureRepository;
import com.example.app.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    //Get ALL Voiture
    public Iterable<Voiture> getVoitures() {
        return voitureRepository.findAll();
    }
    //Post voiture
    public Voiture addVoiture(Voiture voiture){
        Voiture savedVoiture = voitureRepository.save(voiture);
        return savedVoiture;
    }
    // Get voiture by id
    public Optional<Voiture> getVoiture(int id) {
        return  voitureRepository.findById(Long.valueOf(id));
    }

    //Delete Voiture (id)
    public Optional<Voiture> deleteVoiture(final Long id) {
        voitureRepository.deleteById(id);
        return null;
    }
}
