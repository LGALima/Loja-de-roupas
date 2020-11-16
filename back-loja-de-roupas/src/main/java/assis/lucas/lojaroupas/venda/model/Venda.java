package assis.lucas.lojaroupas.venda.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import assis.lucas.lojaroupas.usuario.model.Usuario;
import assis.lucas.lojaroupas.vendaProduto.model.VendaProduto;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda")
	private Long id;
	
	@NotNull(message = "O total não deve ser nulo")
	@Column(name = "total")
	private Double total;
	
	@Column(name = "data_hora_venda")
	private LocalDateTime dataHoraVenda;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "venda")
	private List<VendaProduto> vendasProdutos = new ArrayList<VendaProduto>();

	public Venda(Long id, @NotNull(message = "O total não deve ser nulo") Double total, LocalDateTime dataHoraVenda,
			Usuario usuario, List<VendaProduto> vendasProdutos) {
		this.id = id;
		this.total = total;
		this.dataHoraVenda = dataHoraVenda;
		this.usuario = usuario;
		this.vendasProdutos = vendasProdutos;
	}

	public Venda() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDateTime getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<VendaProduto> getVendasProdutos() {
		return vendasProdutos;
	}

	public void setVendasProdutos(List<VendaProduto> vendasProdutos) {
		this.vendasProdutos = vendasProdutos;
	}
	
}
