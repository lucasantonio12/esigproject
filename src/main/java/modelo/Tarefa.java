package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Tarefa")
@NoArgsConstructor
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titulo", length = 50, nullable = false)
	private String titulo;

	@Column(name = "descricao", length = 100, nullable = true)
	private String descricao;
	
	@Column(name = "prioridade", length = 50, nullable = true)
	private String prioridade;
	
	@ManyToOne()
	@JoinColumn(nullable = false)
	private Funcionario funcionarios;
	
	@Column(name = "concluida", nullable = false)
	private Boolean concluida = false;

	public Tarefa(Integer id, String titulo, String descricao, String prioridade, Funcionario funcionarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.funcionarios = funcionarios;
	}


	public Tarefa(String titulo, String descricao, String prioridade, Funcionario funcionarios) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.funcionarios = funcionarios;
	}

	

	
}
