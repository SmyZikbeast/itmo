import ru.ifmo.se.pokemon.*;

class Absol extends Pokemon{
    Absol(String name, int level){
        super(name, level);
        setStats(65,130,60,75,60,75);
        setType(Type.DARK);
        addMove(new Flamethrower(Type.FIRE,90,100));
    }
}
