package com.example.milanuncios.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.milanuncios.util.Anuncio;


@Service
@FeignClient("microanuncios/api/anuncios")
public interface AnuncioService {
	
	@GetMapping("/{id_anuncio}")
	public Anuncio getAnuncioById(int id_anuncio);
	@GetMapping("/listado_anuncios")
	public List<Anuncio> getAnuncios();
	@GetMapping("/categoria/{id_categoria}")
	public List<Anuncio> getAnunciosByCategoria(int id_categoria);
	@DeleteMapping("/{id_anuncio}")
	public void deleteAnuncio(int id_anuncio);
	@PutMapping
	public void updateAnuncioById(Anuncio anunciodto);
	
	
}
