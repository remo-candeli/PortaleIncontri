package org.corso.models;

public enum StatoSociale {
    SINGLE(1), DIVORZIATO(2), SEPARATO(3), VEDOVO(4);
    int posizione;

    StatoSociale(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }
}
