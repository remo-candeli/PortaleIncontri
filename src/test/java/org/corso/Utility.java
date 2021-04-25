package org.corso;

import org.corso.caratteristiche.*;
import org.corso.models.*;
import org.corso.preferenze.*;

import java.util.*;

public class Utility {

    public static Map<String, Set<Caratteristica>> createCaratteristiche() {
        Map<String, Set<Caratteristica>> result = new HashMap<>();
        Set<Caratteristica> caratteristiche = null;
        caratteristiche = new HashSet<>();

        caratteristiche.add(new CaratteristicaAltezza(178));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SEPARATO));
        caratteristiche.add(new CaratteristicaEta(46));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.AZZURRO));
        caratteristiche.add(new CaratteristicaGenere(Genere.FEMMINA));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.put("PersonaTest1", caratteristiche);

        caratteristiche = new HashSet<>();
        caratteristiche.add(new CaratteristicaAltezza(170));
        caratteristiche.add(new CaratteristicaStatoSociale(StatoSociale.SINGLE));
        caratteristiche.add(new CaratteristicaEta(50));
        caratteristiche.add(new CaratteristicaOcchi(ColoreOcchi.MARRONE));
        caratteristiche.add(new CaratteristicaGenere(Genere.MASCHIO));
        caratteristiche.add(new CaratteristicaRazza(Razza.CAUCASICA));
        result.put("PersonaTest2", caratteristiche);

        return result;
    }

    public static Map<String, Set<Preferenza>> createPreferenze() {
        Map<String, Set<Preferenza>> result = new HashMap<>();
        Set<Preferenza> preferenze = null;
        preferenze = new HashSet<>();

        preferenze.add(new PreferenzaAltezza(170, 175));
        preferenze.add(new PreferenzaOcchi(new HashSet<>(Arrays.asList(ColoreOcchi.AZZURRO, ColoreOcchi.VERDE))));
        preferenze.add(new PreferenzaGenere(Genere.MASCHIO));
        preferenze.add(new PreferenzaRazza(new HashSet<>(Arrays.asList(Razza.AFRICANA, Razza.ASIATICA))));
        preferenze.add(new PreferenzaEta(50, 55));
        preferenze.add(new PreferenzaStatoSociale(new HashSet<>(Arrays.asList(StatoSociale.SEPARATO, StatoSociale.SINGLE))));
        preferenze.add(new PreferenzaHobbies(new HashSet<>(Arrays.asList(Hobby.VIAGGI, Hobby.CINEMA, Hobby.ASTRONOMIA))));
        result.put("Preferenza01", preferenze);

        preferenze.add(new PreferenzaAltezza(170, 175));
        preferenze.add(new PreferenzaOcchi(new HashSet<>(Arrays.asList(ColoreOcchi.AZZURRO))));
        preferenze.add(new PreferenzaGenere(Genere.FEMMINA));
        preferenze.add(new PreferenzaRazza(new HashSet<>(Arrays.asList(Razza.CAUCASICA))));
        preferenze.add(new PreferenzaEta(45, 55));
        preferenze.add(new PreferenzaStatoSociale(new HashSet<>(Arrays.asList(StatoSociale.SINGLE))));
        preferenze.add(new PreferenzaHobbies(new HashSet<>(Arrays.asList(Hobby.ASTRONOMIA))));
        result.put("Preferenza02", preferenze);

        return result;
    }
}
