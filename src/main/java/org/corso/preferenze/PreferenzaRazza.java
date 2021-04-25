package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.caratteristiche.CaratteristicaRazza;
import org.corso.models.Razza;

import java.util.HashSet;
import java.util.Set;

public class PreferenzaRazza extends Preferenza {
    public static final int PESO_PREFERENZA = 2;
    private Set<Razza> razzeElenco;
    private Class caratteristicaAssociata;

    public PreferenzaRazza(Set<Razza> elenco) {
        super(0);
        caratteristicaAssociata = CaratteristicaRazza.class;
        this.razzeElenco = elenco;
        this.setDescrizione("Preferenza Razza");
    }

    public Set<Razza> getElenco() {
        return razzeElenco;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaRazza caratteristicaRazza = (CaratteristicaRazza) caratteristica;
            Set<Razza> razzeCopy = new HashSet<>(razzeElenco);
            if (razzeCopy.contains(caratteristicaRazza.getRazza())) {
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
        PreferenzaRazza preferenzaColoreRazza = (PreferenzaRazza) preferenzaDaConfrontare;
        Set<Razza> razzeCopy = new HashSet<>(razzeElenco);
        razzeCopy.retainAll(preferenzaColoreRazza.razzeElenco);
        return Math.round((Double.valueOf(razzeCopy.size()) / Double.valueOf(preferenzaColoreRazza.razzeElenco.size())) * 100);
    }

    @Override
    public String toString() {
        return " razze  = " + razzeElenco;
    }
}
