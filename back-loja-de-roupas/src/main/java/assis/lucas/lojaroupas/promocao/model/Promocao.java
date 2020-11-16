package assis.lucas.lojaroupas.promocao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "promocao")
public class Promocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promocao")
	private Long id;
	
	@Size(max = 100, message = "A descrição deve conter no máximo 100 caracteres")
	@Column(name = "descricao")
	private String descricao;
	
	@NotNull(message = "O desconto nao pode ser nulo")
	@DecimalMax("100.0")
	@DecimalMin("0.0")
	@Column(name = "desconto")
	private Double desconto;

	public Promocao(Long id, @Size(max = 100) String descricao,
			@NotNull @DecimalMax("100.0") @DecimalMin("0.0") Double desconto) {
		this.id = id;
		this.descricao = descricao;
		this.desconto = desconto;
	}

	public Promocao() {
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

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	
}
