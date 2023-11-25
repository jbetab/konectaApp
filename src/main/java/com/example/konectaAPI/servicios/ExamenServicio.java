package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServicio {
    @Autowired
    ExamenRepositorio examenRepositorio;

    public Examen registrarExamen(Examen examen) throws Exception{
        try{

           return this.examenRepositorio.save(examen);

        }catch(Exception error){
            throw new Exception("error");
        }
    }
    public Examen consultarExamen(Integer idExamen)throws Exception {
        try {
            Optional<Examen> examenBuscado = this.examenRepositorio.findById(idExamen);
            if (examenBuscado.isPresent()) {//lo encontre en la BD
                return examenBuscado.get();

            } else {//no lo encontre
                throw new Exception("examen no encontrado");
            }

        } catch (Exception error) {
            throw new Exception("error en la consulta del examen");
        }
    }

    public List<Examen> buscarTodosLosExamenes () throws Exception{

        try {
            List<Examen>listaConsultada=this.examenRepositorio.findAll();
            return listaConsultada;

        }catch (Exception error){
            throw new Exception("error consultando examen");
        }

    }
    public Examen editarExamen(Integer id,Examen examen) throws Exception {
        try {
            Optional<Examen> examenBuscado = this.examenRepositorio.findById(id);
            if (examenBuscado.isPresent()) {
                Examen examenExistente = examenBuscado.get();
                examenExistente.setNombreExamen(examen.getNombreExamen());
                examenExistente.setFechaExamen(examen.getFechaExamen());
                Examen examenModificado = this.examenRepositorio.save(examenExistente);
                return examenModificado;
            } else {
                throw new Exception("no encontramos este examen");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());

            throw new Exception("fallamos editando");


        }
    }
    public  Boolean retirarExamen(Integer id) throws Exception{
        try {
            Boolean examenEncontrado= this.examenRepositorio.existsById(id);
            if (examenEncontrado){
                this.examenRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error borrado el usuario");
        }
    }
}
