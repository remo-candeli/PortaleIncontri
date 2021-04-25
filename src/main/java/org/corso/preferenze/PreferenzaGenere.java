package org.corso.preferenze;

import org.corso.caratteristiche.*;
import org.corso.models.Genere;

public class PreferenzaGenere extends Preferenza {
    public static final int PESO_PREFERENZA = 10;
    private Genere genere;
    private Class caratteristicaAssociata;

    public PreferenzaGenere(Genere genere) {
        super(0);
        caratteristicaAssociata = CaratteristicaGenere.class;
        this.genere = genere;
        this.setDescrizione("Preferenza di Genere");
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaGenere caratteristicaGenere = (CaratteristicaGenere) caratteristica;
            if (genere==Genere.ALL || genere==caratteristicaGenere.getGenere()) {
                setPesoPreferenza(PESO_PREFERENZA);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public long confronta(Preferenza preferenzaDaConfrontare) {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaGenere preferenzaGenere = (PreferenzaGenere) preferenzaDaConfrontare;
        if (this.getGenere().equals(Genere.ALL) || this.getGenere().equals(preferenzaGenere))
            return 100;
        return 0;
    }

    @Override
    public String toString() {
        return " genere = " + genere.name();
    }
}
