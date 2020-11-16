package assis.lucas.lojaroupas.carrinho.model;

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

import assis.lucas.lojaroupas.produto.model.Produto;
import assis.lucas.lojaroupas.usuario.model.Usuario;

@Entity
@Table(name = "carrinho")
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrinho")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@NotNull(message = "A quantidade não pode ser nula")
	@PositiveOrZero(message = "A quantidade deve ser positiva")
	@Column(name = "quantidade")
	private Long quantidade;

	public Carrinho(Long id, Usuario usuario, Produto produto, @NotNull @PositiveOrZero Long quantidade) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Carrinho() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
