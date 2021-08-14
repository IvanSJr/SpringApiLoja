package com.navi.springapiloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.repositories.ClienteRepository;
import com.navi.springapiloja.security.UserSpringSecurity;

@Service
public class UserDetailsServicesImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = clienteRepository.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSpringSecurity(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
