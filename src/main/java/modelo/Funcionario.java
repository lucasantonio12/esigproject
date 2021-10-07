package modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "especializacao", length = 50)
	private String especializacao;

	@Column(name = "estado_civil", length = 50, nullable = false)
	private String estadoCivil;

	@Column(name = "cargo", length = 50, nullable = false)
	private String cargo;


	public Funcionario(String nome, String especializacao, String estadoCivil, String cargo) {
		this.nome = nome;
		this.especializacao = especializacao;
		this.estadoCivil = estadoCivil;
		this.cargo = cargo;
	}
}
