package org.corso.caratteristiche;

import org.corso.models.ColoreOcchi;

public class CaratteristicaOcchi extends Caratteristica {
    private ColoreOcchi colore;

    public CaratteristicaOcchi(ColoreOcchi colore) {
        this.colore = colore;
        this.setDescrizione("Colore Occhi");
    }

    public ColoreOcchi getColore() {
        return colore;
    }

    @Override
    public String toString() {
        return ""+ colore;
    }
}
