package mx.edu.utez.pokemonExamen.controller.pokemon;

import mx.edu.utez.pokemonExamen.controller.pokemon.dto.PokemonDto;
import mx.edu.utez.pokemonExamen.models.pokemom.Pokemon;
import mx.edu.utez.pokemonExamen.services.pokemons.PokemonService;
import mx.edu.utez.pokemonExamen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-poke/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {

    @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>getOne(@PathVariable("id") Long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>>insert(
            @RequestBody PokemonDto pokemonDto
    ){
        return new ResponseEntity<>(
                this.service.insert(pokemonDto.getPokemon()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>update(@PathVariable long id ,@RequestBody PokemonDto pokemonDto){

        return new ResponseEntity<>(
                this.service.update(pokemonDto.getPokemon(),id),
                HttpStatus.OK
        );
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>delete(@PathVariable long id ,@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(
                this.service.delete(pokemonDto.getPokemon(),id),
                HttpStatus.OK
        );
    }
}
