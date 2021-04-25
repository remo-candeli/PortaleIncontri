package org.corso.models;

public enum ColoreOcchi {
    AZZURRO(1), VERDE(2), MARRONE(3);
    int posizione;

    ColoreOcchi(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }

}
