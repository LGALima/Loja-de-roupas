package assis.lucas.lojaroupas.promocao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.promocao.form.PromocaoForm;
import assis.lucas.lojaroupas.promocao.model.Promocao;
import assis.lucas.lojaroupas.promocao.repository.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository promocaoRepository;
	
	public List<Promocao> buscarTodasPromocoes() {
		List<Promocao> listPromocao = this.promocaoRepository.findAll();
		return listPromocao;
	}
	
	public Promocao buscarPromocaoPorId(Long idPromocao) {
		Optional<Promocao> oPromocao = this.promocaoRepository.findById(idPromocao);
		
		if(!oPromocao.isPresent())
			throw new EmptyResultDataAccessException("Promoção não encontrada", 1);
		
		return oPromocao.get();
	}

	public Promocao cadastrarPromocao(@Valid PromocaoForm promocaoForm) {
		Promocao promocao = new Promocao();
		promocao.setDesconto(promocaoForm.getDesconto());
		promocao.setDescricao(promocaoForm.getDescricao());
		
		return this.promocaoRepository.save(promocao);
	}
	
	public Promocao atualizarPromocao(@Valid PromocaoForm promocaoForm, Long idPromocao) {
		Optional<Promocao> oPromocao = this.promocaoRepository.findById(idPromocao);
		
		if(!oPromocao.isPresent())
			throw new EmptyResultDataAccessException("A promoção informada não existe", 1);
		
		Promocao promocao = new Promocao(idPromocao, promocaoForm.getDescricao(), promocaoForm.getDesconto());
		return this.promocaoRepository.save(promocao);
	}
	
	public void excluirPromocao(Long idPromocao) {
		this.promocaoRepository.delete(buscarPromocaoPorId(idPromocao));
	}
}
