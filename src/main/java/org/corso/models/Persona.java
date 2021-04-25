package org.corso.models;

import org.corso.caratteristiche.Caratteristica;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Persona {

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private Set<Caratteristica> caratteristiche;

    public Persona() {
    }

    public Persona(String nome, String cognome, Set<Caratteristica> caratteristiche) {
        this.nome = nome;
        this.cognome = cognome;
        this.caratteristiche = caratteristiche;
    }

    public Caratteristica getCaratteristicaByType(Class caratteristicaType) {
        for(Caratteristica c: caratteristiche) {
            if (c.getClass().equals(caratteristicaType))
                return c;
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Caratteristica> getCaratteristiche() {
        return caratteristiche;
    }

    public void setCaratteristiche(Set<Caratteristica> caratteristiche) {
        this.caratteristiche = caratteristiche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nome.equals(persona.nome) && cognome.equals(persona.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }
}
