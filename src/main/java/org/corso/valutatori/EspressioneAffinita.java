package org.corso.valutatori;

import org.corso.models.Utente;
import org.corso.preferenze.Preferenza;

import java.util.Map;
import java.util.Set;

public interface EspressioneAffinita {
    Map<String, Long> calcoloAffinita(Set<Preferenza> preferenzeDiA, Set<Preferenza> preferenzeDiB);
}
