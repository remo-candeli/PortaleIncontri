package org.corso.models;

public enum Razza {
    ASIATICA(1), CAUCASICA(2), AFRICANA(3);
    int posizione;

    Razza(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }

}
