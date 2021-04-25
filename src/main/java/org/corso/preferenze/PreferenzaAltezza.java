package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.caratteristiche.CaratteristicaAltezza;

public class PreferenzaAltezza extends Preferenza{
    public static final int PESO_ALTEZZA_PREFERENZA = 5;
    private int daCentimetri;
    private int aCentimetri;
    private Class caratteristicaAssociata;

    public PreferenzaAltezza(int daCentimetri, int aCentimetri) {
        super(0);
        caratteristicaAssociata = CaratteristicaAltezza.class;
        this.daCentimetri = daCentimetri;
        this.aCentimetri = aCentimetri;
        this.setDescrizione("Preferenza Altezza");
    }

    public int getDaCentimetri() {
        return daCentimetri;
    }

    public int getaCentimetri() {
        return aCentimetri;
    }

    @Override
    public boolean match(Caratteristica caratteristica) {
        if (caratteristica.getClass().equals(caratteristicaAssociata)) {
            CaratteristicaAltezza caratteristicaAltezza = (CaratteristicaAltezza) caratteristica;
            if (caratteristicaAltezza.getValore()<=daCentimetri && caratteristicaAltezza.getValore()>=aCentimetri) {
                setPesoPreferenza(PESO_ALTEZZA_PREFERENZA);
                return true;
            }
        }
        return false;
    }

    @Override
    public long confronta(Preferenza preferenzaDaConfrontare) {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaAltezza preferenzaAltezza = (PreferenzaAltezza) preferenzaDaConfrontare;
        if (preferenzaAltezza.getDaCentimetri()>=this.getDaCentimetri() && preferenzaAltezza.getDaCentimetri()<=this.getaCentimetri())
            return 100;

        return 0;
    }

    @Override
    public String toString() {
        return " da Centimetri = " + daCentimetri + ", a Centimetri=" + aCentimetri;
    }
}
