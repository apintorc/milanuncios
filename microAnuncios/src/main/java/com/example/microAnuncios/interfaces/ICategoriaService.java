package com.example.microAnuncios.interfaces;

import java.util.List;

import com.example.microAnuncios.dto.CategoriaDto;

public interface ICategoriaService {

    public List<CategoriaDto> getCategorias();
    public CategoriaDto findCategoriaId(int id_categoria);
    public void updateCategoriaById(CategoriaDto categoriadto);
    public void deleteCategoria(int id_categoria);
}
