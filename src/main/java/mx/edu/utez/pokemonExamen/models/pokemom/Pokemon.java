package mx.edu.utez.pokemonExamen.models.pokemom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemonExamen.models.entrenadores.Entrenadores;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true,length = 150)
    private String name;
    @Column(nullable = false,unique = true,length = 150)
    private String type;
    @Column(nullable = false)
    private long poder;
    @Column(nullable = false)
    private long salud;
    @Column(nullable = false)
    private long ataque;
    @Column(nullable = false)
    private long defensa;

    @ManyToOne
    @JoinColumn(name = "entrnador_id",nullable = false)
    private Entrenadores entrenadores;
}
