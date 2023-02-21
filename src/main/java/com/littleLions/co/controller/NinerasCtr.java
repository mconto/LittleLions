package com.littleLions.co.controller;


import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.dtos.Precios;
import com.littleLions.co.response.ResponseHTTP;
import com.littleLions.co.service.NinerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/little-lions/nineras")
public class NinerasCtr {

    @Autowired
    NinerasService ninerasService;

    @GetMapping("/obtener-nineras")
    public ResponseEntity<ResponseHTTP> retornaNineras() {
        List<Nineras> nineras = ninerasService.findAll();
        return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), nineras),
                HttpStatus.CREATED);
    }

    @GetMapping("/obtener-nineras-id")
    public ResponseEntity<ResponseHTTP> retornaNineraPorId(@RequestParam Long id) {
        Optional<Nineras> nineras = ninerasService.findById(id);
        if (nineras.isPresent()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), nineras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), nineras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/almacenar-ninera")
    public ResponseEntity<ResponseHTTP> almacenarNinera(@RequestBody Nineras nineras) {
        try {
            boolean result = ninerasService.save(nineras);
            return result ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizar-ninera")
    public ResponseEntity<ResponseHTTP> actualizarNinera(@RequestBody Nineras nineras) {
        try {
            ninerasService.update(nineras);
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), true),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtener-nineras-nombre")
    public ResponseEntity<ResponseHTTP> retornaNineraPorNombre(@RequestParam String nombre) {
        List<Nineras> nineras = ninerasService.findByNombre(nombre);
        if (!nineras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), nineras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), nineras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-ninera-bilingue")
    public ResponseEntity<ResponseHTTP> retornaObraPorTecnica(@RequestParam boolean bilingue) {
        List<Nineras> nineras = ninerasService.findByBilingue(bilingue);
        if (!nineras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), nineras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), nineras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-ninera-bilingue-asignada")
    public ResponseEntity<ResponseHTTP> retornaObraPorTecnica(@RequestParam boolean bilingue, @RequestParam boolean asignada) {
        List<Nineras> obras = ninerasService.findByBilingueAndAsignada(bilingue, asignada);
        if (!obras.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), obras),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), obras),
                    HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseHTTP> deleteById(@RequestParam Long id) {
        boolean flag = ninerasService.deleteById(id);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }
}
