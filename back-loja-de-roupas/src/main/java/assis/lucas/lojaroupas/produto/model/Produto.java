package assis.lucas.lojaroupas.produto.model;

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
import javax.validation.constraints.Size;

import assis.lucas.lojaroupas.promocao.model.Promocao;
import assis.lucas.lojaroupas.tipoProduto.model.TipoProduto;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Size(max = 100)
	@NotNull(message = "A descrição não pode ser nula")
	@Column(name = "descricao")
	private String descricao;

	@PositiveOrZero(message = "A quantidade deve ser positiva")
	@NotNull(message = "A quantidade não pode ser nula")
	@Column(name = "quantidade")
	private Long quantidade;

	@PositiveOrZero(message = "O valor não deve ser negativo")
	@NotNull(message = "O valor não deve ser nulo")
	@Column(name = "valor")
	private Double valor;

	@Size(max = 45, message = "O nome da marca deve ter no máximo 45 caracteres")
	@NotNull(message = "A marca não deve ser nula")
	@Column(name = "marca")
	private String marca;

	@ManyToOne
	@JoinColumn(name = "id_tipo_produto")
	private TipoProduto tipoProduto;

	@ManyToOne
	@JoinColumn(name = "id_promocao")
	private Promocao promocao;

	public Produto(Long id, @Size(max = 100) @NotNull(message = "A descrição não pode ser nula") String descricao,
			@PositiveOrZero(message = "A quantidade deve ser positiva") @NotNull(message = "A quantidade não pode ser nula") Long quantidade,
			@PositiveOrZero(message = "O valor não deve ser negativo") @NotNull(message = "O valor não deve ser nulo") Double valor,
			@Size(max = 45, message = "O nome da marca deve ter no máximo 45 caracteres") @NotNull(message = "A marca não deve ser nula") String marca,
			TipoProduto tipoProduto, Promocao promocao) {
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;
		this.tipoProduto = tipoProduto;
		this.promocao = promocao;
	}

	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

}
