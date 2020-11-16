package assis.lucas.lojaroupas.produto.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ProdutoForm {
	
	@Size(max = 100)
	@NotNull(message = "A descrição não pode ser nula")
	private String descricao;
 
	@PositiveOrZero(message = "A quantidade deve ser positiva")
	@NotNull(message = "A quantidade não pode ser nula")
	private Long quantidade;
	
	@PositiveOrZero(message = "O valor não deve ser negativo")
	@NotNull(message = "O valor não deve ser nulo")
	private Double valor;
	
	@Size(max = 45, message = "O nome da marca deve ter no máximo 45 caracteres")
	@NotNull(message = "A marca não deve ser nula")
	private String marca;
	
	@NotNull
	private Long idTipoProduto;
	
	private Long idPromocao;

	public ProdutoForm(@Size(max = 100) @NotNull(message = "A descrição não pode ser nula") String descricao,
			@PositiveOrZero(message = "A quantidade deve ser positiva") @NotNull(message = "A quantidade não pode ser nula") Long quantidade,
			@PositiveOrZero(message = "O valor não deve ser negativo") @NotNull(message = "O valor não deve ser nulo") Double valor,
			@Size(max = 45, message = "O nome da marca deve ter no máximo 45 caracteres") @NotNull(message = "A marca não deve ser nula") String marca,
			@NotNull Long idTipoProduto, Long idPromocao) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;
		this.idTipoProduto = idTipoProduto;
		this.idPromocao = idPromocao;
	}

	public ProdutoForm() { }

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

	public Long getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(Long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	public Long getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(Long idPromocao) {
		this.idPromocao = idPromocao;
	}
	
}
