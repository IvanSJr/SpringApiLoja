package com.navi.springapiloja.dto;

import java.io.Serializable;

import com.navi.springapiloja.domain.Categoria;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;


public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigat�rio")
	@Length(min = 5, max = 80, message = "Min�mo de 5, m�ximo de 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
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
	

}
