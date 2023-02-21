package com.littleLions.co.repository;

import com.littleLions.co.domain.Nino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositoryI extends CrudRepository<Nino, Long> {

    Nino save(Nino usuarios);

    void deleteById(Long id);

}
