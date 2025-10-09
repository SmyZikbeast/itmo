package pokemons;

import ru.ifmo.se.pokemon.*;
class Flamethrower1 extends DamageMove {
    Flamethrower(){

    }
}
public class Main {
    public static void main(String[] args) {
        DamageMove Flamethrower = new Flamethrower1();
        Pokemon Absol = new Pokemon("Abdrozik", 1);
        Absol.addMove(Flamethrower);
    }
}