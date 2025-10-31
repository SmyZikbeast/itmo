package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public final class Absol extends Pokemon{
    public Absol(String name, int level){
        super(name, level);
        setStats(65,130,60,75,60,75);
        setType(Type.DARK);
        addMove(new Flamethrower(Type.FIRE,90,100));
        addMove(new Rest(Type.PSYCHIC,0,100));
        addMove(new SwordsDance(Type.NORMAL,0,100));
        addMove(new RockTomb(Type.ROCK,60,95));
    }
}