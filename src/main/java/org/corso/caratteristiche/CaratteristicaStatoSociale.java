package org.corso.caratteristiche;

import org.corso.models.StatoSociale;

public class CaratteristicaStatoSociale extends Caratteristica{
    private StatoSociale statoSociale;

    public CaratteristicaStatoSociale(StatoSociale statoSociale) {
        this.statoSociale = statoSociale;
        this.setDescrizione("Stato sociale");
    }

    public StatoSociale getStatoSociale() {
        return statoSociale;
    }

    @Override
    public String toString() {
        return ""+ statoSociale;
    }
}
