package org.corso.valutatori;

import org.corso.models.Persona;
import org.corso.models.Utente;
import org.corso.caratteristiche.Caratteristica;
import org.corso.preferenze.Preferenza;

import java.util.*;

/**
 * Implementa i metodi di un Motore di Ricerca generico
 * Esegue prima un matching delle preferenze dell'utente con le caratteristiche di ogni iscritto.
 * Per ogni Matching valido calcola le affinitá tra le preferenze del richiedente ed ogni candidato.
 *
 */
public class EstrattoreAnimaGemella implements MotoreRicerca {

    public static final int COEFFICIENTE_MATCH_LIMITE_MINIMO = 20;
    private Utente richiedente;
    private Map<Utente, Map<String, Long>> affinitaCandidati;
    private Map<Utente, Integer> matchFalliti;
    private Map<Utente, Map<Utente, Long>> coefficientiMatchingCandidati;


    /**
     * Esegue la valutazione delle preferenze del richiedente con le caratteristiche di ogni iscritto.
     * Registra ogni matching riscontrato ed anche quelli non riscontrati.
     *
     * @param elencoIscritti
     */
    public void esecuzione(Set<Utente> elencoIscritti) {
        affinitaCandidati = new HashMap<>();
        matchFalliti = new HashMap<>();
        coefficientiMatchingCandidati = new HashMap<>();
        Map<Utente, Long> coefficienteCandidato = new HashMap<>();
        for(Utente iscritto: elencoIscritti) {
            int totaleCoefficienteMatches = calcolaMatchingComplessivo(richiedente.getPreferenze(), iscritto.getPersona());
            if (!iscritto.getPersona().equals(richiedente.getPersona())) {
                if (totaleCoefficienteMatches >= COEFFICIENTE_MATCH_LIMITE_MINIMO) {
                    affinitaCandidati.put(iscritto, calcoloAffinita(richiedente.getPreferenze(), iscritto.getPreferenze()));
                    coefficienteCandidato.put(iscritto, Integer.toUnsignedLong(totaleCoefficienteMatches));
                    coefficientiMatchingCandidati.put(richiedente, coefficienteCandidato);
                } else {
                    matchFalliti.put(iscritto, totaleCoefficienteMatches);
                }
            }
        }
    }


    /**
     * Esegue il calcolo delle affinitá tra le preferenze del richiedente e quelle dei candidati riscontrati.
     *
     * @param preferenzeDiA
     * @param preferenzeDiB
     * @return
     */
    public Map<String, Long> calcoloAffinita(Set<Preferenza> preferenzeDiA, Set<Preferenza> preferenzeDiB) {
        Map<String, Long> result = new HashMap<>();
        for(Preferenza preferenzaDiA: preferenzeDiA) {
            for(Preferenza preferenzaDiB: preferenzeDiB) {
                if (preferenzaDiA.getClass().equals(preferenzaDiB.getClass()))
                    result.put(preferenzaDiA.getDescrizione(), preferenzaDiA.confronta(preferenzaDiB));
            }
        }
        return result;
    }


    /**
     * Calcola il Matching complessivo sommando il peso di ogni matching sulle caratteristiche degli iscritti.
     *
     * @param preferenzeRichiedente
     * @param persona
     * @return
     */
    private int calcolaMatchingComplessivo(Set<Preferenza> preferenzeRichiedente, Persona persona) {
        int result = 0;
        Set<Caratteristica> caratteristichePersona = persona.getCaratteristiche();
        for(Preferenza preferenzaRichiedente: preferenzeRichiedente) {
            for(Caratteristica caratteristica: caratteristichePersona) {
                if (preferenzaRichiedente.match(caratteristica))
                    result += preferenzaRichiedente.getPesoPreferenza();
            }
        }
        return result;
    }

    public void setRichiedente(Utente richiedente) {
        this.richiedente = richiedente;
    }

    public Map<Utente, Integer> getMatchFalliti() {
        return matchFalliti;
    }

    public Map<Utente, Map<String, Long>> getAffinitaCandidati() {
        return affinitaCandidati;
    }

    public Utente getRichiedente() {
        return richiedente;
    }

    public Map<Utente, Map<Utente, Long>> getCoefficientiMatchingCandidati() {
        return coefficientiMatchingCandidati;
    }
}
