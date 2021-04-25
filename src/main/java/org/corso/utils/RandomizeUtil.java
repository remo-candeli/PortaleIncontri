package org.corso.utils;

import org.corso.models.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizeUtil {

    public static int randomizeInt(int from, int to) {
        Random ran = new Random();
        int range = to - from + 1;
        return ran.nextInt(range) + from;
    }

    public static int randomizeAltezza(int from, int to) {
        Random ran = new Random();
        int range = to - from + 1;
        return ran.nextInt(range) + from;
    }


    public static Set<Hobby> randomizeHobbies(int occurrences) {
        Set<Hobby> hobbies = new HashSet<>();
        for(int i=0; i<occurrences; i++) {
            Random ran = new Random();
            int range = Hobby.values().length - 1 + 1;
            int value = ran.nextInt(range);
            hobbies.add(Hobby.values()[value]);
        }
        return hobbies;
    }


    public static Set<ColoreOcchi> randomizeColoreOcchi(int occurrences) {
        Set<ColoreOcchi> colore = new HashSet<>();
        for(int i=0; i<occurrences; i++) {
            Random ran = new Random();
            int range = ColoreOcchi.values().length;
            int value = ran.nextInt(range);
            colore.add(ColoreOcchi.values()[value]);
        }
        return colore;
    }

    public static Set<Razza> randomizeRazze(int occurrences) {
        Set<Razza> colore = new HashSet<>();
        for(int i=0; i<occurrences; i++) {
            Random ran = new Random();
            int range = Razza.values().length;
            int value = ran.nextInt(range);
            colore.add(Razza.values()[value]);
        }
        return colore;
    }

    public static Set<StatoSociale> randomizeStatoSociale(int occurrences) {
        Set<StatoSociale> statoSociale = new HashSet<>();
        for(int i=0; i<occurrences; i++) {
            Random ran = new Random();
            int range = StatoSociale.values().length;
            int value = ran.nextInt(range);
            statoSociale.add(StatoSociale.values()[value]);
        }
        return statoSociale;
    }



    public static Genere randomizeGenere(Genere genere) {
        if (genere!=null)
            return genere == Genere.MASCHIO ? Genere.FEMMINA : Genere.MASCHIO;
        Random ran = new Random();
        int value = ColoreOcchi.values().length - 1 + 1;
        return Genere.values()[value];
    }
}
