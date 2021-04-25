package org.corso;

import junit.framework.TestCase;
import org.corso.caratteristiche.Caratteristica;
import org.corso.eccezioni.UtenteNonTrovatoException;
import org.corso.eccezioni.UtenteNonValidoException;
import org.corso.models.Persona;
import org.corso.models.Utente;
import org.corso.preferenze.Preferenza;
import org.corso.reports.ReportIncontriStandard;
import org.corso.valutatori.EstrattoreAnimaGemella;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class PortaleIncontriTest extends TestCase {

    @InjectMocks
    private PortaleIncontri portaleIncontri;
    private Persona persona;
    private Utente utente;
    Map<String, Set<Caratteristica>> persone;
    Map<String, Set<Preferenza>> preferenze;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        portaleIncontri = new PortaleIncontri(new EstrattoreAnimaGemella(), new ReportIncontriStandard());
        persone = Utility.createCaratteristiche();
        preferenze = Utility.createPreferenze();
        persona = new Persona("Enrico", "Fermi", persone.get("PersonaTest1"));
        utente = new Utente(persona);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void utenteGeneratoAssociatoAllaPersona_iscrizioneUtente() {
        Utente utente = portaleIncontri.iscrizioneUtente(persona, preferenze.get("Preferenza01"));
        assertNotNull(utente);
        assertEquals(utente.getPersona(), persona);
    }

    @Test(expected = UtenteNonTrovatoException.class)
    public void utenteNonEsistente_rimozioneUtente() throws UtenteNonValidoException, UtenteNonTrovatoException {
        utente.setPreferenze(preferenze.get("Preferenza01"));
        portaleIncontri.rimozioneUtente(utente);
    }

    @Test(expected = UtenteNonValidoException.class)
    public void utenteNonDeveEssereNullo_rimozioneUtente() throws UtenteNonValidoException, UtenteNonTrovatoException {
        portaleIncontri.rimozioneUtente(null);
    }


    public void testCercaAnimaGemella() {
    }

    public void testStampaReport() {
    }
}