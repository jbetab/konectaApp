package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "examen")

public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "nombreExamen",nullable = false)
    private String nombreExamen;
    @Column(name = "fechaExamen",nullable = false)
    private LocalDate fechaExamen;
    @Column(name = "imagenExamen",nullable = false)
    private String imagenExamen;

    public Examen() {
    }

    public Examen(Integer id, String nombreExamen, LocalDate fechaExamen, String imagenExamen) {
        this.id = id;
        this.nombreExamen = nombreExamen;
        this.fechaExamen = fechaExamen;
        this.imagenExamen = imagenExamen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getImagenExamen() {
        return imagenExamen;
    }

    public void setImagenExamen(String imagenExamen) {
        this.imagenExamen = imagenExamen;
    }
}
