package com.example.app.controller;

import com.example.app.model.Classroom;
import com.example.app.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;


    @GetMapping("/classroms")
    public Iterable<Classroom> getClassrooms() {
        return classroomService.getClassrooms();
    }

    // Post method for sending school
    @PostMapping(value  = "/classroms", consumes = {"application/json"})
    public Classroom addClassrom(@RequestBody Classroom classroom ) {
        return classroomService.addClassroom(classroom);
    }

    // Get Speciality by id
    @GetMapping("/classroms/{id}")
    public Optional<Classroom> getClassroom(@PathVariable String id) {
        return classroomService.getClassroom((long) Integer.parseInt(id));
    }

    // Delete Speciality by id
    @DeleteMapping("/classroms/{id}")
    public String deleteClassroom(@PathVariable String id) {
        classroomService.deleteClassroom(Long.valueOf(Integer.parseInt(id)));
        return "Succesfull delete";
    }

    //Update Speciality
    @PatchMapping("/classroms/{id}")
    public String updateClassroom(@PathVariable String id, @RequestBody Classroom classroom) {
        Classroom classroom1 = classroomService.getClassroom((long) Integer.parseInt(id)).get();

        String name = classroom.getName();
        Integer size = classroom.getSize();
        String level = classroom.getLevel();

        //SET NEW VALUES
        classroom1.setName(name);
        classroom1.setLevel(level);
        classroom1.setSize(size);
        classroomService.addClassroom(classroom1);
        return "Succesfull delete";
    }
}
