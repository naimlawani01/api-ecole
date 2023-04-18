package com.example.app.controller;

import com.example.app.dao.ClassroomRepository;
import com.example.app.dao.EcoleRepository;
import com.example.app.model.Classroom;
import com.example.app.model.Ecole;
import com.example.app.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private EcoleRepository ecoleRepository;

    @Autowired
    private ClassroomRepository classroomRepository;
    @GetMapping("/classroms")
    public Iterable<Classroom> getClassrooms() {
        return classroomService.getClassrooms();
    }

    // Post method for sending school
    @PostMapping(value  = "/classroms/{ecoleId}", consumes = {"application/json"})
    public ResponseEntity<List<Classroom>> addClassrom(@PathVariable Long ecoleId,  @RequestBody List<Classroom> classrooms ) {
        Optional<Ecole> optionalEcole = ecoleRepository.findById(ecoleId);
        if (optionalEcole.isPresent()) {
            Ecole ecole = optionalEcole.get();
            for (Classroom classroom : classrooms) {
                classroom.setEcole(ecole);
            }
            List<Classroom> savedClassrooms = classroomRepository.saveAll(classrooms);
            return ResponseEntity.ok(savedClassrooms);
        } else {
            return ResponseEntity.notFound().build();
        }
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
        return "Succesfull Update";
    }
}
