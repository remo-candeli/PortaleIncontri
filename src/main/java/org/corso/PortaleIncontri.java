package org.corso;

import org.corso.eccezioni.UtenteNonTrovatoException;
import org.corso.eccezioni.UtenteNonValidoException;
import org.corso.models.Persona;
import org.corso.models.Utente;
import org.corso.preferenze.Preferenza;
import org.corso.reports.IReportIncontri;
import org.corso.valutatori.EstrattoreAnimaGemella;
import org.corso.valutatori.MotoreRicerca;
import org.corso.valutatori.Valutatore;

import java.util.HashSet;
import java.util.Set;

/**
 * PortaleIncontri si occupa di iscrivere o rimuovere gli utenti dal portale.
 * Esegue la ricerca dell'anima gemella per singolo richiedente. (Attivitá delegata)
 * Consente la generazione di un report dei risultati. (Attivitá delegata)
 */
public class PortaleIncontri {

    private MotoreRicerca estrattoreAnimaGemella;
    private IReportIncontri reportIncontri;
    private Set<Utente> utenti;

    /**
     * Il costruttore richiede esplicitamente di acquisire le implementazioni del motore di ricerca e del report
     *
     * @param estrattoreAnimaGemella
     * @param reportIncontri
     */
    public PortaleIncontri(MotoreRicerca estrattoreAnimaGemella, IReportIncontri reportIncontri) {
        utenti = new HashSet<>();
        this.estrattoreAnimaGemella = estrattoreAnimaGemella;
        this.reportIncontri = reportIncontri;
    }

    /**
     * Iscrive una persona al portale richiedendo anche le sue preferenze
     *
     * @param persona
     * @param preferenze
     * @return
     */
    public Utente iscrizioneUtente(Persona persona, Set<Preferenza> preferenze) {
        Utente nuovoUtente = new Utente(persona);
        nuovoUtente.setPreferenze(preferenze);
        utenti.add(nuovoUtente);
        return nuovoUtente;
    }


    /**
     * Rimuove l'utente dal portale
     *
     * @param utente
     * @throws UtenteNonValidoException
     * @throws UtenteNonTrovatoException
     */
    public void rimozioneUtente(Utente utente) throws UtenteNonValidoException, UtenteNonTrovatoException{
        if (utente==null)
            throw new UtenteNonValidoException();
        if (!utenti.remove(utente))
            throw new UtenteNonTrovatoException();
    }


    /**
     * Ottiene il riferimento ad un utente registrato tramite la Persona
     *
     * @param persona
     * @return
     */
    public Utente getUtenteByPersona(Persona persona) {
        for(Utente utente: utenti) {
            if(utente.getPersona().equals(persona))
                return utente;
        }
        return null;
    }


    /**
     * Esegue la ricerca dell'anima gemella in base ad un richiedente (utente registrato)
     *
     * @param richiedente
     */
    public void cercaAnimaGemella(Utente richiedente) {
         estrattoreAnimaGemella.setRichiedente(richiedente);
         estrattoreAnimaGemella.esecuzione(utenti);
    }


    /**
     * Stampa il report coni risultati della ricerca per un singolo utente.
     *
     * @param richiedente
     */
    public void stampaReport(Utente richiedente) {
        reportIncontri.stampa(richiedente, estrattoreAnimaGemella);
    }

}
