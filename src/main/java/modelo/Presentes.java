package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Presentes")
@NoArgsConstructor
@AllArgsConstructor
public class Presentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    private Integer quantidade;

}
