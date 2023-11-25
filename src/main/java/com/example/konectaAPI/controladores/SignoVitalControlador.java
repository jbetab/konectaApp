package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/signosVitales")
public class SignoVitalControlador {
    @Autowired
    private SignoVitalServicio signoVitalServicio;

    @PostMapping
    public ResponseEntity<?> aggregarSignoVital (@RequestBody SignoVital signoVital){
        try {
            SignoVital respuestaServicio=this.signoVitalServicio.registrarSignoVital(signoVital);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity <?> buscarSignoVital(@PathVariable Integer id){
        try {
            SignoVital  respuestaServicio=this.signoVitalServicio.consultarsignoVital(id);
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
    public ResponseEntity<List<SignoVital>> consultarSignosVitales(){
        try {
            List<SignoVital> listaConsultada= this.signoVitalServicio.buscarTodosLosSignosVitales();
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
    public ResponseEntity<SignoVital> editarSignoVital (@PathVariable Integer id, @RequestBody SignoVital signoVital){
        try {
            SignoVital signoVitalRespuesta=this.signoVitalServicio.editarSignoVital(id,signoVital);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(signoVitalRespuesta);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSignoVital(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.signoVitalServicio.retirarSignoVital(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
