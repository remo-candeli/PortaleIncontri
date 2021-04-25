package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.caratteristiche.CaratteristicaStatoSociale;
import org.corso.models.StatoSociale;

import java.util.HashSet;
import java.util.Set;

public class PreferenzaStatoSociale extends Preferenza {
    public static final int PESO_PREFERENZA = 4;
    private Set<StatoSociale> statoSocialeElenco;
    private Class caratteristicaAssociata;

    public PreferenzaStatoSociale(Set<StatoSociale> statoSocialeElenco) {
        super(PESO_PREFERENZA);
        caratteristicaAssociata = CaratteristicaStatoSociale.class;
        this.statoSocialeElenco = statoSocialeElenco;
        this.setDescrizione("Preferenza dello stato sociale");
    }

    public Set<StatoSociale> getStatoSocialeElenco() {
        return statoSocialeElenco;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaStatoSociale caratteristicaStatoSociale = (CaratteristicaStatoSociale) caratteristica;
            if (statoSocialeElenco.contains(caratteristicaStatoSociale.getStatoSociale())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long confronta(Preferenza preferenzaDaConfrontare) {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaStatoSociale preferenzaStatoSociale = (PreferenzaStatoSociale) preferenzaDaConfrontare;
        Set<StatoSociale> statoSocialeElencoCopy = new HashSet<>(statoSocialeElenco);
        statoSocialeElencoCopy.retainAll(preferenzaStatoSociale.getStatoSocialeElenco());
        return Math.round((Double.valueOf(statoSocialeElencoCopy.size()) / Double.valueOf(preferenzaStatoSociale.getStatoSocialeElenco().size())) * 100);
    }

    @Override
    public String toString() {
        return " stato sociale = " + statoSocialeElenco;
    }
}
