package com.example.microAnuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microAnuncios.dto.CategoriaDto;
import com.example.microAnuncios.interfaces.ICategoriaService;
import com.example.microAnuncios.model.Categoria;
import com.example.microAnuncios.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDto findCategoriaId(int id_categoria) {
        Categoria categoria = categoriaRepository.findById(id_categoria).orElse(null);
        CategoriaDto categoriaDto;
        if (categoria == null) {
            return null;
        } else {
            categoriaDto = new CategoriaDto(categoria.getId_categoria(), categoria.getDescripcion());

        }
        return categoriaDto;
    }

    @Override
    public void updateCategoriaById(CategoriaDto categoriadto) {
        Categoria categoria = new Categoria(categoriadto.getId_categoria(), categoriadto.getDescripcion());
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(int id_categoria) {
        categoriaRepository.deleteById(id_categoria);
    }

    @Override
    public List<CategoriaDto> getCategorias(){
        List<Categoria> categoria = (List<Categoria>) categoriaRepository.findAll();
        List<CategoriaDto> categoriasDto = new ArrayList<CategoriaDto>();
        for (Categoria categorias : categoria) {
            CategoriaDto categoriaDto = new CategoriaDto(categorias.getId_categoria(), categorias.getDescripcion());
            categoriasDto.add(categoriaDto);
        }
        return categoriasDto;
    }
}
