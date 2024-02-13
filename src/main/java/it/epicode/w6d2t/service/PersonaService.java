package it.epicode.w6d2t.service;

import it.epicode.w6d2t.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonaService {

    private List<Persona> persone = new ArrayList<>();

    public List<Persona> cercaTutteLePersone(){
        return persone;
    }

    public Persona cercaPersonaPerId(int id) throws NoSuchElementException{
        Optional<Persona> p = persone.stream().filter(persona -> persona.getId()==id).findAny();

        if(p.isPresent()){
            return p.get();
        }
        else{
            throw new NoSuchElementException("Persona non trovata");
        }
    }

    public void salvaPersona(Persona persona){
        persone.add(persona);
    }

    public Persona aggiornaPersona(int id, Persona persona) throws NoSuchElementException{
        Persona p = cercaPersonaPerId(id);

        p.setNome(persona.getNome());
        p.setCognome(persona.getCognome());
        p.setIndirizzo(persona.getIndirizzo());
        p.setDataNascita(persona.getDataNascita());

        return p;
    }

    public void cancellaPersona(int id) throws NoSuchElementException{
        Persona p = cercaPersonaPerId(id);

        persone.remove(p);
    }
}
