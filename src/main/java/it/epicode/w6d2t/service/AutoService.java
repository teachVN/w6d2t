package it.epicode.w6d2t.service;

import it.epicode.w6d2t.model.Auto;
import it.epicode.w6d2t.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AutoService {
    private List<Auto> autos = new ArrayList<>();

    @Autowired
    private PersonaService personaService;

    public List<Auto> cercaTutteLeAuto(){
        return autos;
    }

    public Auto cercaAutoPerId(int id) throws NoSuchElementException{
        Optional<Auto> a = autos.stream().filter(auto -> auto.getId()==id).findAny();

        if(a.isPresent()){
            return a.get();
        }
        else{
            throw new NoSuchElementException("Auto non presente");
        }
    }

    public void salvaAuto(Auto auto){
        autos.add(auto);
    }

    public Auto aggiornaAuto(int id, Auto auto) throws NoSuchElementException{
        Auto a = cercaAutoPerId(id);

        Persona p = personaService.cercaPersonaPerId(auto.getPersona().getId());
        a.setPersona(p);

        a.setNome(auto.getNome());
        a.setCilindrata(auto.getCilindrata());
        a.setMarca(auto.getMarca());
        a.setAlimentazione(auto.getAlimentazione());

        return a;

    }

    public void cancellaAuto(int id) throws NoSuchElementException{
        Auto auto = cercaAutoPerId(id);
        autos.remove(auto);
    }
}
