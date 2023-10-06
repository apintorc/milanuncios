package com.example.microAnuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microAnuncios.dto.AnuncioDto;
import com.example.microAnuncios.dto.CategoriaDto;
import com.example.microAnuncios.interfaces.IAnuncioService;
import com.example.microAnuncios.model.Anuncio;
import com.example.microAnuncios.model.Categoria;
import com.example.microAnuncios.repository.AnuncioRepository;

@Service
public class AnuncioService implements IAnuncioService {

    @Autowired
    AnuncioRepository anuncioRepository;

    @Override
    public AnuncioDto getAnuncioById(int id_anuncio) {
        Anuncio anuncio = anuncioRepository.findById(id_anuncio).orElse(null);
        if (anuncio != null) {
            AnuncioDto anunciodto = new AnuncioDto();
            Categoria categoria = anuncio.getCategoria();
            CategoriaDto categoriadtoCategoriaDto = new CategoriaDto(categoria.getId_categoria(),
                    categoria.getDescripcion());
            System.out.println(categoriadtoCategoriaDto);
            anunciodto.setId_anuncio(id_anuncio);
            anunciodto.setId_categoria(categoriadtoCategoriaDto);
            anunciodto.setUser(anuncio.getUser());
            anunciodto.setTitulo(anuncio.getTitulo());
            anunciodto.setDescripcion(anuncio.getDescripcion());
            anunciodto.setPrecio(anuncio.getPrecio());
            anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());
            return anunciodto;

        } else {
            return null;
        }
    }

    @Override
    public List<AnuncioDto> getAnuncios() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<AnuncioDto> anunciosdto = new ArrayList<>();

        for (Anuncio anuncio : anuncios) {
            AnuncioDto anunciodto = new AnuncioDto();
            Categoria categoria = anuncio.getCategoria();
            CategoriaDto categoriadtoCategoriaDto = new CategoriaDto(categoria.getId_categoria(),
                    categoria.getDescripcion());
            System.out.println(categoriadtoCategoriaDto);
            anunciodto.setId_anuncio(anuncio.getId_anuncio());
            anunciodto.setId_categoria(categoriadtoCategoriaDto);
            anunciodto.setUser(anuncio.getUser());
            anunciodto.setTitulo(anuncio.getTitulo());
            anunciodto.setDescripcion(anuncio.getDescripcion());
            anunciodto.setPrecio(anuncio.getPrecio());
            anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());

            anunciosdto.add(anunciodto);
        }

        return anunciosdto;
    }

    @Override
    public List<AnuncioDto> getAnunciosByCategoria(int id_categoria) {
        List<Anuncio> anuncios = anuncioRepository.findAnunciosByCategoria(id_categoria);
        List<AnuncioDto> anunciosdto = new ArrayList<>();

        if (anuncios.size() != 0) {
            for (Anuncio anuncio : anuncios) {
                AnuncioDto anunciodto = new AnuncioDto();
                Categoria categoria = anuncio.getCategoria();
                CategoriaDto categoriadtoCategoriaDto = new CategoriaDto(categoria.getId_categoria(),
                        categoria.getDescripcion());

                anunciodto.setId_anuncio(anuncio.getId_anuncio());
                anunciodto.setId_categoria(categoriadtoCategoriaDto);
                anunciodto.setUser(anuncio.getUser());
                anunciodto.setTitulo(anuncio.getTitulo());
                anunciodto.setDescripcion(anuncio.getDescripcion());
                anunciodto.setPrecio(anuncio.getPrecio());
                anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());

                anunciosdto.add(anunciodto);
            }
        }
        return anunciosdto;
    }

    @Override
    public void deleteUsuario(int id_anuncio) {
        anuncioRepository.deleteById(id_anuncio);
    }

    @Override
    public void updateAnuncioById(AnuncioDto anunciodto) {
        Anuncio anuncio = new Anuncio();
        CategoriaDto categoriadtoCategoriaDto = anunciodto.getId_categoria();
        Categoria categoria = new Categoria(categoriadtoCategoriaDto.getId_categoria(),
                categoriadtoCategoriaDto.getDescripcion());

        anuncio.setId_anuncio(anunciodto.getId_anuncio());
        anuncio.setCategoria(categoria);
        anuncio.setUser(anunciodto.getUser());
        anuncio.setTitulo(anunciodto.getTitulo());
        anuncio.setDescripcion(anunciodto.getDescripcion());
        anuncio.setFecha_publicacion(anunciodto.getFecha_publicacion());
        anuncio.setPrecio(anunciodto.getPrecio());

        anuncioRepository.save(anuncio);
    }

    @Override
    public AnuncioDto getAnuncioUser(String user) {
        Anuncio anuncio = anuncioRepository.findAnuncioByUser(user);
        if (anuncio != null) {
            AnuncioDto anunciodto = new AnuncioDto();
            Categoria categoria = anuncio.getCategoria();
            CategoriaDto categoriadtoCategoriaDto = new CategoriaDto(categoria.getId_categoria(),
                    categoria.getDescripcion());
            anunciodto.setId_anuncio(anuncio.getId_anuncio());
            anunciodto.setId_categoria(categoriadtoCategoriaDto);
            anunciodto.setUser(anuncio.getUser());
            anunciodto.setTitulo(anuncio.getTitulo());
            anunciodto.setDescripcion(anuncio.getDescripcion());
            anunciodto.setPrecio(anuncio.getPrecio());
            anunciodto.setFecha_publicacion(anuncio.getFecha_publicacion());
            return anunciodto;

        } else {
            return null;
        }
    }
}
