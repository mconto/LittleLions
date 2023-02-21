package com.littleLions.co.controller;


import com.littleLions.co.domain.Nino;
import com.littleLions.co.response.ResponseHTTP;
import com.littleLions.co.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/egallery/usuarios")
public class UsuariosCtr {

    @Autowired
    UsuariosService usuariosService;


    @GetMapping("/obtener-usuario-id")
    public ResponseEntity<ResponseHTTP> obtenerUsuario(@RequestParam Long id) {
        try {
            Nino usuarios1 = usuariosService.findById(id);
            return usuarios1 != null ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), usuarios1),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), usuarios1),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/almacenar-usuario")
    public ResponseEntity<ResponseHTTP> almacenarUsuario(@RequestBody Nino usuarios) {
        try {
            boolean result = usuariosService.save(usuarios);
            return result ?
                    new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                            HttpStatus.CREATED) : new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actualizar-usuario")
    public ResponseEntity<ResponseHTTP> actualizarusuario(@RequestBody Nino usuarios) {
        try {
            boolean result = usuariosService.update(usuarios);
            return result ? new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CREATED): new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), result),
                    HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), false),
                    HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseHTTP> deleteById(@RequestParam Long id) {
        boolean flag = usuariosService.deleteById(id);
        if (flag) {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.CREATED.value(), flag),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ResponseHTTP(HttpStatus.NOT_FOUND.value(), flag),
                    HttpStatus.NOT_FOUND);
        }

    }




}
