package com.example.app.controller;

import com.example.app.model.Speciality;
import com.example.app.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    //Get ALL Speciality
    @GetMapping("/speciality")
    public  Iterable<Speciality> getSpecialities() {

        return specialityService.getSpecialities();
    }

    //Post Speciality
    @PostMapping(value = "/speciality" , consumes = {"application/json"})
    public Speciality addSpeciality(@RequestBody Speciality speciality){

        return specialityService.addSpeciality(speciality);

    }

    // Get Speciality by id
    @GetMapping("/speciality/{id}")
    public Optional<Speciality> getSpeciality(@PathVariable String id) {
        return specialityService.getSpeciality(Integer.parseInt(id));
    }

    // Delete Speciality by id
    @DeleteMapping("/speciality/{id}")
    public String deleteSpeciality(@PathVariable String id) {
        specialityService.deleteSpeciality(Long.valueOf(Integer.parseInt(id)));
        return "Succesfull delete";
    }

    //Update Speciality
    @PatchMapping("/speciality/{id}")
    public String updateSpeciality(@PathVariable String id, @RequestBody Speciality speciality) {
        Speciality speciality1 = specialityService.getSpeciality(Integer.parseInt(id)).get();

        String name = speciality.getName();
        System.out.println(speciality.getId());
        speciality1.setName(name);
        specialityService.addSpeciality(speciality1);
        return "Succesfull delete";
    }
}
