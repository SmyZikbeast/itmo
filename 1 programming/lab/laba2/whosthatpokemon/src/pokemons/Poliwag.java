package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int level){
        super(name,level);
        setStats(40,50,40,40,40,90);
        setType(Type.WATER);
        addMove(new Rest(Type.PSYCHIC,0,0));
        addMove(new Confide(Type.NORMAL,0,100));
    }
}
