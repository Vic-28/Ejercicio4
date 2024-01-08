package com.example.ejercicio4.interfaces;

import com.example.ejercicio4.model.Animal;

import java.util.List;

public interface AnimalService{


    List<Animal> findAll ();


     Animal getAnimalById(int id);


    boolean deleteAnimal(int id);

     Animal addAnimal(Animal animal);


     Animal updateAnimal(Animal animal);

}