package assis.lucas.lojaroupas.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.tipoProduto.model.TipoProduto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findAllByTipoProduto(TipoProduto tipoProduto);
	
	public List<Produto> findAllByDescricaoIgnoreCaseContaining(String descricao);
}
