package com.example.ejercicio4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Nombre no puede estar vacio")
    @Size(min = 3, max = 15, message="El nombre debe tener entre 3 y 15 caracteres")
    private String Nombre;

    @NotNull(message="Vida media no puede ser menor de 0 y mayor de 600")
    @Min(0)
    @Max(600)
    private int VidaMedia;

    @NotNull(message = "El apartado extinto no puede ser nulo")
    private boolean Extinto;
    public Animal(){}

    public Animal(int id, String nombre, int vidamedia , boolean extinto)
    {
        this.id=id;
        this.Nombre=nombre;
        this.VidaMedia=vidamedia;
        this.Extinto=extinto;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getNombre(){return Nombre;}

    public void setNombre(String nombre){this.Nombre=nombre;}

    public int getVidaMedia(){return VidaMedia;}

    public void setVidaMedia(int vidamedia){this.VidaMedia=vidamedia;}

    public boolean getExtinto(){return Extinto;}

    public void setExtinto(boolean extinto){this.Extinto=extinto;}


    public String ToString()
    {
        return "-ID: " + this.id + " -Nombre: " + this.Nombre + " -Vida Media: " + this.VidaMedia + " -Extinto: " + this.Extinto;
    }
}
