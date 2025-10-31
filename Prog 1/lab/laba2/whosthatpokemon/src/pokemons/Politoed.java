package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public final class Politoed extends Poliwhirl {
    public Politoed(String name,int level){
        super(name,level);
        setStats(90,75,75,90,100,70);
        addMove(new IceBeam(Type.ICE,90,100));
    }
}
