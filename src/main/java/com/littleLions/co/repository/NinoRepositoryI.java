package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.Nino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinoRepositoryI extends CrudRepository<Nino, Long> {

    List<Nino> findAll();

    Optional<Nino> findById(Long id);

    Nino save(Nino nino);

    Optional<List<Nino>> findByNombre(String nombre);

    void deleteById(Long id);

    Optional<List<Nino>> findByUbicacion(String ubicacion);



}
