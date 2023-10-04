package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;

public interface IUsuarioService {
    
    public List<UsuarioDTO> getUsuarios();
    public UsuarioDTO getUsuarioById(String user);
    public void addUsuario(String id, UsuarioDTO u);
    public List<RoleDTO> getRolesByUser(String user);
}
