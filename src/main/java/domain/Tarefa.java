package domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	@Column(length = 50, nullable = false)
	private String titulo;

	@Column(length = 50, nullable = true)
	private String Descricao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getNumero() {
		return numero;
	}

	public Tarefa() {

	}

	public Tarefa(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		Descricao = descricao;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Descricao, funcionario, numero, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(Descricao, other.Descricao) && Objects.equals(funcionario, other.funcionario)
				&& Objects.equals(numero, other.numero) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Tarefa [numero=" + numero + ", titulo=" + titulo + ", Descricao=" + Descricao + ", funcionario="
				+ funcionario + "]";
	}

}
