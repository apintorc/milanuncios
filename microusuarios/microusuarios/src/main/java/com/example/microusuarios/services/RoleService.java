package com.example.microusuarios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.interfaces.IRoleService;
import com.example.microusuarios.model.Role;
import com.example.microusuarios.repository.IRoleRespository;

@Service
public class RoleService implements IRoleService{
    
    @Autowired
    IRoleRespository roleRespository;

    @Override
    public List<RoleDTO> getRoles() {
        List<Role> roles = roleRespository.findAll();
        List<RoleDTO> roleDTOs = new ArrayList<>();

        for (Role role : roles) {
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(role, roleDTOs, "usuarios");
            roleDTOs.add(roleDTO);
        }

        return roleDTOs;
    }

    @Override
    public RoleDTO getRoleById(String role) {
        Role role2 = roleRespository.findById(role).orElse(null);
        RoleDTO roleDTO = new RoleDTO();

        BeanUtils.copyProperties(role2, roleDTO, "usuarios");

        return roleDTO;
    }
}
