import Actions.*;
import Characters.Baron;
import Characters.Hertsog;
import Enums.Locations;
import Enums.Types;
import Exceptions.ActionNotFoundException;
import Items.*;
import Records.Bottle;
import java.util.ArrayList;
import java.util.List;
import static Enums.Locations.*;

public class Main {
    public static void main(String[] args) throws ActionNotFoundException {
        Barrels barrels = new Barrels("Бочки", Passage.name());
        Door door = new Door("Дверь", Exit.name());
        Door CellarDoor = new Door("Дверь в подвал", Locations.CellarDoor.name());
        Cart cart = new Cart("Вагонетка", CellarEntry.name());
        Bottles bottles = new Bottles("Бутылки", Storage.name());
        bottles.fillBottles();
        List<String> drunkBottles = new ArrayList<>();

        Hertsog Hertsog = new Hertsog("Герцог");
        Baron Baron = new Baron("Барон");

        Action touch = new TouchWall();
        Action drink = new Drink();

        Hertsog.NotWant("вино");
        Hertsog.Want("обследовать подвалы");
        Hertsog.Hear("в одной из стен замурованы сокровища - наследство старого графа Вишни");
        Hertsog.Explain("Мне пришлось сопровождать барона помимо моей воли. Он искал бутылку вина, чтобы утолить жажду");
        cart.setContent(Baron);
        cart.setDriver(Hertsog);
        cart.moveTo(CellarDoor);
        cart.setLocation(CellarEntry.name());


        Hertsog.setAction(touch);
        System.out.println(Hertsog.getName()+" начал ощупывать дверцу, ища секретный замок.");
        while (Hertsog.getStressLevel() < 5) {
            Hertsog.performAction(door);
        }
        System.out.println("Сколько он ни щупал дверь, она оставалась запертой");

        Baron.setAction(drink);

        try {
            for (int i = 0; i < 10; i++) {
                Bottle bottle = bottles.getBottles()[i];
                Baron.performAction(bottle);
                Types name = bottle.getName();
                drunkBottles.add(String.format("%.2f", (bottle.volume())) + " " + name);
            }
            System.out.println(Baron.getName() + " расправился с бутылками, стоящими у входа: " + drunkBottles);
        }
        catch (ActionNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Baron.moveTo(barrels);
        Baron.moveTo(Hertsog);
        System.out.println(Hertsog.getName()+" продолжил ощупывать дверцу, все больше раздражаясь.");
        while (Hertsog.getStressLevel() < 10) {
            Hertsog.performAction(door);
        }
        System.out.println("Дверь не открылась");
    }
}