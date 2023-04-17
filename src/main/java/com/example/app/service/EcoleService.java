package com.example.app.service;

import com.example.app.dao.ClassroomRepository;
import com.example.app.dao.EcoleRepository;
import com.example.app.model.Classroom;
import com.example.app.model.Ecole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EcoleService {

    @Autowired
    private EcoleRepository ecoleRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    //Add a Get method for getting every data
    public Iterable<Ecole> getEcoles() {
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

//    public Iterable<Classroom> getEcoleClassrooms(Integer integer) {
//        return eco
//    }

    public List<Classroom> getEcoleClassrooms(Integer id) {

        List<Object[]> result = classroomRepository.findAllByEcoleId(Long.valueOf(id));
        List<Classroom> classrooms = new ArrayList<>();
        for (Object[] row : result) {
            classrooms.add(new Classroom((Long) row[0], (String) row[1], (Integer) row[2], (String) row[3], (Ecole) row[4]));
        }
        return classrooms;
    }

}
