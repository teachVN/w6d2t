package it.epicode.w6d2t.controller;

import it.epicode.w6d2t.model.Persona;
import it.epicode.w6d2t.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
//@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/persone")
    public List<Persona> getAll(){
        return personaService.cercaTutteLePersone();
    }
    @GetMapping("/persone/id")
    public Persona getPersonaByIdQueryParams(@RequestParam int id){
        return personaService.cercaPersonaPerId(id);
    }
    @GetMapping("/persone/{id}")
    public ResponseEntity<Persona> getPersonaByIdPathVariable(@PathVariable int id){
        try {
            Persona p = personaService.cercaPersonaPerId(id);
            return new ResponseEntity<Persona>(p, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/persone")
    public void savePersona(@RequestBody Persona persona){
        personaService.salvaPersona(persona);
    }
    @PutMapping("/persone/{id}")
    public Persona updatePersona(@PathVariable int id, @RequestBody Persona persona){
        return personaService.aggiornaPersona(id, persona);
    }
    @DeleteMapping("/persone/{id}")
    public void deletePersona(@PathVariable int id){
        personaService.cancellaPersona(id);
    }


}
