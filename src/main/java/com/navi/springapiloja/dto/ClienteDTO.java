package com.navi.springapiloja.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.services.validations.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigat�rio.")
	@Length(min=2, max=120, message = "Tamanho m�nimo de 2 e m�ximo de 120.")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigat�rio.")
	@Email(message = "E-mail inv�lido.")
	private String email;
	
	public ClienteDTO() {

	}
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
