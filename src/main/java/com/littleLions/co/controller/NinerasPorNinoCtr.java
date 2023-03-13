package com.littleLions.co.controller;


import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.NinerasPorNino;
import com.littleLions.co.response.ResponseHTTP;
import com.littleLions.co.service.NinerasPorNinoService;
import com.littleLions.co.service.NinerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/little-lions/nineras-por-nino")
public class NinerasPorNinoCtr {

    @Autowired
    NinerasPorNinoService ninerasPorNinoService;

    @PostMapping("/almacenar-servicio")
    public ResponseEntity<ResponseHTTP> almacenarServicio(@RequestBody NinerasPorNino ninerasPorNino) {
        try {
            boolean result = ninerasPorNinoService.save(ninerasPorNino);
            return result ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }
}
