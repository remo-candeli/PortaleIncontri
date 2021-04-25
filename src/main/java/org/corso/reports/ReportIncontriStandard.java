package org.corso.reports;

import org.corso.caratteristiche.Caratteristica;
import org.corso.models.Utente;
import org.corso.preferenze.Preferenza;
import org.corso.valutatori.MotoreRicerca;

import java.util.Map;

public class ReportIncontriStandard implements IReportIncontri {

    public void stampa(Utente richiedente, MotoreRicerca estrattoreAnimaGemella) {
        stampaAnimeGemelleRichiedente(richiedente, estrattoreAnimaGemella.getAffinitaCandidati(), estrattoreAnimaGemella.getCoefficientiMatchingCandidati());
    }

    public void stampaAnimeGemelleRichiedente(Utente richiedente, Map<Utente, Map<String, Long>> affinitaCandidati, Map<Utente, Map<Utente, Long>> coefficientiMatchingCandidati) {
        System.out.println("=========================");
        System.out.println("Richiedente "+ richiedente.getPersona().getCognome() + " " + richiedente.getPersona().getNome());
        System.out.println("=========================");
        System.out.println("Preferenze richiedente: ");
        for(Preferenza preferenza: richiedente.getPreferenze()) {
            System.out.println("  "+ preferenza.getDescrizione() + ": " + preferenza);
        }
        if(affinitaCandidati.isEmpty()) {
            System.out.println(" *** non sono stati trovati match per il richiedente ***");
        }
        for(Utente candidato: affinitaCandidati.keySet()) {
            stampaEstrazione(candidato, affinitaCandidati.get(candidato), coefficientiMatchingCandidati.get(richiedente));
            System.out.println();
            System.out.println();
        }
    }

    private void stampaEstrazione(Utente candidato, Map<String, Long> valoriAffinita, Map<Utente, Long> candidatiMatchingComplessivo) {
        System.out.println("=========================");
        System.out.println("      possibile anima gemella: " + candidato.getPersona().getCognome()+" "+candidato.getPersona().getNome() + " (coeff. " + candidatiMatchingComplessivo.get(candidato) + ")");
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

}
