package com.example.microusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microusuarios.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String>{
    
}
