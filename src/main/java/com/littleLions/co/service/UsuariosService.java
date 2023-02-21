package com.littleLions.co.service;

import com.littleLions.co.domain.Nino;
import com.littleLions.co.repository.UsuariosRepoI;
import com.littleLions.co.repository.UsuariosRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService implements UsuariosRepoI {

    @Autowired
    UsuariosRepositoryI usuariosRepositoryI;

    @Override
    public Nino findById(Long id) {
        Optional<Nino> usuarios = usuariosRepositoryI.findById(id);
        return usuarios.orElseGet(Nino::new);
    }

    @Override
    public boolean save(Nino usuarios) {
        try {
            usuariosRepositoryI.save(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Nino usuarios) {
        try {
            Optional<Nino> usuarioGuardado = usuariosRepositoryI.findById(usuarios.getId());
            Nino usuarioParaSave = new Nino();
            if (usuarioGuardado.isPresent()) {
                usuarioParaSave.setFoto(usuarios.getFoto());
                usuarioParaSave.setEdad(usuarios.getEdad());
                usuarioParaSave.setId(usuarios.getId());
                usuarioParaSave.setCorreo(usuarios.getCorreo());
                usuariosRepositoryI.save(usuarioParaSave);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean deleteById(Long id) {
        try {
            usuariosRepositoryI.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
