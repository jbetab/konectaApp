package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.servicios.AfiliadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/afiliados")
public class AfiliadoControlador {

    @Autowired
    private AfiliadoServicio afiliadoServicio;

    //agregar afiliado
    @PostMapping
    public ResponseEntity<?> agregarAfiliado(@RequestBody Afiliado afiliado){
        try {
            Afiliado respuestaServicio=this.afiliadoServicio.registrarAfiliado(afiliado);
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //buscar afiliado
    @GetMapping("/{id}")
    public ResponseEntity <?> buscarAfiliado(@PathVariable Integer id){
        try {
         Afiliado respuestaServicio=this.afiliadoServicio.consultarAfiliado(id);
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<Afiliado>> consultaAfiliados(){
        try {
           List<Afiliado> listaConsultada= this.afiliadoServicio.buscarTodosAfiliados();
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(listaConsultada);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Afiliado> editarAfiliado(@PathVariable Integer id, @RequestBody Afiliado afiliado){
        try {
            Afiliado afiliadoRespuesta=this.afiliadoServicio.editarAfiliado(id,afiliado);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(afiliadoRespuesta);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAfiliado(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.afiliadoServicio.retirarAfiliado(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
