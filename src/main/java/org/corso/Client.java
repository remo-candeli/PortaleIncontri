package org.corso;

import org.corso.caratteristiche.*;
import org.corso.models.*;
import org.corso.preferenze.*;
import org.corso.reports.IReportIncontri;
import org.corso.reports.ReportIncontriConMatchFalliti;
import org.corso.reports.ReportIncontriStandard;
import org.corso.utils.RandomizeUtil;
import org.corso.valutatori.EstrattoreAnimaGemella;
import org.corso.valutatori.MotoreRicerca;

import java.util.*;

public class Client {

    public static void main(String[] args) {
        MotoreRicerca valutatore = new EstrattoreAnimaGemella();
        IReportIncontri reportIncontri = new ReportIncontriStandard();
        PortaleIncontri portale = new PortaleIncontri(valutatore, reportIncontri);

        Set<Persona> persone = generaPersone();
        List<Utente> utenti = registraPersone(persone, portale);

        portale.cercaAnimaGemella(utenti.get(0));
        portale.stampaReport(utenti.get(0));
    }

    private static Set<Persona> generaPersone() {
        Set<Persona> result = new HashSet<>();
        Set<Caratteristica> caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(180));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.DIVORZIATO));
        caratteristiche.add(new CaratteristicaEta(50));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.MARRONE));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.ASIATICA));
        result.add(new Persona("Remo", "Candeli", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(170));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SINGLE));
        caratteristiche.add(new CaratteristicaEta(50));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.MARRONE));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Albert", "Einstein", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(169));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.VEDOVO));
        caratteristiche.add(new CaratteristicaEta(43));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.VERDE));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Marie", "Curie", caratteristiche));


        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(168));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SEPARATO));
        caratteristiche.add(new CaratteristicaEta(55));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.VERDE));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Grace", "Hopper", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(182));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.DIVORZIATO));
        caratteristiche.add(new CaratteristicaEta(42));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.AFRICANA));
        result.add(new Persona("Karl", "Heisemberg", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(182));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SINGLE));
        caratteristiche.add(new CaratteristicaEta(42));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Ida", "Noddack", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(182));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SEPARATO));
        caratteristiche.add(new CaratteristicaEta(52));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Niels", "Bohr", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(168));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SINGLE));
        caratteristiche.add(new CaratteristicaEta(47));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Katherine", "Johnson", caratteristiche));

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(168));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SEPARATO));
        caratteristiche.add(new CaratteristicaEta(51));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.MARRONE));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Isaac", "Newton", caratteristiche));


        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(178));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SEPARATO));
        caratteristiche.add(new CaratteristicaEta(46));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.add(new Persona("Fabiola", "Gianotti", caratteristiche));

        return result;
    }


    private static Set<Preferenza> generaPreferenzeRandom(Persona persona) {
        Set<Preferenza> result = new HashSet<>();

        int fromAltezza = RandomizeUtil.randomizeAltezza(168, 183);
        int toAltezza = RandomizeUtil.randomizeAltezza(fromAltezza, 183);
        result.add(new PreferenzaAltezza(fromAltezza, toAltezza));

        Caratteristica caratteristicaGenere = persona.getCaratteristicaByType(CaratteristicaGenere.class);
        Genere genere = RandomizeUtil.randomizeGenere(((CaratteristicaGenere) caratteristicaGenere).getGenere());
        result.add(new PreferenzaGenere(genere));

        Set<ColoreOcchi> occhi = RandomizeUtil.randomizeColoreOcchi(RandomizeUtil.randomizeInt(1, ColoreOcchi.values().length));
        result.add(new PreferenzaOcchi(occhi));

        Set<Hobby> hobbies = RandomizeUtil.randomizeHobbies(RandomizeUtil.randomizeInt(1, Hobby.values().length));
        result.add(new PreferenzaHobbies(hobbies));

        Set<StatoSociale> statoSocialeElenco = RandomizeUtil.randomizeStatoSociale(RandomizeUtil.randomizeInt(1, StatoSociale.values().length));
        result.add(new PreferenzaStatoSociale(statoSocialeElenco));

        int fromEta = RandomizeUtil.randomizeInt(40, 55);
        int toEta = RandomizeUtil.randomizeInt(fromEta, 55);
        result.add(new PreferenzaEta(fromEta, toEta));

        Set<Razza> razze = RandomizeUtil.randomizeRazze(RandomizeUtil.randomizeInt(1, Razza.values().length));
        result.add(new PreferenzaRazza(razze));

        return result;
    }


    private static List<Utente> registraPersone(Set<Persona> persone, PortaleIncontri portale) {
        List<Utente> result = new ArrayList<>();
        for(Persona persona: persone) {
            result.add(portale.iscrizioneUtente(persona, generaPreferenzeRandom(persona)));
        }
        return result;
    }


}
