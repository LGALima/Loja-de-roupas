package assis.lucas.lojaroupas.usuario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired 
	private UsuarioService usuarioService;
	
	@GetMapping // TODO: trocar para dto
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
		return ResponseEntity.ok(usuarioService.buscarTodosUsuarios());
	}
	
	@GetMapping("/{idUsuario}") // TODO: trocar para dto
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(this.usuarioService.buscarUsuarioPorId(idUsuario));
	}
}
