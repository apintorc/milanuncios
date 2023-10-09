package com.example.microusuarios.interfaces;

import java.util.List;
import com.example.microusuarios.dto.RoleDTO;

public interface IRoleService {
    
    public List<RoleDTO> getRoles();
    public RoleDTO getRoleById(String role);
}
