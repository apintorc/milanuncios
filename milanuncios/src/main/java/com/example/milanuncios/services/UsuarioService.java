package com.example.milanuncios.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.milanuncios.util.Role;
import com.example.milanuncios.util.Usuario;

@Service
@FeignClient("microusuarios/usuario")
public interface UsuarioService {
	@GetMapping
    public List<Usuario> getUsuarios();
	
	@GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable("id") String id);
	
    @GetMapping("/roles/{id}")
    public List<Role> getRolesByUser(@PathVariable("id")String id);
    
    @PostMapping
    public Usuario addUpdateUsuario(@RequestBody Usuario usuario);
}
