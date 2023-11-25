package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "afiliados")

public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nombres",length = 50,nullable = false)
    private String nombre;

    @Column(name = "apellidos",length = 50,nullable = false)
    private String apellido;

    @Column(name = "documentos",length = 50,nullable = false)
    private String documento;

    @Column(name = "correo",length = 50,nullable = false)
    private String correo;

    @Column(name = "departamento",nullable = false)
    private Integer departamento;

    @Column(name = "ciudad",nullable = false)
    private Integer ciudad;

    @Column(name = "telefono",nullable = false)
    private String telefono;

    @Column(name = "fechanacimiento",nullable = false)
    private LocalDate fechaNacimiento;

    public Afiliado() {
    }

    public Afiliado(Integer id, String nombre, String apellido, String documento, String correo, Integer departamento, Integer ciudad, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public Integer getCiudad() {
        return ciudad;
    }

    public void setCiudad(Integer ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
