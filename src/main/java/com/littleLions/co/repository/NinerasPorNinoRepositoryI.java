package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.NinerasPorNino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinerasPorNinoRepositoryI extends CrudRepository<NinerasPorNino, Long> {

    List<NinerasPorNino> findAll();

    Optional<NinerasPorNino> findById(Long id);

    NinerasPorNino save(NinerasPorNino ninerasPorNino);

}
