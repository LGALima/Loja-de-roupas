package assis.lucas.lojaroupas.tipoProduto.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assis.lucas.lojaroupas.tipoProduto.form.TipoProdutoForm;
import assis.lucas.lojaroupas.tipoProduto.model.TipoProduto;
import assis.lucas.lojaroupas.tipoProduto.service.TipoProdutoService;

@RestController
@RequestMapping("/tipo-produto")
public class TipoProdutoResource {

	@Autowired
	private TipoProdutoService tipoProdutoService;

	@GetMapping
	public ResponseEntity<List<TipoProduto>> buscarTodosTiposProduto() {
		return ResponseEntity.ok(this.tipoProdutoService.buscarTodosTiposProduto());
	}

	@GetMapping("/{idTipoProduto")
	public ResponseEntity<TipoProduto> buscarTipoProdutoPorId(@PathVariable Long idTipoProduto) {
		return ResponseEntity.ok(this.tipoProdutoService.buscarTipoProdutoPorId(idTipoProduto));
	}

	@PostMapping
	public ResponseEntity<TipoProduto> cadastrarTipoProduto(@Valid @RequestBody TipoProdutoForm tipoProdutoForm) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.tipoProdutoService.cadastrarTipoProduto(tipoProdutoForm));
	}

	@PutMapping("/{idTipoProduto}")
	public ResponseEntity<TipoProduto> atualizarTipoProduto(@Valid @RequestBody TipoProdutoForm tipoProdutoForm,
			@PathVariable Long idTipoProduto) {
		return ResponseEntity.ok(this.tipoProdutoService.atualizarTipoProduto(tipoProdutoForm, idTipoProduto));
	}

	@DeleteMapping("/{idTipoProduto}")
	public ResponseEntity<?> excluirTipoProduto(@PathVariable Long idTipoProduto) {
		this.tipoProdutoService.excluirTipoProduto(idTipoProduto);
		return ResponseEntity.noContent().build();
	}
}
