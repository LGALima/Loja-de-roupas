package assis.lucas.lojaroupas.vendaProduto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

import assis.lucas.lojaroupas.carrinho.model.Carrinho;
import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.venda.model.Venda;

@Entity
@Table(name = "venda_produto")
public class VendaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda_produto")
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@NotNull
	@PositiveOrZero
	@Column(name = "quantidade")
	private Long quantidade;
	
	@Column(name = "desconto")
	private Double desconto;
	
	@Column(name = "total")
	private Double total;

	public VendaProduto(Long id, Venda venda, Produto produto, @NotNull Long quantidade, Double desconto,
			Double total) {
		this.id = id;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.total = total;
	}
	
	public VendaProduto(Carrinho carrinho) {
		this.produto = carrinho.getProduto();
		this.quantidade = carrinho.getQuantidade();
		this.desconto = carrinho.getProduto().getPromocao() != null ? carrinho.getProduto().getPromocao().getDesconto() : 0D;
		this.total = (double) Math.round((this.produto.getValor() * quantidade) * (1 - this.desconto/100) * 100) / 100;
	}

	public VendaProduto() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
