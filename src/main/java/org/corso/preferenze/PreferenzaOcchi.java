package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.caratteristiche.CaratteristicaOcchi;
import org.corso.models.ColoreOcchi;

import java.util.HashSet;
import java.util.Set;

public class PreferenzaOcchi extends Preferenza {
    public static final int PESO_PREFERENZA = 3;
    private Set<ColoreOcchi> coloreOcchi;
    private Class caratteristicaAssociata;

    public PreferenzaOcchi(Set<ColoreOcchi> elenco) {
        super(0);
        caratteristicaAssociata = CaratteristicaOcchi.class;
        this.coloreOcchi = elenco;
        this.setDescrizione("Preferenza colore degli occhi");
    }

    public Set<ColoreOcchi> getElenco() {
        return coloreOcchi;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaOcchi caratteristicaOcchi = (CaratteristicaOcchi) caratteristica;
            if (coloreOcchi.contains(caratteristicaOcchi.getColore())) {
                setPesoPreferenza(PESO_PREFERENZA);
                return true;
            }
        }
        return false;
    }

    @Override
    public long confronta(Preferenza preferenzaDaConfrontare)  {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaOcchi preferenzaColoreOcchi = (PreferenzaOcchi) preferenzaDaConfrontare;
        Set<ColoreOcchi> coloreOcchiCopy = new HashSet<>(coloreOcchi);
        coloreOcchiCopy.retainAll(preferenzaColoreOcchi.coloreOcchi);
        return Math.round((Double.valueOf(coloreOcchiCopy.size()) / Double.valueOf(preferenzaColoreOcchi.coloreOcchi.size())) * 100);
    }

    @Override
    public String toString() {
        return " colore occhi  = " + coloreOcchi;
    }
}
