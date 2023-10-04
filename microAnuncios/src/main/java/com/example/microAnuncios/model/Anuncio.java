package com.example.microAnuncios.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="anuncios")
public class Anuncio {
    @Id
    private int id_anuncio;
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;
}
