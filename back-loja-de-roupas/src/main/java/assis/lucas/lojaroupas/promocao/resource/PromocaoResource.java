package assis.lucas.lojaroupas.promocao.resource;

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

import assis.lucas.lojaroupas.promocao.form.PromocaoForm;
import assis.lucas.lojaroupas.promocao.model.Promocao;
import assis.lucas.lojaroupas.promocao.service.PromocaoService;

@RestController
@RequestMapping("/promocao")
public class PromocaoResource {
	
	@Autowired
	private PromocaoService promocaoService;
	
	@GetMapping
	public ResponseEntity<List<Promocao>> buscarTodasPromocoes() {
		return ResponseEntity.ok(this.promocaoService.buscarTodasPromocoes());
	}
	
	@GetMapping("/{idPromocao}")
	public ResponseEntity<Promocao> buscarPromocaoPorId(@PathVariable Long idPromocao) {
		return ResponseEntity.ok(this.promocaoService.buscarPromocaoPorId(idPromocao));
	}
	
	@PostMapping
	public ResponseEntity<Promocao> cadastrarPromocao(@Valid @RequestBody PromocaoForm promocaoForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.promocaoService.cadastrarPromocao(promocaoForm));
	}
	
	@PutMapping("/{idPromocao}")
	public ResponseEntity<Promocao> atualizarPromocao(@Valid @RequestBody PromocaoForm promocaoForm, @PathVariable Long idPromocao) {
		return ResponseEntity.ok(this.promocaoService.atualizarPromocao(promocaoForm, idPromocao));
	}
	
	@DeleteMapping("/{idPromocao}")
	public ResponseEntity<?> excluirPromocao(@PathVariable Long idPromocao) {
		this.promocaoService.excluirPromocao(idPromocao);
		return ResponseEntity.noContent().build();
	}
}
