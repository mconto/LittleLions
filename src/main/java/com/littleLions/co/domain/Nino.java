package com.littleLions.co.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "nino")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nino implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="edad")
    private int edad;

    @Column(name="nombre_resp")
    private String nombreResp;

    @Column(name="apellido_resp")
    private String apellidoResp;

    @Column(name="ubicacion_nino")
    private String ubicacion;

    @Column(name="horas_requeridas")
    private int horasRequeridas;
 }

