package com.littleLions.co.repository;

import com.littleLions.co.domain.Nino;

public interface UsuariosRepoI {

    Nino findById(Long id);
    boolean save(Nino usuarios);
    boolean update(Nino usuarios);

    boolean deleteById(Long id);


}
