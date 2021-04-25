package org.corso.models;

public enum Genere {
    MASCHIO(1), FEMMINA(2), ALL(3);
    int posizione;

    Genere(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }
}
