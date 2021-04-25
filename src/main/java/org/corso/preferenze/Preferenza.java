package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;


public abstract class Preferenza implements ComparatorePreferenza {

    private String descrizione;
    private int pesoPreferenza;

    public Preferenza(int pesoPreferenza) {
        this.pesoPreferenza = pesoPreferenza;
    }

    public int getPesoPreferenza() {
        return pesoPreferenza;
    }

    public void setPesoPreferenza(int pesoPreferenza) {
        this.pesoPreferenza = pesoPreferenza;
    }

    public abstract boolean match(Caratteristica caratteristica);

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
