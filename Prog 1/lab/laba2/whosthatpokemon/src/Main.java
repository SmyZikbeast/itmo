import pokemons.*;
import ru.ifmo.se.pokemon.*;

public final class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Poliwhirl("", 1);
        Pokemon p2 = new Dodrio("", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}