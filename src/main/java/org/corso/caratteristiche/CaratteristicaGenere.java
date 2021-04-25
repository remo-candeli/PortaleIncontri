package org.corso.caratteristiche;

import org.corso.models.Genere;


public class CaratteristicaGenere extends Caratteristica {
    private Genere genere;

    public CaratteristicaGenere(Genere genere) {
        this.genere = genere;
        this.setDescrizione("Genere");
    }


    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return ""+ genere;
    }
}
