package com.navi.springapiloja.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.navi.springapiloja.domain.Categoria;
import com.navi.springapiloja.domain.Cidade;
import com.navi.springapiloja.domain.Cliente;
import com.navi.springapiloja.domain.Endereco;
import com.navi.springapiloja.domain.Estado;
import com.navi.springapiloja.domain.ItemPedido;
import com.navi.springapiloja.domain.Pagamento;
import com.navi.springapiloja.domain.PagamentoComBoleto;
import com.navi.springapiloja.domain.PagamentoComCartao;
import com.navi.springapiloja.domain.Pedido;
import com.navi.springapiloja.domain.Produto;
import com.navi.springapiloja.domain.enums.EstadoPagamento;
import com.navi.springapiloja.domain.enums.TipoCliente;
import com.navi.springapiloja.repositories.CategoriaRepository;
import com.navi.springapiloja.repositories.CidadeRepository;
import com.navi.springapiloja.repositories.ClienteRepository;
import com.navi.springapiloja.repositories.EnderecoRepository;
import com.navi.springapiloja.repositories.EstadoRepository;
import com.navi.springapiloja.repositories.ItemPedidoRepository;
import com.navi.springapiloja.repositories.PagamentoRepository;
import com.navi.springapiloja.repositories.PedidoRepository;
import com.navi.springapiloja.repositories.ProdutoRepository;

@Service
public class DbService {
	
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bpe;
	
	public void instantiateTestDataBase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Inform�tica");
		Categoria cat2 = new Categoria(null, "Escrit�rio");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletr�nicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decora��o");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escrit�rio", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "Tv true color", 1200.00);
		Produto p8 = new Produto(null, "Ro�adeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "S�o Paulo");
		Estado est3 = new Estado(null, "Bahia");
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "S�o Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Salvador", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Ivan Santos", "ivanjrjesus01@gmail.com", "08062313473", TipoCliente.PESSOAFISICA, bpe.encode("27062001jr"));
		cli1.getTelefones().addAll(Arrays.asList("71991085709","71985363655","7132514172"));
		Endereco end1 = new Endereco(null, "Nossa Senhora Aparecida", "412", "Quadra M Lote 22", "Itinga", "42739195", cli1, c4);
		Endereco end2 = new Endereco(null, "Edvaldo Cezar", "20", "Quadra J Lote 20", "Itinga", "42739240", cli1, c4);
		Endereco end3 = new Endereco(null, "Rua Arlindo Nogueira", "12", "Quadra A Lote 50", "Centro", "64000290", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2, end3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("10/07/2020 08:55"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("19/07/2021 13:25"), cli1, end2);
		Pedido ped3 = new Pedido(null, sdf.parse("30/05/2021 11:15"), cli1, end2);
		Pedido ped4 = new Pedido(null, sdf.parse("30/05/2021 20:55"), cli1, end3);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, null, sdf.parse("27/07/2021 00:00"));
		ped2.setPagamento(pag2);
		
		Pagamento pag3 = new PagamentoComCartao(null, EstadoPagamento.CANCELADO, ped3, 12);
		ped3.setPagamento(pag3);
		
		Pagamento pag4 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped4, sdf.parse("17/07/2021 00:00"), sdf.parse("20/07/2021 00:00"));
		ped4.setPagamento(pag4);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2, ped3, ped4));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2, pag3, pag4));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));	
	}
}
