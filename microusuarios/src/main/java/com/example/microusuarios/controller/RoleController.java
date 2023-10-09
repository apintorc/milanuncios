package com.example.microusuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getRoles(){
        List<RoleDTO> roleDTOs = roleService.getRoles();
        return ResponseEntity.ok(roleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") String id){
        RoleDTO roleDTO = roleService.getRoleById(id);

        if(roleDTO == null){
            return null;
        }else{
            return ResponseEntity.ok(roleDTO);
        }
    }
}
