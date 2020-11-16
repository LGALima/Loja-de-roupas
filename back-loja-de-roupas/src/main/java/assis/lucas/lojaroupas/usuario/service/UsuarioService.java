package assis.lucas.lojaroupas.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario buscarUsuarioPorId(Long idUsuario) {
		Optional<Usuario> oUsuario = this.usuarioRepository.findById(idUsuario);
		if (!oUsuario.isPresent())
			throw new EmptyResultDataAccessException("Usuário não encontrado!", 1);

		return oUsuario.get();
	}
	
	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> listUsuario = this.usuarioRepository.findAll();
		return listUsuario;
	}
}
