package com.navi.springapiloja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.navi.springapiloja.domain.Categoria;
import com.navi.springapiloja.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringapilojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository serviceRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringapilojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		serviceRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
