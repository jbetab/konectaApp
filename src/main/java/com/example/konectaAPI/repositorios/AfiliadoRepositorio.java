package com.example.konectaAPI.repositorios;

import com.example.konectaAPI.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepositorio extends JpaRepository<Afiliado,Integer> {
}
