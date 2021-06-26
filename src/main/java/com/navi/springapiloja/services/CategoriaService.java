package com.navi.springapiloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Categoria;
import com.navi.springapiloja.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) { 
		Optional<Categoria> obj = repository.findById(id); 
		return obj.orElse(null); 
	}
	
}
