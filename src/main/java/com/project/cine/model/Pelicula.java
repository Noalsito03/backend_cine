package com.project.cine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pelicula;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    private Integer duracion;

    private LocalDate fechaEstreno;
}
