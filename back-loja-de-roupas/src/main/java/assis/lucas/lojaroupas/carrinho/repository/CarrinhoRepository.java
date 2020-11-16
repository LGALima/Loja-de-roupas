package assis.lucas.lojaroupas.carrinho.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assis.lucas.lojaroupas.carrinho.model.Carrinho;
import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.usuario.model.Usuario;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	public List<Carrinho> findAllByUsuario(Usuario usuario);
	
	public Optional<Carrinho> findByUsuarioAndProduto(Usuario usuario, Produto produto);
}
