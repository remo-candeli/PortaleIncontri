package org.corso.valutatori;

import org.corso.models.Utente;

import java.util.Map;

public interface MotoreRicerca extends EspressioneAffinita, Valutatore{
    Map<Utente, Integer> getMatchFalliti();
    Map<Utente, Map<String, Long>> getAffinitaCandidati();
    Map<Utente, Map<Utente, Long>> getCoefficientiMatchingCandidati();
}
