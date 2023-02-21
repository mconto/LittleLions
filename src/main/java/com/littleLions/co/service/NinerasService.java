package com.littleLions.co.service;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.dtos.Precios;
import com.littleLions.co.repository.NinerasRepoI;
import com.littleLions.co.repository.NinerasRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NinerasService implements NinerasRepoI {

    @Autowired
    NinerasRepositoryI ninerasRepositoryI;

    @Override
    public Optional<Nineras> findById(Long id) {
        return ninerasRepositoryI.findById(id);
    }

    @Override
    public List<Nineras> findAll() {
        return ninerasRepositoryI.findAll();
    }

    @Override
    public boolean save(Nineras ninera) {
        try {
            ninerasRepositoryI.save(ninera);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Nineras ninera) {
        try {
            Optional<Nineras> nineras = ninerasRepositoryI.findById(ninera.getId());
            Nineras nineraNueva = new Nineras();
            if (nineras.isPresent()) {
                nineraNueva.setNombre(ninera.getNombre());
                nineraNueva.setApellido(ninera.getApellido());
                nineraNueva.setEdad(ninera.getEdad());
                nineraNueva.setUsuario(ninera.getUsuario());
                nineraNueva.setCorreo(ninera.getCorreo());
                nineraNueva.setFoto(ninera.getFoto());
                nineraNueva.setBilingue(ninera.isBilingue());
                nineraNueva.setNinoAsignado(ninera.getNinoAsignado());
                nineraNueva.setAsignada(ninera.isAsignada());
                ninerasRepositoryI.save(nineraNueva);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Nineras> findByNombre(String nombre) {
        Optional<List<Nineras>> nineras = ninerasRepositoryI.findByNombre(nombre);
        if (nineras.isEmpty()){
            return new ArrayList<Nineras>();
        }else{
            return nineras.get();
        }
    }

    @Override
    public List<Nineras> findByBilingue(boolean bilingue) {
        Optional<List<Nineras>> nineras = ninerasRepositoryI.findByBilingue(bilingue);
        if (nineras.isEmpty()){
            return new ArrayList<Nineras>();
        }else{
            return nineras.get();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            ninerasRepositoryI.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Nineras> findByBilingueAndAsignada(boolean bilingue, boolean asignada) {
        Optional<List<Nineras>> nineraAsignadaBilingue = ninerasRepositoryI.findByBilingueAndAsignada(bilingue, asignada);
        if (nineraAsignadaBilingue.isEmpty()){
            return new ArrayList<>();
        }else{
            return nineraAsignadaBilingue.get();
        }
    }


}
