package org.corso.reports;

import org.corso.models.Utente;
import org.corso.valutatori.EstrattoreAnimaGemella;
import org.corso.valutatori.MotoreRicerca;
import org.corso.valutatori.Valutatore;

import java.util.Map;

public interface IReportIncontri {
    void stampa(Utente richiedente, MotoreRicerca estrattoreAnimaGemella);
}
