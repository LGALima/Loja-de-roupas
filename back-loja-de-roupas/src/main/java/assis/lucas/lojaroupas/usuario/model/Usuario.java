package assis.lucas.lojaroupas.usuario.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome não deve ser vazio")
	@Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "A data de nascimento não pode ser nula")
	@PastOrPresent(message = "A data de nascimento não pode ser de uma data futura")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull(message = "O email não pode ser nulo")
	@Email(message = "O email esta em formato inválido")
	@NotBlank(message = "O email não deve ser vazio")
	@Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "A senha não pode ser nula")
	@NotBlank(message = "A senha não deve ser vazio")
	@Size(max = 20, min = 8, message = "A senha deve ter de 8 a 20 caracteres")
	@Column(name = "senha")
	private String senha;

	@Column(name = "data_hora_registro")
	private LocalDateTime dataHoraRegistro;
	
	@NotNull(message = "O endereço não pode ser nulo")
	@NotBlank(message = "O endereço não deve ser vazio")
	@Size(max = 100, message = "O endereço deve ter no máximo 100 caracteres")
	@Column(name = "endereco")
	private String endereco;
	
	@Size(max = 20, message = "O contato deve ter no máximo 20 caracteres")
	@Column(name = "contato")
	private String contato;
	

	public Usuario(Long id, @NotNull @Size(max = 100) String nome, @NotNull @PastOrPresent LocalDate dataNascimento,
			@NotNull @Email @Size(max = 100) String email, @NotNull @Size(max = 20, min = 8) String senha,
			@NotNull @Size(max = 100) String endereco, @Size(max = 20) String contato) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
