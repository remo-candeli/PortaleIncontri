package org.corso.reports;

import org.corso.models.Utente;
import org.corso.caratteristiche.Caratteristica;
import org.corso.preferenze.Preferenza;
import org.corso.valutatori.EstrattoreAnimaGemella;
import org.corso.valutatori.MotoreRicerca;
import org.corso.valutatori.Valutatore;

import java.util.Map;

public class ReportIncontriConMatchFalliti implements IReportIncontri {

    public void stampa(Utente richiedente, MotoreRicerca estrattoreAnimaGemella) {
        stampaAnimeGemelleRichiedente(richiedente, estrattoreAnimaGemella.getAffinitaCandidati());
        for(Utente candidato: estrattoreAnimaGemella.getMatchFalliti().keySet()) {
            stampaMatchFalliti(candidato, estrattoreAnimaGemella.getMatchFalliti().get(candidato));
        }

    }

    public void stampaAnimeGemelleRichiedente(Utente richiedente, Map<Utente, Map<String, Long>> affinitaCandidati) {
        System.out.println("=========================");
        System.out.println("Richiedente "+ richiedente.getPersona().getNome()  + " " + richiedente.getPersona().getCognome());
        System.out.println("=========================");
        System.out.println("Preferenze richiedente: ");
        for(Preferenza preferenza: richiedente.getPreferenze()) {
            System.out.println("  "+ preferenza.getDescrizione() + ": " + preferenza);
        }
        if(affinitaCandidati.isEmpty()) {
            System.out.println(" *** non sono stati trovati match per il richiedente ***");
        }
        for(Utente candidato: affinitaCandidati.keySet()) {
            stampaEstrazione(candidato, affinitaCandidati.get(candidato));
            System.out.println();
            System.out.println();
        }
    }

    private void stampaEstrazione(Utente candidato, Map<String, Long> valoriAffinita) {
        System.out.println("=========================");
        System.out.println("      possibile anima gemella: " + candidato.getPersona().getNome()+" "+candidato.getPersona().getCognome());
        System.out.println("=========================");
        System.out.println("      caratteristiche anima gemella: ");
        for(Caratteristica caratteristica: candidato.getPersona().getCaratteristiche()) {
            System.out.println("      "+ caratteristica.getDescrizione() + ": " + caratteristica);
        }
        System.out.println("=========================");
        System.out.println("      preferenze anima gemella: ");
        for(Preferenza preferenza: candidato.getPreferenze()) {
            System.out.println("      "+ preferenza.getDescrizione() + ": " + preferenza);
        }
        System.out.println("=========================");
        for(String nomeAffinita: valoriAffinita.keySet()) {
            System.out.println("           affinita " + nomeAffinita + ": " + valoriAffinita.get(nomeAffinita) + "%");
        }
    }

    private void stampaMatchFalliti(Utente candidato, int totaleCoefficienteMatches) {
        System.err.println("========================= COEFFICIENTE: " + totaleCoefficienteMatches);
        System.err.println("      caratteristiche MANCATA anima gemella: " + candidato.getPersona().getCognome()+" "+candidato.getPersona().getNome());
        System.err.println("=========================");
        for(Caratteristica caratteristica: candidato.getPersona().getCaratteristiche()) {
            System.err.println("      "+ caratteristica.getDescrizione() + ": " + caratteristica);
        }
    }
}
