package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "proyectos")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del proyecto no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre del proyecto debe tener entre 1 y 50 caracteres")
    private String  nombre;

    @Size(max = 200, message = "La descripcion  del proyecto debe tener menos de 200 caracteres")
    private String descripcion;

    private boolean estadoActivo = true; //True si esta activo


    //Constructor
    public Proyecto( String nombre, String descripcion, boolean estadoActivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoActivo = estadoActivo;
    }

    //Getter and Setter

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public boolean isEstadoActivo() {
        return estadoActivo;
    }


    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

}
