package com.example.app.controller;

import com.example.app.dao.EcoleRepository;
import com.example.app.model.Classroom;
import com.example.app.model.Ecole;
import com.example.app.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EcoleController {
    @Autowired
    private EcoleService ecoleService;

    @Autowired
    private EcoleRepository ecoleRepository;

    // GET method for getting all school
    @GetMapping ("/ecoles")
    public Iterable<Ecole> getEcoles(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 9);
        Page<Ecole> ecolesPage = ecoleRepository.findAll(pageable);
        return ecolesPage;
    }

    // Post method for sending school
    @PostMapping(value  = "/ecoles", consumes = {"application/json"})
    public Ecole addEcole(@RequestBody Ecole ecole) {
        return ecoleService.addEcole(ecole);
    }

    // Get method by id
    @GetMapping ("/ecoles/{id}")
    public Optional<Ecole> getEcole(@PathVariable String id) {
            return ecoleService.getEcole(Long.parseLong(id));
    }

    // Delete by ID
    @DeleteMapping ("/ecoles/{id}")
    public String deleteEcole(@PathVariable String id){
        ecoleService.deleteEcole(Long.valueOf(id));

    return "Success delete";

    }

    //Update method ID
    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping (value="/ecoles/{id}", consumes = {"application/json"})
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

//     Get All Classroom for each school
   @GetMapping ("/ecoles/{id}/classrooms")
    public Iterable<Classroom> getEcoleClassrooms(@PathVariable String id) {
        return ecoleService.getEcoleClassrooms(Integer.valueOf(id));
    }


    @GetMapping("/search")
    public List<Ecole> searchEcoles(@RequestParam("q") String query) {
        List<Ecole> ecoles = ecoleRepository.findByNameContainingIgnoreCase(query);
        return ecoles;
    }

}

