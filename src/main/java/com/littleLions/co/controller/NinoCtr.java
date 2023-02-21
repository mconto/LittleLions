package com.littleLions.co.controller;


import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.Nino;
import com.littleLions.co.response.ResponseHTTP;
import com.littleLions.co.service.NinerasService;
import com.littleLions.co.service.NinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/little-lions/nino")
public class NinoCtr {

    @Autowired
    NinoService ninoService;

    @GetMapping("/obtener-ninos")
    public ResponseEntity<ResponseHTTP> retornaNino() {
        List<Nino> ninos = ninoService.findAll();
        return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), ninos),
                HttpStatus.CREATED);
    }

    @GetMapping("/obtener-nino-id")
    public ResponseEntity<ResponseHTTP> retornaNinoPorId(@RequestParam Long id) {
        Optional<Nino> nino = ninoService.findById(id);
        if (nino.isPresent()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), nino),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), nino),
                    HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/almacenar-nino")
    public ResponseEntity<ResponseHTTP> almacenarNino(@RequestBody Nino nino) {
        try {
            boolean result = ninoService.save(nino);
            return result ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizar-nino")
    public ResponseEntity<ResponseHTTP> actualizarNino(@RequestBody Nino nino) {
        try {
            ninoService.update(nino);
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), true),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtener-nino-nombre")
    public ResponseEntity<ResponseHTTP> retornaNinoPorNombre(@RequestParam String nombre) {
        List<Nino> ninos = ninoService.findByNombre(nombre);
        if (!ninos.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), ninos),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), ninos),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/obtener-nino-ubicacion")
    public ResponseEntity<ResponseHTTP> retornaNinoPorUbicacion(@RequestParam String ubicacion) {
        List<Nino> ninos = ninoService.findByUbicacion(ubicacion);
        if (!ninos.isEmpty()) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), ninos),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), ninos),
                    HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseHTTP> deleteById(@RequestParam Long id) {
        boolean flag = ninoService.deleteById(id);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }
}
