package com.example.microAnuncios.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnuncioDto{
    private int id_anuncio;
    private CategoriaDto categoria;
    private String user;
    private String titulo;
    private String descripcion;
    private double precio;
    private Date fecha_publicacion;
}