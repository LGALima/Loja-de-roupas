package assis.lucas.lojaroupas.carrinho.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class CarrinhoForm {

	@NotNull //TODO: Pergar pelo token depois
	private Long idUsuario;

	@NotNull
	private Long idProduto;

	@NotNull(message = "A quantidade não pode ser nula")
	@PositiveOrZero(message = "A quantidade deve ser positiva")
	private Long quantidade;

	public CarrinhoForm(@NotNull Long idUsuario, @NotNull Long idProduto,
			@NotNull(message = "A quantidade não pode ser nula") @PositiveOrZero(message = "A quantidade deve ser positiva") Long quantidade) {
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public CarrinhoForm() { }

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}
