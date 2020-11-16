package assis.lucas.lojaroupas.venda.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.carrinho.model.Carrinho;
import assis.lucas.lojaroupas.carrinho.service.CarrinhoService;
import assis.lucas.lojaroupas.produto.service.ProdutoService;
import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.usuario.service.UsuarioService;
import assis.lucas.lojaroupas.venda.model.Venda;
import assis.lucas.lojaroupas.venda.repository.VendaRepository;
import assis.lucas.lojaroupas.vendaProduto.model.VendaProduto;
import assis.lucas.lojaroupas.vendaProduto.repository.VendaProdutoRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VendaProdutoRepository vendaProdutoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Venda buscarVendaPorId(Long idVenda) {
		Optional<Venda> oVenda = this.vendaRepository.findById(idVenda);
		if(!oVenda.isPresent())
			throw new EmptyResultDataAccessException("Venda não encontrada!", 1);
		
		return oVenda.get();
	}

	public List<Venda> buscarTodasVendas() {
		List<Venda> listVenda = this.vendaRepository.findAll();
		return listVenda;
	}

	public Venda efetuarVendaPorCarrinho(Long idUsuario) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
		
		List<Carrinho> listCarrinho = this.carrinhoService.buscarTodosCarrinhosPorIdUsario(idUsuario);
		
		List<VendaProduto> listVendaProduto = listCarrinho
				.stream()
				.map(VendaProduto::new)
				.collect(Collectors.toList());

		// Debita oque foi comprado
		for(Carrinho carrinho : listCarrinho) {
			this.produtoService.manipularEstoque(carrinho.getProduto().getId(), carrinho.getQuantidade() * -1);
		}
		
		Venda venda = new Venda();
		
		venda.setTotal(listVendaProduto.stream().mapToDouble(v -> v.getTotal()).sum());
		venda.setUsuario(usuario);
		venda.setDataHoraVenda(LocalDateTime.now());
		
		this.carrinhoService.excluirTodosCarrinho(idUsuario);
		venda = this.vendaRepository.save(venda);
		
		for(VendaProduto vp : listVendaProduto) {
			vp.setVenda(venda);
		}
		
		
		venda.setVendasProdutos(this.vendaProdutoRepository.saveAll(listVendaProduto));
		return venda;
	}

	public List<Venda> buscarVendaPorIdUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
		
		List<Venda> listVenda = this.vendaRepository.findAllByUsuario(usuario);
		return listVenda;
	}

}
