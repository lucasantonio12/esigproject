package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(length = 50, nullable = false, unique = true)
	private String nome;

	@Column(length = 50)
	private String especializacao;

	@Column(length = 50, nullable = false)
	private String estadoCivil;

	@Column(length = 50, nullable = false)
	private String cargo;

	public Funcionario(Integer codigo, String nome, String especializacao, String estadoCivil, String cargo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.especializacao = especializacao;
		this.estadoCivil = estadoCivil;
		this.cargo = cargo;
	}

	public Funcionario() {

	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, codigo, especializacao, estadoCivil, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(especializacao, other.especializacao)
				&& Objects.equals(estadoCivil, other.estadoCivil) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", especializacao=" + especializacao
				+ ", estadoCivil=" + estadoCivil + ", cargo=" + cargo + "]";
	}

}
