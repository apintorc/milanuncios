package com.example.microusuarios.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired 
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
        List<UsuarioDTO> usuList = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("id") String id){
        UsuarioDTO usuarioDTO = usuarioService.getUsuarioById(id);

        if(usuarioDTO != null){
            return ResponseEntity.ok(usuarioDTO);
        }else{
            return null;
        }
    }
    
    @PostMapping("/{id}")
    public void addUpdateUsuario(@PathVariable("id") String id, @RequestBody UsuarioDTO usuario){
        usuarioService.addUsuario(id, usuario);
    }
}
