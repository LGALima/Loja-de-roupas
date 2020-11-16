package assis.lucas.lojaroupas.venda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.venda.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

	public List<Venda> findAllByUsuario(Usuario usuario);

}
