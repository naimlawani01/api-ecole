package com.example.app.controller;

import com.example.app.model.Voiture;
import com.example.app.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VoitureController {
    @Autowired
    private VoitureService voitureService;

    //Get ALL Voiture
    @GetMapping("/voiture")
    public  Iterable<Voiture> getVoitures() {

        return voitureService.getVoitures();
    }
    //Post voiture
    @PostMapping(value = "/voiture" , consumes = {"application/json"})
    public Voiture addVoiture(@RequestBody Voiture voiture){

        return voitureService.addVoiture(voiture);

    }
    // Get voiture by id
    @GetMapping("/voiture/{id}")
    public Optional<Voiture> getVoiture(@PathVariable String id) {
        return voitureService.getVoiture(Integer.parseInt(id));
    }
    // Delete voiture by id
    @DeleteMapping("/voiture/{id}")
    public String deleteVoiture(@PathVariable String id) {
         voitureService.deleteVoiture(Long.valueOf(Integer.parseInt(id)));
        return "Succesfull delete";
    }

    //Update Voiture
    @PatchMapping("/voiture/{id}")
    public String updateVoiture(@PathVariable String id, @RequestBody Voiture voiture) {
        Voiture voiture1 = voitureService.getVoiture(Integer.parseInt(id)).get();

        String name = voiture.getName();
        Double price = voiture.getPrice();
        String color = voiture.getColor();
        System.out.println(voiture.getId());
        voiture1.setName(name);
        voiture1.setPrice(price);
        voiture1.setColor(color);
        voitureService.addVoiture(voiture1);
        return "Succesfull delete";
    }
}
