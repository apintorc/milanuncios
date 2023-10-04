package com.example.milanuncios.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.milanuncios.util.Anuncio;
import com.example.milanuncios.util.Categoria;
import com.example.milanuncios.util.Role;
import com.example.milanuncios.util.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class UsuarioController {
	
	@GetMapping("registrar")
	public String registrar(Model model) {
		//List<Equipo>equipos = equipoService.getEquipos();
		return "registrar";
	}
	
	@GetMapping("welcome_user")
	public String getCategorias(Model model) {
		//List<Equipo>equipos = equipoService.getEquipos();
		List<Anuncio>anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio(1, "alex", "Vendo bicicleta", "Se vende bicicleta Scott Scale con 2 años de uso, incluye garantía y componentes adicionales", 348,new Categoria(2,"Bicicletas"));
		Anuncio anuncio2 = new Anuncio(2, "pedro", "Vendo coche", "Se vende coche Renault Clio con 6 años de uso y tiene 10000kilometros", 5478,new Categoria(2,"Coches"));
		anuncios.add(anuncio);
		anuncios.add(anuncio2);
		model.addAttribute("anuncios",anuncios);
		List<Categoria>categorias = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria(1,"Coches");
		Categoria categoria2 = new Categoria(2,"Bicicletas");
		categorias.add(categoria1);
		categorias.add(categoria2);
		model.addAttribute("categorias",categorias);
		return "index_user";
	}
	
	@GetMapping("/alta_anuncio_user")
	public String altaAnuncioUser(Model model) {
		model.addAttribute("anuncio", new Anuncio());
		List<Categoria>categorias = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria(1,"Coches");
		Categoria categoria2 = new Categoria(2,"Bicicletas");
		categorias.add(categoria1);
		categorias.add(categoria2);
		model.addAttribute("categorias",categorias);
		
		return "alta_anuncio";
	}
	
	@GetMapping("list_anuncios_user")
	public String getAnunciosByCategoriaUser(Model model) {
		//List<Jugador>jugadores = equipoService.getJugadoresByEquipo(id_equipo);
		List<Anuncio>anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio(1, "alex", "Vendo bicicleta", "Se vende bicicleta Scott Scale con 2 años de uso, incluye garantía y componentes adicionales", 348,new Categoria(2,"Bicicletas"));
		Anuncio anuncio2 = new Anuncio(2, "pedro", "Vendo coche", "Se vende coche Renault Clio con 6 años de uso y tiene 10000kilometros", 5478,new Categoria(2,"Coches"));
		anuncios.add(anuncio);
		anuncios.add(anuncio2);
		model.addAttribute("anuncios",anuncios);
		return "list_anuncios";
	}
	
	@GetMapping("list_anuncios_user/{id_categoria}/{descripcion}")
	public String getAnunciosByCategoriaUser(Model model,@PathVariable("id_categoria") int id_categoria,@PathVariable("descripcion") String descripcion ) {
		//List<Jugador>jugadores = equipoService.getJugadoresByEquipo(id_equipo);
		List<Anuncio>anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio(1, "alex", "Vendo bicicleta", "Se vende bicicleta con 2 años de uso, incluye garantía y componentes adicionales", 348,new Categoria(2,"Bicicletas"));
		Anuncio anuncio2 = new Anuncio(2, "pedro", "Vendo coche", "Se vende coche Renault Clio con 6 años de uso y tiene 10000kilometros", 5478,new Categoria(2,"Coches"));
		anuncios.add(anuncio);
		anuncios.add(anuncio2);
		model.addAttribute("anuncios",anuncios);
		return "list_anuncios";
	}
	
	@GetMapping("ver_anuncio")
	public String verAnuncio(Model model) {
		//List<Jugador>jugadores = equipoService.getJugadoresByEquipo(id_equipo);
		Anuncio anuncio = new Anuncio(1, "alex", "Vendo bicicleta", "Se vende bicicleta con 2 años de uso, incluye garantía y componentes adicionales", 348,new Categoria(2,"Bicicletas"));
		model.addAttribute("anuncio",anuncio);
		return "ver_anuncio";
	}
	
	
}
