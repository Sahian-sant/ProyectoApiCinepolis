package com.mx.ApiRestCinepolis.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Mapear nuestra tabla
@Entity
@Table(name = "PELIS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Peliculas {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PELI", columnDefinition = "INT", nullable = false)
    private int idPeli;

    @Column(name = "NOMBRE", columnDefinition = "VARCHAR2(100)", nullable = false)
    private String nombre;

    @Column(name = "GENERO", columnDefinition = "VARCHAR2(100)", nullable = false)
    private String genero;

    @Column(name = "PRECIO", columnDefinition = "NUMBER", nullable = false)
    private Double precio;

    @Column(name = "FECHA_LANZ", columnDefinition = "DATE", nullable = false)
    private LocalDate fechaLanz;
}
