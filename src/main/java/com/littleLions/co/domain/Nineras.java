package com.littleLions.co.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "nineras")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nineras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="edad")
    private int edad;

    @Column(name="usuario")
    private String usuario;

    @Column(name="correo")
    private String correo;

    @Lob
    @Column(name="foto")
    private byte[] foto;

    @Column(name="bilingue")
    private boolean bilingue;

    @ManyToOne
    @JoinColumn(name = "nina_asignada", referencedColumnName ="id")
    private Nino ninoAsignado;

    @Column(name="asignada")
    private boolean asignada;

    @Column(name="horas_disponibles")
    private int horasDisponibles;

}

