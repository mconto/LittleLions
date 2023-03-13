package com.littleLions.co.service;

import com.littleLions.co.domain.Nino;
import com.littleLions.co.repository.NinoRepoI;
import com.littleLions.co.repository.NinoRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NinoService implements NinoRepoI {

    @Autowired
    NinoRepositoryI ninoRepositoryI;

    @Override
    public Optional<Nino> findById(Long id) {
        return ninoRepositoryI.findById(id);
    }

    @Override
    public List<Nino> findAll() {
        return ninoRepositoryI.findAll();
    }

    @Override
    public boolean save(Nino nino) {
        try {
            ninoRepositoryI.save(nino);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Nino nino) {
        try {
            ninoRepositoryI.findById(nino.getId())
                    .map(ninoActualizado -> {
                        ninoActualizado.setNombre(nino.getNombre());
                        ninoActualizado.setApellido(nino.getApellido());
                        ninoActualizado.setEdad(nino.getEdad());
                        ninoActualizado.setNombreResp(nino.getNombreResp());
                        ninoActualizado.setApellidoResp(nino.getApellidoResp());
                        ninoActualizado.setUbicacion(nino.getUbicacion());
                        return ninoRepositoryI.save(ninoActualizado);
                    }).get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Nino> findByNombre(String nombre) {
        Optional<List<Nino>> ninos = ninoRepositoryI.findByNombre(nombre);
        if (ninos.isEmpty()) {
            return new ArrayList<Nino>();
        } else {
            return ninos.get();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            ninoRepositoryI.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Nino> findByUbicacion(String ubicacion) {
        Optional<List<Nino>> ninoLocalizacion = ninoRepositoryI.findByUbicacion(ubicacion);
        if (ninoLocalizacion.isEmpty()) {
            return new ArrayList<>();
        } else {
            return ninoLocalizacion.get();
        }
    }


}
