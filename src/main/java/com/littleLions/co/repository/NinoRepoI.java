package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.Nino;

import java.util.List;
import java.util.Optional;

public interface NinoRepoI {

    Optional<Nino> findById(Long id);
    List<Nino> findAll();
    boolean save(Nino nino);
    boolean update(Nino nino);
    List<Nino> findByNombre(String nombre);
    boolean deleteById(Long id);
    List<Nino> findByUbicacion(String ubicacion);


}
