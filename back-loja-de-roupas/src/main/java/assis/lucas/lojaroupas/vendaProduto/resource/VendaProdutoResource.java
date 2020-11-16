package assis.lucas.lojaroupas.vendaProduto.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assis.lucas.lojaroupas.vendaProduto.model.VendaProduto;
import assis.lucas.lojaroupas.vendaProduto.repository.VendaProdutoRepository;

@RestController
@RequestMapping("/venda-produto")
public class VendaProdutoResource {

	@Autowired
	private VendaProdutoRepository vendaProdutoRepository;
	
	@GetMapping
	public List<VendaProduto> buscarTodosVendasProdutos() {
		List<VendaProduto> listVendaProduto = this.vendaProdutoRepository.findAll();
		return listVendaProduto;
	}
	
	@GetMapping("/{idVendaProduto")
	public VendaProduto buscarVendaProdutoPorId(@PathVariable Long idVendaProduto) {
		Optional<VendaProduto> oVendaProduto = this.vendaProdutoRepository.findById(idVendaProduto);
		if(!oVendaProduto.isPresent())
			throw new EmptyResultDataAccessException("A venda do produto não encontrada", 1);
		
		return oVendaProduto.get();
	}
}
