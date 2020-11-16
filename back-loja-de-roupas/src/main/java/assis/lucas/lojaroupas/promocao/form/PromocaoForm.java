package assis.lucas.lojaroupas.promocao.form;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PromocaoForm {

	@Size(max = 100, message = "A descrição deve conter no máximo 100 caracteres")
	private String descricao;
	
	@NotNull(message = "O desconto nao pode ser nulo")
	@DecimalMax("100.0")
	@DecimalMin("0.0")
	private Double desconto;

	public PromocaoForm(@Size(max = 100, message = "A descrição deve conter no máximo 100 caracteres") String descricao,
			@NotNull(message = "O desconto nao pode ser nulo") @DecimalMax("100.0") @DecimalMin("0.0") Double desconto) {
		this.descricao = descricao;
		this.desconto = desconto;
	}

	public PromocaoForm() { }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	
}
