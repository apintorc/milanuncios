package com.example.milanuncios.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.milanuncios.services.AnuncioService;
import com.example.milanuncios.services.UsuarioService;
import com.example.milanuncios.util.Anuncio;
import com.example.milanuncios.util.Categoria;
import com.example.milanuncios.util.Role;
import com.example.milanuncios.util.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class AdminController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	AnuncioService anuncioService;
	@GetMapping("/alta_categoria")
	public String altaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "alta_categoria";
	}
	
	@PostMapping("/grabar_categoria")
	public String grabar_anuncio(@ModelAttribute("categoria") Categoria categoria, Model model) {
		
		anuncioService.add_categoria(categoria);
		return getCategorias(model);
	}
	
	@GetMapping("list_categorias")
	public String getCategorias(Model model) {
		List<Categoria>categorias = anuncioService.get_categorias();
		model.addAttribute("categorias",categorias);
		return "list_categorias";
	}
	

	
	@GetMapping("list_anuncios")
	public String getAnunciosByCategoria(Model model) {
		List<Anuncio>anuncios = anuncioService.getAnuncios();
		model.addAttribute("anuncios",anuncios);
		List<Categoria>categorias = anuncioService.get_categorias();
		model.addAttribute("categorias",categorias);
		
		return "list_anuncios";
	}
	
	@GetMapping("list_anuncios/{id_categoria}/{descripcion}")
	public String getAnunciosByCategoria(Model model,@PathVariable("id_categoria") int id_categoria,@PathVariable("descripcion") String descripcion ) {
		//List<Jugador>jugadores = equipoService.getJugadoresByEquipo(id_equipo);
		List<Anuncio>anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio(1, "alex", "Vendo bicicleta", "Se vende bicicleta con 2 años de uso, incluye garantía y componentes adicionales", 348,new Categoria(2,"Bicicletas"));
		Anuncio anuncio2 = new Anuncio(2, "pedro", "Vendo coche", "Se vende coche Renault Clio con 6 años de uso y tiene 10000kilometros", 5478,new Categoria(2,"Coches"));
		anuncios.add(anuncio);
		anuncios.add(anuncio2);
		model.addAttribute("anuncios",anuncios);
		return "list_anuncios";
	}
	
	@GetMapping("/editar_anuncio/{id_anuncio}")
	public String editar_anuncio(@PathVariable("id_anuncio") String id_anuncio, Model model) {
		//PalabraDTO palabradto=palabraService.findPalabraById_Palabra(id_palabra);
		//Palabra_v palabra_v=new Palabra_v(palabradto.getId_palabra(),palabradto.getOriginal(),palabradto.getTraduccionSP(),palabradto.getTraduccionIN(),palabradto.getTraduccionFR(),1);
		List<Anuncio>anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio(2, "pedro", "Vendo coche", "Se vende coche Renault Clio con 6 años de uso y tiene 10000kilometros", 5478,new Categoria(2,"Coches"));
		anuncios.add(anuncio);
		List<Categoria>categorias = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria(1,"Coches");
		Categoria categoria2 = new Categoria(2,"Bicicletas");
		categorias.add(categoria1);
		categorias.add(categoria2);
		model.addAttribute("anuncio", anuncio);
		return "editar_anuncio";
	}
	
	@GetMapping("/list_usuarios")
	public String getUsuarios(Model model) {
		List<Usuario>usuarios = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario("alex","alex@gmail.com","1234","ADMIN","");
		Usuario usuario2 = new Usuario("pedro","pedro@gmail.com","4321","","USER");
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		model.addAttribute("usuarios", usuarios);
		return "list_usuarios";
	}
	
	@GetMapping("/ver_roles/{user}")
	public String verRoles(@PathVariable("user") String user, Model model) {
		List<Usuario>usuarios = new ArrayList<Usuario>();
		Usuario usuario2 = new Usuario("pedro","pedro@gmail.com","4321","","USER");
		usuarios.add(usuario2);
		List<Role>roles = new ArrayList<Role>();
		roles.add(new Role("ADMIN","Administrador del sistema"));
		model.addAttribute("roles", roles);
		model.addAttribute("usuario", user);
		return "list_roles";
	}
	
	@GetMapping("/alta_usuario")
	public String altaUsuario(Model model) {
		List<Role>roles = new ArrayList<Role>();
		roles.add(new Role("ADMIN","Administrador del sistema"));
		roles.add(new Role("USER","Usuario del sistema"));
		model.addAttribute("roles", roles);
		model.addAttribute("usuario", new Usuario());
		return "alta_usuario";
	}
	
	@GetMapping("/eliminar_anuncio/{id_anuncio}")
	public String deleteCliente(@PathVariable("id_anuncio") int id_anuncio, Model model) {
		anuncioService.deleteAnuncio(id_anuncio);
		return getAnunciosByCategoria(model);
	}
}
