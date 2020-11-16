package assis.lucas.lojaroupas.produto.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.produto.form.ProdutoForm;
import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.produto.repository.ProdutoRepository;
import assis.lucas.lojaroupas.promocao.model.Promocao;
import assis.lucas.lojaroupas.promocao.repository.PromocaoRepository;
import assis.lucas.lojaroupas.tipoProduto.model.TipoProduto;
import assis.lucas.lojaroupas.tipoProduto.repository.TipoProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	@Autowired
	private PromocaoRepository promocaoRepository;

	public Produto cadastrarProduto(@Valid ProdutoForm produtoForm) {
		Produto produto = new Produto();
		produto.setDescricao(produtoForm.getDescricao());
		produto.setMarca(produtoForm.getMarca());
		produto.setQuantidade(produtoForm.getQuantidade());
		produto.setValor(produtoForm.getValor());
		
		Optional<TipoProduto> oTipoProduto = this.tipoProdutoRepository.findById(produtoForm.getIdTipoProduto());
		if(!oTipoProduto.isPresent())
			throw new EmptyResultDataAccessException("O produto não pode ser cadastrado se o Tipo do Produto informado não existe", 1);
		
		produto.setTipoProduto(oTipoProduto.get());
		
		if(produtoForm.getIdPromocao() != null) {
			Optional<Promocao> oPromocao = this.promocaoRepository.findById(produtoForm.getIdPromocao());			
			if(!oPromocao.isPresent())
				throw new EmptyResultDataAccessException("O produto não pode ser cadastrado se a promoção informada não existe!", 1);
			
			produto.setPromocao(oPromocao.get());
		} else {
			produto.setPromocao(null);
		}
			
		return this.produtoRepository.save(produto);
	}

	public Produto atualizarProduto(@Valid ProdutoForm produtoForm, Long idProduto) {
		Optional<Produto> oProduto = this.produtoRepository.findById(idProduto);
		if(!oProduto.isPresent())
			throw new EmptyResultDataAccessException("O produto informado não existe", 1);
		
		Produto produto = oProduto.get();
		produto.setDescricao(produtoForm.getDescricao());
		produto.setMarca(produtoForm.getMarca());
		produto.setQuantidade(produtoForm.getQuantidade());
		produto.setValor(produtoForm.getValor());
		
		Optional<TipoProduto> oTipoProduto = this.tipoProdutoRepository.findById(produtoForm.getIdTipoProduto());
		if(!oTipoProduto.isPresent())
			throw new EmptyResultDataAccessException("O produto não pode ser atualizado se o Tipo do Produto informado não existe", 1);
		
		produto.setTipoProduto(oTipoProduto.get());
		
		if(produtoForm.getIdPromocao() != null) {
			Optional<Promocao> oPromocao = this.promocaoRepository.findById(produtoForm.getIdPromocao());			
			if(!oPromocao.isPresent())
				throw new EmptyResultDataAccessException("O produto não pode ser atualizado se a promoção informada não existe!", 1);
			
			produto.setPromocao(oPromocao.get());
		} else {
			produto.setPromocao(null);
		}
			
		return this.produtoRepository.save(produto);
	}

	
	public void excluirProduto(Long idProduto) {
		Optional<Produto> oProduto = this.produtoRepository.findById(idProduto);
		
		if(!oProduto.isPresent())
			throw new EmptyResultDataAccessException("O produto informado não existe", 1);
		
		this.produtoRepository.delete(oProduto.get());
	}

	public Produto buscarProdutoPorId(Long idProduto) {
		Optional<Produto> oProduto = this.produtoRepository.findById(idProduto);
		if (!oProduto.isPresent())
			throw new EmptyResultDataAccessException("Produto não existe!", 1);
		
		return oProduto.get();
	}

	public List<Produto> buscarTodosProdutos() {
		List<Produto> listProduto = this.produtoRepository.findAll();
		return listProduto;
	}
	
	public Produto manipularEstoque(Long idProduto, Long quantidade) {
		Optional<Produto> oProduto = this.produtoRepository.findById(idProduto);
		if(!oProduto.isPresent())
			throw new EmptyResultDataAccessException("O produto informado não existe", 1);
		
		Produto produto = oProduto.get();
		
		Long estoqueAtual = produto.getQuantidade() + quantidade;
		if(estoqueAtual < 0) 
			throw new IllegalArgumentException("O estoque do produto não pode ser negativo!");
		
		produto.setQuantidade(produto.getQuantidade() + quantidade);
		return this.produtoRepository.save(produto);
	}

	
	public List<Produto> buscarProdutoPorIdTipoProduto(Long idTipoProduto) {
		Optional<TipoProduto> oTipoProduto = this.tipoProdutoRepository.findById(idTipoProduto);
		if(!oTipoProduto.isPresent())
			throw new EmptyResultDataAccessException("O Tipo do Produto informado não existe", 1);
		
		List<Produto> listProduto = this.produtoRepository.findAllByTipoProduto(oTipoProduto.get());
		return listProduto;
	}

	public  List<Produto> buscarProdutoPorDescricao(String descricao) {
		if(descricao == null)
			descricao = "";
		List<Produto> listProduto = this.produtoRepository.findAllByDescricaoIgnoreCaseContaining(descricao);
		return listProduto;
	}
	
	public List<Produto> buscarProdutosPorListIds(List<Long> listIds) {
		return this.produtoRepository.findAllById(listIds);
	}
}
