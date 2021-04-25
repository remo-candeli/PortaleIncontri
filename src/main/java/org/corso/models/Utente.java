package org.corso.models;

import org.corso.preferenze.Preferenza;

import java.util.Set;

public class Utente {

    private Persona persona;
    private Set<Preferenza> preferenze;

    public Utente(Persona persona) {
        this.persona = persona;
    }

    public Set<Preferenza> getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(Set<Preferenza> preferenze) {
        this.preferenze = preferenze;
    }

    public Persona getPersona() {
        return persona;
    }
}
