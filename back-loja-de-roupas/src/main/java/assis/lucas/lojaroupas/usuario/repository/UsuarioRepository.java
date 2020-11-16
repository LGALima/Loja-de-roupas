package assis.lucas.lojaroupas.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assis.lucas.lojaroupas.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
