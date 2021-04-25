package org.corso.caratteristiche;

public class CaratteristicaEta extends Caratteristica{

    private int valore;

    public CaratteristicaEta(int valore) {
        this.valore = valore;
        this.setDescrizione("Eta");
    }

    public int getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return ""+ valore;
    }

}
