package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import java.util.List;
import java.util.Optional;

public interface NinerasRepoI {

    Optional<Nineras> findById(Long id);
    List<Nineras> findAll();
    boolean save(Nineras ninera);
    boolean update(Nineras ninera);
    List<Nineras> findByBilingue(boolean bilingue);
    List<Nineras> findByNombre(String nombre);
    boolean deleteById(Long id);
    List<Nineras> findByBilingueAndAsignada(boolean bilingue, boolean asignada);


}
