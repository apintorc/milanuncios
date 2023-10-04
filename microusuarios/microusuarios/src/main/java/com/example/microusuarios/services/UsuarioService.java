package com.example.microusuarios.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;
import com.example.microusuarios.model.Role;
import com.example.microusuarios.model.Usuario;
import com.example.microusuarios.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> uDtos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioDTO u = new UsuarioDTO();
            List<RoleDTO> rDtos = new ArrayList<>();

            Set<Role> roles = usuario.getRoles();
            for (Role role : roles) {
                RoleDTO roleDTO = new RoleDTO(role.getRole(), role.getFuncion());
                rDtos.add(roleDTO);
            }

            BeanUtils.copyProperties(usuario, u, "roles");
            u.setRoles(rDtos);

            uDtos.add(u);
        }
        return uDtos;
    }

    @Override
    public UsuarioDTO getUsuarioById(String user) {
        Usuario usuario = usuarioRepository.findById(user).orElse(null);
        Set<Role> roles = usuario.getRoles();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        List<RoleDTO> rDtos = new ArrayList<>();

        for (Role role : roles) {
            RoleDTO roleDTO = new RoleDTO(role.getRole(), role.getFuncion());
            rDtos.add(roleDTO);
        }
        
        BeanUtils.copyProperties(usuario, usuarioDTO, "roles");
        usuarioDTO.setRoles(rDtos);

        return usuarioDTO;
    }

    @Override
    public void addUsuario(String id, UsuarioDTO u) {
        
        Usuario usuario;
        List<RoleDTO> rDtos = u.getRoles();
        Set<Role> roles = new Array2DHashSet<Role>();

        if(id == null){
            usuario = new Usuario();
        }else{
            usuario = usuarioRepository.findById(id).orElse(null);
        }

        BeanUtils.copyProperties(u, usuario, "user", "roles");

        for (RoleDTO roleDTO : rDtos) {
            Role role = new Role(roleDTO.getRole(),roleDTO.getFuncion());
            roles.add(role);
        }
        usuario.setRoles(roles);
    
        usuarioRepository.save(usuario);
    }

    @Override
	public List<RoleDTO> getRolesByUser(String user) {
		Usuario usuario = usuarioRepository.findById(user).orElse(null);
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		if(usuario != null) {
			List<Role> roles = new ArrayList<Role>(usuario.getRoles());
			for (Role role : roles) {
				RoleDTO roleDTO = new RoleDTO(role.getRole(), role.getFuncion());
				rolesDTO.add(roleDTO);
			}
		}
		return rolesDTO;
	}
}
