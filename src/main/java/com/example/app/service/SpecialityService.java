package com.example.app.service;

import com.example.app.dao.SpecialityRepository;
import com.example.app.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;

    //GET ALL SPECIALITY
    public Iterable<Speciality> getSpecialities() {
        return specialityRepository.findAll();
    }

    //POST SPECIALITY
    public Speciality addSpeciality(Speciality speciality){
        Speciality savedSpeciality = specialityRepository.save(speciality);
        return savedSpeciality;
    }

    // GET SPECIALITY BY ID
    public Optional<Speciality> getSpeciality(int id) {
        return  specialityRepository.findById(Long.valueOf(id));
    }

    //DELETE SPECIALITY (ID)
    public Optional<Speciality> deleteSpeciality(final Long id) {
        specialityRepository.deleteById(id);
        return null;
    }

}
