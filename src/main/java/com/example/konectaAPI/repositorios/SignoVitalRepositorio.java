package com.example.konectaAPI.repositorios;

import com.example.konectaAPI.entidades.SignoVital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignoVitalRepositorio extends JpaRepository<SignoVital,Integer> {
}
