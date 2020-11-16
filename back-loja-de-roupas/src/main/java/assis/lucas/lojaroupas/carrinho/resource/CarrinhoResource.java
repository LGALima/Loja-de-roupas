package assis.lucas.lojaroupas.carrinho.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assis.lucas.lojaroupas.carrinho.form.CarrinhoForm;
import assis.lucas.lojaroupas.carrinho.model.Carrinho;
import assis.lucas.lojaroupas.carrinho.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@GetMapping() // TODO: Remover depois talvez
	public ResponseEntity<List<Carrinho>> buscarTodosCarrinhos() {
		return ResponseEntity.ok().body(this.carrinhoService.buscarTodosCarrinhos());
	}
	
	@GetMapping("/{idCarrinho}") // TODO: Remover depois talvez
	public ResponseEntity<Carrinho> buscarCarrinhoPorId(@PathVariable Long idCarrinho) {
		return ResponseEntity.ok().body(this.carrinhoService.buscarTodosCarrinhosPorId(idCarrinho));
	}
	
	@GetMapping("/usuario/{idUsuario}") // TODO: Pegar pelo token o id
	public ResponseEntity<List<Carrinho>> buscarTodosCarrinhosPorIdUsario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok().body(this.carrinhoService.buscarTodosCarrinhosPorIdUsario(idUsuario));
	}
	
	@PostMapping() // TODO: Pegar idUsuario por token
	public ResponseEntity<Carrinho> cadastrarCarrinho(@Valid @RequestBody CarrinhoForm carrinhoForm) {
		return ResponseEntity.ok().body(this.carrinhoService.cadastrarCarrinho(carrinhoForm));
	}
	
	@PutMapping("/{idCarrinho}/{quantidade}") // TODO: Confirmar usuario
	public ResponseEntity<Carrinho> atualizarQuantidadeProdutoCarrinho(@PathVariable Long idCarrinho, @PathVariable Long quantidade) {
		return ResponseEntity.ok().body(this.carrinhoService.atualizarQuantidadeProdutoCarrinho(idCarrinho, quantidade));
	}
	
	@DeleteMapping("/{idCarrinho}") // TODO: Confirmar usuario
	public ResponseEntity<?> excluirCarrinho(@PathVariable Long idCarrinho) {
		this.carrinhoService.excluirCarrinho(idCarrinho);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/todos/{idUsuario}") // TODO: Confirmar usuario
	public ResponseEntity<?> excluirTodosCarrinho(@PathVariable Long idUsuario) {
		this.carrinhoService.excluirTodosCarrinho(idUsuario);
		return ResponseEntity.noContent().build();
	}
}
