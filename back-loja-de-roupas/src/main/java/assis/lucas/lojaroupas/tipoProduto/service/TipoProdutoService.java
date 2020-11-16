package assis.lucas.lojaroupas.tipoProduto.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.tipoProduto.form.TipoProdutoForm;
import assis.lucas.lojaroupas.tipoProduto.model.TipoProduto;
import assis.lucas.lojaroupas.tipoProduto.repository.TipoProdutoRepository;

@Service
public class TipoProdutoService {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	public List<TipoProduto> buscarTodosTiposProduto() {
		List<TipoProduto> tiposProduto = tipoProdutoRepository.findAll();
		return tiposProduto;
	}
	
	public TipoProduto buscarTipoProdutoPorId(Long idTipoProduto) {
		Optional<TipoProduto> oTipoProduto = this.tipoProdutoRepository.findById(idTipoProduto);
		
		if(!oTipoProduto.isPresent())
			throw new EmptyResultDataAccessException("O Tipo do Produto informado não existe", 1);
		
		return oTipoProduto.get();
	}

	public TipoProduto cadastrarTipoProduto(@Valid TipoProdutoForm tipoProdutoForm) {
		TipoProduto tipoProduto = new TipoProduto();
		tipoProduto.setDescricao(tipoProdutoForm.getDescricao());
		return this.tipoProdutoRepository.save(tipoProduto);
	}

	public TipoProduto atualizarTipoProduto(@Valid TipoProdutoForm tipoProdutoForm, Long idTipoProduto) {
		TipoProduto tipoProduto = this.buscarTipoProdutoPorId(idTipoProduto);
		tipoProduto.setDescricao(tipoProdutoForm.getDescricao());
		return this.tipoProdutoRepository.save(tipoProduto);
	}

	public void excluirTipoProduto(Long idTipoProduto) {
		TipoProduto tipoProduto = this.buscarTipoProdutoPorId(idTipoProduto);
		this.tipoProdutoRepository.delete(tipoProduto);
	}
}
