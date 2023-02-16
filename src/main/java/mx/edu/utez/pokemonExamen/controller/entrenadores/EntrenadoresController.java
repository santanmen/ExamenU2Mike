package mx.edu.utez.pokemonExamen.controller.entrenadores;

import mx.edu.utez.pokemonExamen.controller.entrenadores.dto.EntrnadoresDto;
import mx.edu.utez.pokemonExamen.controller.pokemon.dto.PokemonDto;
import mx.edu.utez.pokemonExamen.models.entrenadores.Entrenadores;
import mx.edu.utez.pokemonExamen.models.pokemom.Pokemon;
import mx.edu.utez.pokemonExamen.services.entrenadores.EntrenadoresService;
import mx.edu.utez.pokemonExamen.services.pokemons.PokemonService;
import mx.edu.utez.pokemonExamen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-poke/ent")
@CrossOrigin(origins = {"*"})
public class EntrenadoresController {
    @Autowired
    private EntrenadoresService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenadores>>>getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>getOne(@PathVariable("id") Long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Entrenadores>>insert(
            @RequestBody EntrnadoresDto entrnadoresDto
    ){
        return new ResponseEntity<>(
                this.service.insert(entrnadoresDto.getEntrnadores()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>update(@PathVariable long id ,@RequestBody EntrnadoresDto entrnadoresDto){

        return new ResponseEntity<>(
                this.service.update(entrnadoresDto.getEntrnadores(),id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>delete(@PathVariable long id ,@RequestBody EntrnadoresDto entrnadoresDto){
        return new ResponseEntity<>(
                this.service.delete(entrnadoresDto.getEntrnadores(),id),
                HttpStatus.OK
        );
    }


}
