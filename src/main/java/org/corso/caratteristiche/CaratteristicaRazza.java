package org.corso.caratteristiche;


import org.corso.models.Razza;

public class CaratteristicaRazza extends Caratteristica {
    private Razza razza;

    public CaratteristicaRazza(Razza razza) {
        this.razza = razza;
        this.setDescrizione("Razza");
    }

    public Razza getRazza() {
        return razza;
    }

    @Override
    public String toString() {
        return ""+ razza;
    }
}
