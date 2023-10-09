package com.example.microAnuncios.interfaces;

import java.util.List;

import com.example.microAnuncios.dto.AnuncioDto;

public interface IAnuncioService {
    public List<AnuncioDto> getAnuncios();
    public AnuncioDto getAnuncioById(int id_anuncio);
    public List<AnuncioDto> getAnunciosByCategoria(int id_categoria);
    public void deleteUsuario(int id_anuncio);
    public void updateAnuncioById(AnuncioDto anunciodto);
	public List<AnuncioDto> getAnunciosByUser(String user);
}
