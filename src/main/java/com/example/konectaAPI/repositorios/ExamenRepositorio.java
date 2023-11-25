package com.example.konectaAPI.repositorios;

import com.example.konectaAPI.entidades.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepositorio extends JpaRepository<Examen,Integer> {
}
