package org.corso.preferenze;

import org.corso.caratteristiche.Caratteristica;
import org.corso.models.Hobby;

import java.util.HashSet;
import java.util.Set;

public class PreferenzaHobbies extends Preferenza {
    public static final int PESO_PREFERENZA = 13;
    private Set<Hobby> hobbies;

    public PreferenzaHobbies(Set<Hobby> hobbies) {
        super(PESO_PREFERENZA);
        this.hobbies = hobbies;
        this.setDescrizione("Hobbies preferiti");
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    /* Violato il principio di Liskov ....bravo!!!! */
    @Override
    public boolean match(Caratteristica caratteristica) {
        return false;
    }

    @Override
    public long confronta(Preferenza preferenzaDaConfrontare)  {
        if (!preferenzaDaConfrontare.getClass().equals(getClass()))
            return 0;
        PreferenzaHobbies preferenzaHobbies = (PreferenzaHobbies) preferenzaDaConfrontare;
        Set<Hobby> hobbiesCopy = new HashSet<>(hobbies);
        hobbiesCopy.retainAll(preferenzaHobbies.getHobbies());
        return Math.round((Double.valueOf(hobbiesCopy.size()) / Double.valueOf(preferenzaHobbies.getHobbies().size())) * 100);
    }

    @Override
    public String toString() {
        return " hobbies = " + hobbies;
    }
}
