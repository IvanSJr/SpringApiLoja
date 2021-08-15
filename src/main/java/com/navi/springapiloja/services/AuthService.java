package com.navi.springapiloja.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.repositories.ClienteRepository;
import com.navi.springapiloja.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cli = clienteRepository.findByEmail(email);
		if(cli == null) {
			throw new ObjectNotFoundException("E-mail não encontrado.");
		}
		
		String newPassword = newPassword();
		cli.setSenha(bcrypt.encode(newPassword));
		clienteRepository.save(cli);
		emailService.sendNewPassword(cli, newPassword);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i = 0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // Gera um digito
			return (char) (rand.nextInt() + 48);
		}else if(opt == 1) { // Letra maiuscula
			return (char) (rand.nextInt() + 65);
		}else { // Letra minuscula
			return (char) (rand.nextInt() + 97);
		}
	}
	
}
