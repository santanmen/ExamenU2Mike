package mx.edu.utez.pokemonExamen.services.pokemons;

import mx.edu.utez.pokemonExamen.models.pokemom.Pokemon;
import mx.edu.utez.pokemonExamen.models.pokemom.PokemonRepository;
import mx.edu.utez.pokemonExamen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PokemonService {
   @Autowired
    private PokemonRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Pokemon>>getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Pokemon>getOne(Long id){
        if (this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Pokemon no encontrado"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        Optional<Pokemon> exists=this.repository.findByName(pokemon.getName());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "EL pokemon ya se encuentra registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon registrado"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Pokemon pokemon, long id){
        if (!this.repository.existsById(id))
            return new Response<>(
                    null,
                    true,
                    400,
                    "Pokemon no encontrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon actualizado correctamente"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete(Pokemon pokemon, long id){
        if (!this.repository.existsById(id))
            return new Response<>(
                    null,
                    true,
                    400,
                    "Pokemon no encontrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon eliminado correctamente"
        );

    }
}
