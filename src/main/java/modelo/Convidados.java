package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Convidados")
public class Convidados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    private String Agregados;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Presentes presentes;
}
