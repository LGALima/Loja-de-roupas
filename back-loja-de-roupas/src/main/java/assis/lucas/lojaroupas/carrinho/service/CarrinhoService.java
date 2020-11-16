package assis.lucas.lojaroupas.carrinho.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.carrinho.form.CarrinhoForm;
import assis.lucas.lojaroupas.carrinho.model.Carrinho;
import assis.lucas.lojaroupas.carrinho.repository.CarrinhoRepository;
import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.produto.service.ProdutoService;
import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.usuario.repository.UsuarioRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoService produtoService;

	public List<Carrinho> buscarTodosCarrinhosPorIdUsario(Long idUsuario) {
		Optional<Usuario> oUsuario = this.usuarioRepository.findById(idUsuario);
		if (!oUsuario.isPresent())
			throw new EmptyResultDataAccessException("O usuario informado não existe!", 1);

		List<Carrinho> listCarrinho = this.carrinhoRepository.findAllByUsuario(oUsuario.get());

		return listCarrinho;
	}

	public Carrinho buscarTodosCarrinhosPorId(Long idCarrinho) {
		Optional<Carrinho> oCarrinho = this.carrinhoRepository.findById(idCarrinho);
		if (!oCarrinho.isPresent())
			throw new EmptyResultDataAccessException("Carrinho não encontrado", 1);

		return oCarrinho.get();
	}

	public List<Carrinho> buscarTodosCarrinhos() {
		List<Carrinho> listCarrinho = this.carrinhoRepository.findAll();
		return listCarrinho;
	}

	public Carrinho cadastrarCarrinho(@Valid CarrinhoForm carrinhoForm) {

		Produto produto = this.produtoService.buscarProdutoPorId(carrinhoForm.getIdProduto());

		Optional<Usuario> oUsuario = this.usuarioRepository.findById(carrinhoForm.getIdUsuario());
		if (!oUsuario.isPresent())
			throw new EmptyResultDataAccessException("Usuario não encontrado", 1);

		Optional<Carrinho> oCarrinhoSalvo = this.carrinhoRepository.findByUsuarioAndProduto(oUsuario.get(),
				produto);

		if (!oCarrinhoSalvo.isPresent()) {
			Carrinho carrinho = new Carrinho();
			if (carrinhoForm.getQuantidade() > produto.getQuantidade())
				throw new IllegalArgumentException("A quantidade pedida excede a em estoque!");
			carrinho.setQuantidade(carrinhoForm.getQuantidade());

			carrinho.setProduto(produto);

			carrinho.setUsuario(oUsuario.get());
			return carrinhoRepository.save(carrinho);
		} else {
			Carrinho carrinho = oCarrinhoSalvo.get();

			carrinho.setQuantidade(carrinho.getQuantidade() + carrinhoForm.getQuantidade());

			if (carrinho.getQuantidade() > carrinho.getProduto().getQuantidade())
				throw new IllegalArgumentException("A quantidade pedida excede a em estoque!");

			return carrinhoRepository.save(carrinho);
		}
	}

	public Carrinho atualizarQuantidadeProdutoCarrinho(Long idCarrinho, Long quantidade) {
		Optional<Carrinho> oCarrinho = this.carrinhoRepository.findById(idCarrinho);

		if (!oCarrinho.isPresent())
			throw new EmptyResultDataAccessException("O item do carrinho não existe", 1);

		Carrinho carrinho = oCarrinho.get();
		if (quantidade > carrinho.getProduto().getQuantidade())
			throw new IllegalArgumentException("A quantidade pedida excede a em estoque!");

		carrinho.setQuantidade(quantidade);
		return this.carrinhoRepository.save(carrinho);
	}

	public void excluirCarrinho(Long idCarrinho) {
		Optional<Carrinho> oCarrinho = this.carrinhoRepository.findById(idCarrinho);

		if (!oCarrinho.isPresent())
			throw new EmptyResultDataAccessException("O item do carrinho não existe", 1);

		this.carrinhoRepository.delete(oCarrinho.get());
	}

	public void excluirTodosCarrinho(Long idUsuario) {
		Optional<Usuario> oUsuario = this.usuarioRepository.findById(idUsuario);
		if(!oUsuario.isPresent())
			throw new EmptyResultDataAccessException("O usuario informado não existe", 1);
		
		List<Carrinho> listCarrinho = this.carrinhoRepository.findAllByUsuario(oUsuario.get());

		this.carrinhoRepository.deleteAll(listCarrinho);
	}
}
