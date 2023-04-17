package com.example.app.service;

import com.example.app.dao.ClassroomRepository;
import com.example.app.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    //Get ALL Classroom
    public Iterable<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }
    //Post classroom
    public Classroom addClassroom(Classroom classroom){
    	Classroom savedClassroom = classroomRepository.save(classroom);
        return savedClassroom;
    }
    // Get classroom by id
    public Optional<Classroom> getClassroom(Long id) {
        return  classroomRepository.findById(id);
    }

    //Delete Classroom (id)
    public Optional<Classroom> deleteClassroom(final Long id) {
    	classroomRepository.deleteById(id);
        return null;
    }


}