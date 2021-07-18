package com.navi.springapiloja.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Pedido;
import com.navi.springapiloja.repositories.PedidoRepository;
import com.navi.springapiloja.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto de id " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
