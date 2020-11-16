package assis.lucas.lojaroupas.produto.resource;

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

import assis.lucas.lojaroupas.produto.form.ProdutoForm;
import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.produto.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodosProdutos() {
		return ResponseEntity.ok().body(this.produtoService.buscarTodosProdutos());
	}

	@GetMapping("/{idProduto}")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long idProduto) {
		return ResponseEntity.ok().body(this.produtoService.buscarProdutoPorId(idProduto));
	}
	
	@GetMapping("/tipo-produto/{idTipoProduto}")
	public ResponseEntity<List<Produto>> buscarProdutoPorIdTipoProduto(@PathVariable Long idTipoProduto) {
		return ResponseEntity.ok().body(this.produtoService.buscarProdutoPorIdTipoProduto(idTipoProduto));
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produto>> buscarProdutoPorDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok().body(this.produtoService.buscarProdutoPorDescricao(descricao));
	}
	@PostMapping
	public ResponseEntity<Produto> cadastrarProduto(@Valid @RequestBody ProdutoForm produtoForm) {
		return ResponseEntity.created(null).body(this.produtoService.cadastrarProduto(produtoForm));
	}
	
	@PutMapping("/{idProduto}")
	public ResponseEntity<Produto> atualizarProduto(@Valid @RequestBody ProdutoForm produtoForm, @PathVariable Long idProduto) {
		return ResponseEntity.ok().body(this.produtoService.atualizarProduto(produtoForm, idProduto));
	}
	
	@DeleteMapping("/{idProduto}")
	public ResponseEntity<?> excluirProduto(@PathVariable Long idProduto) {
		this.produtoService.excluirProduto(idProduto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("manipular-estoque/{idProduto}/{quantidade}")
	public ResponseEntity<Produto> manipularEstoque(@PathVariable Long idProduto, @PathVariable Long quantidade) {
		return ResponseEntity.ok().body(this.produtoService.manipularEstoque(idProduto, quantidade));
	}
}
