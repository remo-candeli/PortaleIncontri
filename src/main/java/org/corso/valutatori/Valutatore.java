package org.corso.valutatori;

import org.corso.models.Utente;

import java.util.Set;

public interface Valutatore {
    void setRichiedente(Utente richiedente);
    void esecuzione(Set<Utente> elencoIscritti);
}
