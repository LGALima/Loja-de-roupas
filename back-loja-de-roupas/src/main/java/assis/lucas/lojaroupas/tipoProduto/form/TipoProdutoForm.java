package assis.lucas.lojaroupas.tipoProduto.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TipoProdutoForm {

	@NotNull(message = "A descrição não pode ser nula")
	@Size(max = 45, message = "A descrição deve conter no máximo 45 caracteres")
	private String descricao;

	public TipoProdutoForm(
			@NotNull(message = "A descrição não pode ser nula") @Size(max = 45, message = "A descrição deve conter no máximo 45 caracteres") String descricao) {
		this.descricao = descricao;
	}

	public TipoProdutoForm() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
