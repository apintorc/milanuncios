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
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	AnuncioService anuncioService;
	@GetMapping("registrar")
	public String registrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registrar";
	}
	
	@GetMapping()
	public String displayLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";
	}
	
	@PostMapping("/login")
	public String iniciarSesion(Usuario usuario_v, Model model) {
		
		Usuario usuario = usuarioService.getUsuarioById(usuario_v.getUser());
		if(usuario != null && usuario.getPassword().equals(usuario_v.getPassword())) {
			//HttpSession session = request.getSession(true);
			//session.setAttribute("user", session);
			List<Role>rolesDTO = usuarioService.getRolesByUser(usuario.getUser());
			if(rolesDTO.contains(new Role("Admin"))){
				return "admin";
			}else {
				return getCategorias(model);
			}
			
		}if(usuario == null) {
			model.addAttribute("mensaje", "Los datos introducidos no son correctos");
		}
		
		return "index";
	}
	
	@PostMapping("/grabar_usuario")
	public String update_cliente(Usuario usuario, Model model) {
		usuarioService.addUpdateUsuario(usuario);
		return "index";
	}

	
	@GetMapping("welcome_user")
	public String getCategorias(Model model) {
		List<Anuncio>anuncios = anuncioService.getAnuncios();
		model.addAttribute("anuncios",anuncios);
		List<Categoria>categorias = anuncioService.get_categorias();
		model.addAttribute("categorias",categorias);
		return "index_user";
	}
	
	@GetMapping("/alta_anuncio")
	public String altaAnuncioUser(Model model) {
		model.addAttribute("anuncio", new Anuncio());
		List<Categoria>categorias = anuncioService.get_categorias();
		model.addAttribute("categorias",categorias);
		
		return "alta_anuncio";
	}
	
	@PostMapping("/grabar_anuncio")
	public String grabar_anuncio(@ModelAttribute("anuncio") Anuncio anuncio, Model model) {
		
		anuncioService.updateAnuncioById(anuncio);
		return getCategorias(model);
	}
	


	
	@GetMapping("list_anuncios_user/{id_categoria}/{descripcion}")
	public String getAnunciosByCategoriaUser(Model model,@PathVariable("id_categoria") int id_categoria,@PathVariable("descripcion") String descripcion ) {
		List<Anuncio>anuncios = anuncioService.getAnunciosByCategoria(id_categoria);
		List<Categoria>categorias = anuncioService.get_categorias();
		model.addAttribute("categorias",categorias);
		model.addAttribute("anuncios",anuncios);
		return "list_anuncios_user";
	}
	
	@GetMapping("/ver_anuncio/{id_anuncio}")
	public String verAnuncio(Model model,@PathVariable("id_anuncio") int id_anuncio) {
		//List<Jugador>jugadores = equipoService.getJugadoresByEquipo(id_equipo);
		Anuncio anuncio = anuncioService.getAnuncioById(id_anuncio);
		model.addAttribute("anuncio",anuncio);
		return "ver_anuncio";
	}
	
	
}
