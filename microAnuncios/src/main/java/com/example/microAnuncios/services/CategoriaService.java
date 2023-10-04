package com.example.microAnuncios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microAnuncios.interfaces.ICategoriaService;
import com.example.microAnuncios.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
   
    @Autowired
    CategoriaRepository categoriaRepository;
}
