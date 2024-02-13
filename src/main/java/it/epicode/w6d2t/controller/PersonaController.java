package it.epicode.w6d2t.controller;

import it.epicode.w6d2t.model.Persona;
import it.epicode.w6d2t.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Persona getPersonaByIdPathVariable(@PathVariable int id){
        return personaService.cercaPersonaPerId(id);
    }


}
