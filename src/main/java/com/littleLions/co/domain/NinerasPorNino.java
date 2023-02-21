package com.littleLions.co.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "nineras_por_nino")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinerasPorNino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="nombre_ninera")
    private String nombreNinera;

    @Column(name="apellido_ninera")
    private String apellido_ninera;

    @Column(name="ubicacion_servicio")
    private String ubicacion;

    @Column(name="servicio_zonal")
    private boolean zonal;

    @OneToMany
    @JoinColumn(name = "nino_asignado", referencedColumnName ="id")
    private Nino ninoAsignado;

}

