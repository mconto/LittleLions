package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinerasRepositoryI extends CrudRepository<Nineras, Long> {

    List<Nineras> findAll();

    Optional<Nineras> findById(Long id);

    Nineras save(Nineras ninera);

    Optional<List<Nineras>> findByNombre(String nombre);

    Optional<List<Nineras>> findByBilingue(boolean bilingue);

    void deleteById(Long id);

    Optional<List<Nineras>> findByBilingueAndAsignada(boolean bilingue, boolean asignada);



}
