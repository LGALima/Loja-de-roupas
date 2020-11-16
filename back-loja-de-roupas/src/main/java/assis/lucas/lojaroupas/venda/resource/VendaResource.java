package assis.lucas.lojaroupas.venda.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assis.lucas.lojaroupas.venda.model.Venda;
import assis.lucas.lojaroupas.venda.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaResource {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<Venda>> buscarTodasVendas() {
		return ResponseEntity.ok(this.vendaService.buscarTodasVendas());
	}
	
	@GetMapping("{idVenda}")
	public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long idVenda) {
		return ResponseEntity.ok(this.vendaService.buscarVendaPorId(idVenda));
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<List<Venda>> buscarVendaPorIdUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(this.vendaService.buscarVendaPorIdUsuario(idUsuario));
	}
	
	@PostMapping("/{idUsuario}")
	public ResponseEntity<Venda> efetuarVendaPorCarrinho(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(this.vendaService.efetuarVendaPorCarrinho(idUsuario));
	}
}
