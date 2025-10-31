package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.Type;

public final class Dodrio extends Doduo {
    public Dodrio(String name, int level){
        super(name,level);
        setStats(60,110,70,60,60,110);
        addMove(new TriAttack(Type.NORMAL,80,100));
    }
}
