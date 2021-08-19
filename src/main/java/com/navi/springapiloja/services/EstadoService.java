package com.navi.springapiloja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Estado;
import com.navi.springapiloja.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll(){
		return estadoRepository.findAllByOrderByNome();
	}
}
