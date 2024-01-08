package com.example.ejercicio4.repository;

import com.example.ejercicio4.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

}
