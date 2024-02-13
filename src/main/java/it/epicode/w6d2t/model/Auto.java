package it.epicode.w6d2t.model;

import lombok.Data;

@Data
public class Auto {
    private int id;
    private String nome;
    private String marca;
    private int cilindrata;
    private Alimentazione alimentazione;

    private Persona persona;
}
