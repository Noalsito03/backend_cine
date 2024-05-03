package com.project.cine.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "reservacion")
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservacion;

    @ManyToOne
    @JoinColumn(name = "id_proyeccion")
    private Proyeccion proyeccion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull
    private Integer cantidadAsientos;

    private Integer estado;

}
