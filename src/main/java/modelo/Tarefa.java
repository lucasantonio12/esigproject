package modelo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Tarefa")
@NoArgsConstructor
@AllArgsConstructor
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

	
}
