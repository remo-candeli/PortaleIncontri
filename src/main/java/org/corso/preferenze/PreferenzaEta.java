package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.caratteristiche.CaratteristicaEta;

public class PreferenzaEta extends Preferenza {
    public static final int PESO_ETA_PREFERENZA = 10;
    private int daAnni;
    private int aAnni;
    private Class caratteristicaAssociata;

    public PreferenzaEta(int daAnni, int aAnni) {
        super(0);
        caratteristicaAssociata = CaratteristicaEta.class;
        this.daAnni = daAnni;
        this.aAnni = aAnni;
        this.setDescrizione("Preferenza Etá");
    }


    public int getDaAnni() {
        return daAnni;
    }

    public int getaAnni() {
        return aAnni;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaEta caratteristicaEta = (CaratteristicaEta) caratteristica;
            if (caratteristicaEta.getValore()>=daAnni && caratteristicaEta.getValore()<=aAnni) {
                setPesoPreferenza(PESO_ETA_PREFERENZA);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }



    @Override
    public long confronta(Preferenza preferenzaDaConfrontare)  {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaEta preferenzaEta = (PreferenzaEta) preferenzaDaConfrontare;
        if (this.getDaAnni()<=preferenzaEta.getDaAnni() && this.getaAnni()<=preferenzaEta.getaAnni())
            return 100;

        return 0;
    }

    @Override
    public String toString() {
        return " da Anni = " + daAnni + ", a Anni=" + aAnni;
    }
}
