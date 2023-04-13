package com.example.app.controller;

import com.example.app.model.Classroom;
import com.example.app.model.Ecole;
import com.example.app.service.EcoleService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EcoleController {
    @Autowired
    private EcoleService ecoleService;

    // GET method for getting all school
    @GetMapping ("/ecole")
    public Iterable<Ecole> getEcoles() {
        return ecoleService.getEcoles();
    }

    // Post method for sending school
    @PostMapping(value  = "/ecole", consumes = {"application/json"})
    public Ecole addEcole(@RequestBody Ecole ecole) {
        return ecoleService.addEcole(ecole);
    }

    // Get method by id
    @GetMapping ("/ecole/{id}")
    public Optional<Ecole> getEcole(@PathVariable String id) {
            return ecoleService.getEcole(Long.parseLong(id));
    }

    // Delete by ID
    @DeleteMapping ("/ecole/{id}")
    public String deleteEcole(@PathVariable String id){
        ecoleService.deleteEcole(Long.valueOf(id));

    return "Success delete";

    }

    //Update method ID
    @PatchMapping ("/Ecole/{id}")
    public String updateEcole(@PathVariable String id, @RequestBody Ecole ecole) {
        Ecole oldValueEcole = ecoleService.getEcole(Long.valueOf(id)).get();
        String name = ecole.getName();
        String address = ecole.getAddress();
        String contact = ecole.getContact();

        oldValueEcole.setName(name);
        oldValueEcole.setAddress(address);
        oldValueEcole.setContact(contact);

        ecoleService.addEcole(oldValueEcole);

        return "Success update";
    }

    // Get All Classroom for each school
   @GetMapping ("/ecole/{id}/classroom")
    public Iterable<Classroom> getEcoleClassrooms(@PathVariable String id) {
        return ecoleService.getEcole(Long.valueOf(id)).get().getClassrooms();
    }

}

