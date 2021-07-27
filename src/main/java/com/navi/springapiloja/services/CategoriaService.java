package com.navi.springapiloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Categoria;
import com.navi.springapiloja.repositories.CategoriaRepository;
import com.navi.springapiloja.services.exceptions.ObjectNotFoundException;
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e){
			throw new com.navi.springapiloja.services.exceptions.DataIntegrityViolationException("Não é possivel excluir uma categoria que possui produtos.");
		}

	}
}
