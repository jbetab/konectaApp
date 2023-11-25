package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServicio {
    @Autowired
    AfiliadoRepositorio afiliadoRepositorio;
    //registrar afiliado
    public Afiliado registrarAfiliado(Afiliado afiliado) throws Exception{
        try{

           return this.afiliadoRepositorio.save(afiliado);

        }catch(Exception error){
            System.out.println(error.getMessage());
            throw new Exception("error ");
        }
    }
    //consultar afiliado
    public Afiliado consultarAfiliado(Integer idAfiliado)throws Exception {
        try {
            Optional<Afiliado> afiliadoBuscado = this.afiliadoRepositorio.findById(idAfiliado);
            if (afiliadoBuscado.isPresent()) {//lo encontre en la BD
                return afiliadoBuscado.get();

            } else {//no lo encontre
                throw new Exception("afiliado no encontrado");
            }

        } catch (Exception error) {
            throw new Exception("error en la consulta del afiliado");
        }
    }

    //consultar afiliados
    public List<Afiliado> buscarTodosAfiliados() throws Exception{

        try {
           List<Afiliado>listaConsultada=this.afiliadoRepositorio.findAll();
           return listaConsultada;

        }catch (Exception error){
            throw new Exception("error consultando afiliado");
        }
    }

    //modificar datos afiliados
    public Afiliado editarAfiliado(Integer id, Afiliado afiliado ) throws Exception {
        try {
           Optional<Afiliado>afiliadoBuscado= this.afiliadoRepositorio.findById(id);
           if (afiliadoBuscado.isPresent()){

               //este es para cambiar todo
             // Afiliado afiliadoEditado= this.afiliadoRepositorio.save(afiliado);
              //return afiliadoEditado;

               Afiliado afiliadoExistente=afiliadoBuscado.get();
               afiliadoExistente.setApellido(afiliado.getApellido());
               afiliadoExistente.setCorreo(afiliado.getCorreo());
              Afiliado afiliadoModificado=this.afiliadoRepositorio.save(afiliadoExistente);
              return afiliadoModificado;
           }else {
               throw new Exception("no encontramos este afiliado");
           }

        }catch (Exception error){
            System.out.println(error.getMessage());
            throw new Exception ("fallamos editando");
        }

    }
    //borrar afiliado

    public  Boolean retirarAfiliado(Integer id) throws Exception{
        try {
            Boolean afiliadoEncontrado= this.afiliadoRepositorio.existsById(id);
            if (afiliadoEncontrado){
                this.afiliadoRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error borrado el usuario");
        }
    }

}
