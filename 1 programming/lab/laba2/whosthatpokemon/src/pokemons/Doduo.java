package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Doduo extends Pokemon {
    public Doduo(String name, int level){
        super(name,level);
        setStats(35,85,45,35,35,75);
        setType(Type.NORMAL, Type.FLYING);
        addMove(new QuickAttack(Type.NORMAL,40,100,1,1));
        addMove(new SteelWing(Type.STEEL,70,90));
        addMove(new DoubleTeam(Type.NORMAL,0,100));
    }
}

