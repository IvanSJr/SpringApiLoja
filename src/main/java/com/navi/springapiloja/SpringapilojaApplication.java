package com.navi.springapiloja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.navi.springapiloja.services.S3Service;

@SpringBootApplication
public class SpringapilojaApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringapilojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		service.uploadFile("C:\\Users\\Ferra\\Downloads\\51377009249_eb809a034c_o.jpg");
	}

}
