import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Absol("Abdrozik", 1);
        Pokemon p2 = new Pokemon();
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}