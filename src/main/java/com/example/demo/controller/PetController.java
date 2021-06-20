package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.enumPak.Status;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pet")
public class PetController {
    @Autowired
    PetRepository petRepository;
    StatusService statusService;


    @PostMapping()
    public  void addPet(@RequestBody Pet pet){
        petRepository.save(pet);
    }

    @PutMapping()
    public void updatePet(@RequestBody Pet pet){
        petRepository.save(pet);
    }

    @GetMapping("/findByStatus")
    public List<Pet> findByStatus(@RequestBody Status status){
        return petRepository.findAllByStatus(status);
    }

    @GetMapping()
    public Pet findPetById(long id){
        Optional<Pet> pet = petRepository.findById(id);
        return  pet.get();

    }

    @PostMapping("/{petId}")
    public void upPetDateById(long petId, String name, String statusKey){
        Optional<Pet> pet = petRepository.findById(petId);
        pet.get().setName(name);
        pet.get().setStatus(statusService.getStatus(statusKey));



    }
}
