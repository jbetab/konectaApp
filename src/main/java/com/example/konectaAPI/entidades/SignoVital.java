package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "signoVital")

public class SignoVital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;
    @Column(name = "unidadMedida",nullable = false)
    private Integer unidadMedida;

    public SignoVital() {
    }

    public SignoVital(Integer id, String nombre, Integer unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Integer unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
