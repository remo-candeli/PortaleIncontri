package org.corso.caratteristiche;

public class CaratteristicaAltezza extends Caratteristica{

    private int valore;

    public CaratteristicaAltezza(int valore) {
        this.valore = valore;
        this.setDescrizione("Altezza");
    }

    public int getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return ""+ valore;
    }
}
