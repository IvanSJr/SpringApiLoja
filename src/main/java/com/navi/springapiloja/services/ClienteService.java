package com.navi.springapiloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.repositories.ClienteRepository;
import com.navi.springapiloja.services.exceptions.ObjectNotFoundException;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
