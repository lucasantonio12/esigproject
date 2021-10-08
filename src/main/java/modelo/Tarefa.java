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
	

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "tarefa_funcionarios",
			joinColumns = @JoinColumn(name = "tarefa_id"),
			inverseJoinColumns = @JoinColumn(name = "funcionarios_id"))
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	

	public Tarefa() {
	}

	public Tarefa(Integer id, String titulo, String descricao, String prioridade, List<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.funcionarios = funcionarios;
	}

	public Tarefa(String titulo, String descricao, String prioridade, List<Funcionario> funcionarios) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.funcionarios = funcionarios;
	}

	
}
