package org.corso.reports;

import org.corso.models.Utente;
import org.corso.valutatori.MotoreRicerca;

public interface IReportIncontri {
    void stampa(Utente richiedente, MotoreRicerca estrattoreAnimaGemella);
}
