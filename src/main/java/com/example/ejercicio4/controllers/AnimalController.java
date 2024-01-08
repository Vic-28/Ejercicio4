package com.example.ejercicio4.controllers;

import com.example.ejercicio4.interfaces.AnimalService;
import com.example.ejercicio4.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String muestraAnimales(Model model) {
        List<Animal> listaDeAnimales = animalService.findAll();
        model.addAttribute("listaDeAnimales", listaDeAnimales);
        return "index";
    }

    @GetMapping("/Details/{id}")
    public String getDetallesAnimal(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "details";
    }

    @GetMapping("/Create")
    public String getCrearAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "create";
    }

    @PostMapping("/Create")
    public String postCrearAnimal(@Validated @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            animalService.addAnimal(animal);
            return "redirect:/Animal";
        }
    }

    @GetMapping("/Edit/{id}")
    public String getEditarAnimal(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "edit";
    }

    @PostMapping("/Edit/{id}")
    public String postEditarAnimal(@PathVariable int id, @Validated @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Animal existingAnimal = animalService.getAnimalById(id);
            if (existingAnimal != null) {
                existingAnimal.setNombre(animal.getNombre());
                existingAnimal.setVidaMedia(animal.getVidaMedia());
                existingAnimal.setExtinto(animal.getExtinto());
                animalService.updateAnimal(existingAnimal);
            }
            return "redirect:/Animal";
        }
    }

    @GetMapping("/Delete/{id}")
    public String getEliminarAnimal(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "delete";
    }

    @PostMapping("/Delete/{id}")
    public String postEliminarAnimal(@PathVariable int id) {
        if (animalService.deleteAnimal(id)) {
            return "redirect:/Animal";
        } else {
            return "delete";
        }
    }
}
