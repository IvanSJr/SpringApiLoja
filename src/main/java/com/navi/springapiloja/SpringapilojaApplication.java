package com.navi.springapiloja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.navi.springapiloja.domain.Categoria;
import com.navi.springapiloja.domain.Cidade;
import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.domain.Endereco;
import com.navi.springapiloja.domain.Estado;
import com.navi.springapiloja.domain.Produto;
import com.navi.springapiloja.domain.enums.TipoCliente;
import com.navi.springapiloja.repositories.CategoriaRepository;
import com.navi.springapiloja.repositories.CidadeRepository;
import com.navi.springapiloja.repositories.ClienteRepository;
import com.navi.springapiloja.repositories.EnderecoRepository;
import com.navi.springapiloja.repositories.EstadoRepository;
import com.navi.springapiloja.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringapilojaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringapilojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Bahia");
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Salvador", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Ivan Santos", "ivanjrjesus01@gmail.com", "08062313473", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71991085709","71985363655","7132514172"));
		Endereco end1 = new Endereco(null, "Nossa Senhora Aparecida", "412", "Quadra M Lote 22", "Itinga", "42739195", cli1, c4);
		Endereco end2 = new Endereco(null, "Edvaldo Cezar", "20", "Quadra J Lote 20", "Itinga", "42739240", cli1, c4);
		Endereco end3 = new Endereco(null, "Rua Arlindo Nogueira", "12", "Quadra A Lote 50", "Centro", "64000290", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2, end3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
	}

}
