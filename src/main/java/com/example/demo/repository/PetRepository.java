package com.example.demo.repository;

import com.example.demo.model.Pet;
import com.example.demo.enumPak.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findAllByStatus(Status status);
}
