package com.example.microusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microusuarios.model.Role;

@Repository
public interface IRoleRespository extends JpaRepository<Role, String>{
    
}
