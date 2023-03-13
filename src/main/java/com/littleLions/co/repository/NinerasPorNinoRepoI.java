package com.littleLions.co.repository;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.NinerasPorNino;

import java.util.List;
import java.util.Optional;

public interface NinerasPorNinoRepoI {

    Optional<NinerasPorNino> findById(Long id);
    List<NinerasPorNino> findAll();
    boolean save(NinerasPorNino ninerasPorNino);
}
