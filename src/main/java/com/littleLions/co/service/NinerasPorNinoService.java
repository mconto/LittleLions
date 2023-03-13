package com.littleLions.co.service;

import com.littleLions.co.domain.Nineras;
import com.littleLions.co.domain.NinerasPorNino;
import com.littleLions.co.domain.Nino;
import com.littleLions.co.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NinerasPorNinoService implements NinerasPorNinoRepoI {

    @Autowired
    NinerasPorNinoRepositoryI ninerasPorNinoRepositoryI;

    @Autowired
    NinerasRepositoryI ninerasRepositoryI;

    @Autowired
    NinoRepositoryI ninoRepositoryI;

    @Override
    public Optional<NinerasPorNino> findById(Long id) {
        return ninerasPorNinoRepositoryI.findById(id);
    }

    @Override
    public List<NinerasPorNino> findAll() {
        return ninerasPorNinoRepositoryI.findAll();
    }

    @Override
    public boolean save(NinerasPorNino ninerasPorNino) {
        try {
            Optional<Nineras> nineraSeleccionada = ninerasRepositoryI.findById(ninerasPorNino.getIdNinera().getId());
            Optional<Nino> ninoSeleccionado = ninoRepositoryI.findById(ninerasPorNino.getNinoAsignado().getId());

            Nineras ninera = nineraSeleccionada.orElseGet(Nineras::new);
            Nino nino = ninoSeleccionado.orElseGet(Nino::new);

            if (ninera.getHorasDisponibles() >= nino.getHorasRequeridas()){
                NinerasPorNino servicioAsignado = ninerasPorNinoRepositoryI.save(ninerasPorNino);
            }
            int horasComprometidas = nino.getHorasRequeridas();
             return actualizarPartes(ninera, horasComprometidas, nino);
        } catch (Exception e) {
            return false;
        }

    }

    private boolean actualizarPartes(Nineras nineraParametros, int horasComprometidas, Nino ninoAsignado) {
        try {
            Nineras nineraActualizada = new Nineras();
            nineraActualizada.setId(nineraParametros.getId());
            nineraActualizada.setNombre(nineraParametros.getNombre());
            nineraActualizada.setApellido(nineraParametros.getApellido());
            nineraActualizada.setEdad(nineraParametros.getEdad());
            nineraActualizada.setUsuario(nineraParametros.getUsuario());
            nineraActualizada.setCorreo(nineraParametros.getCorreo());
            nineraActualizada.setFoto(nineraParametros.getFoto());
            nineraActualizada.setBilingue(nineraParametros.isBilingue());
            nineraActualizada.setNinoAsignado(ninoAsignado);
            nineraActualizada.setAsignada(true);
            nineraActualizada.setHorasDisponibles(nineraParametros.getHorasDisponibles() - horasComprometidas);
            Nineras actualizarNinera = ninerasRepositoryI.save(nineraActualizada);
            ninoAsignado.setHorasRequeridas(0);
            Nino actualizarNino = ninoRepositoryI.save(ninoAsignado);
            return true;
        } catch (Exception e) {
            new Throwable("Error al momento de actualizar las partes");
            return false;
        }
    }
}
