import Actions.*;
import Characters.Baron;
import Characters.Hertsog;
import Enums.Colors;
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
        Door door = new Door("Дверь", Exit.name(), Boolean.FALSE);
        Door CellarDoor = new Door("Дверь в подвал", Locations.CellarDoor.name());
        Cart cart = new Cart("Вагонетка", CellarEntry.name());
        Bottles StorageBottles = new Bottles("Бутылки", Storage.name());
        Bottles PassageBottles = new Bottles("Бутылки", CellarEntry.name());
        StorageBottles.fillBottles();
        PassageBottles.fillBottles();
        List<String> PassageDrunkBottles = new ArrayList<>();
        List<String> StorageDrunkBottles = new ArrayList<>();

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
        cart.setLocation(CellarEntry);

        cart.setLocation(Storage);
        Baron.setAction(drink);
        for (int i = 0; i < 10; i++) {
            Bottle bottle = PassageBottles.getBottle(i);
            Baron.performAction(bottle);
            Types name = bottle.getName();
            PassageDrunkBottles.add(String.format("%.2f", (bottle.volume())) + " " + name);
        }
        System.out.println(Baron.getName() + " по пути выпил бутылки: " + PassageDrunkBottles);

        cart.empty();
        Hertsog.moveTo(door);
        Hertsog.setAction(touch);
        System.out.println(Hertsog.getName()+" начал ощупывать дверцу, ища секретный замок.");
        while (Hertsog.getStressLevel() < 5) {
            Hertsog.performAction(door);
        }
        System.out.println("Сколько он ни щупал дверь, она оставалась запертой");
        try {
            for (int i = 0; i < (int) (Math.random()*5+5); i++) {
                Bottle bottle = StorageBottles.getBottle(i);
                Baron.performAction(bottle);
                Types name = bottle.getName();
                StorageDrunkBottles.add(String.format("%.2f", (bottle.volume())) + " " + name);
            }
            System.out.println(Baron.getName() + " расправился с бутылками, стоящими у входа: " + StorageDrunkBottles);
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
        TouchBottle TouchBottle = new TouchBottle();
        Hertsog.setAction(TouchBottle);
        Hertsog.performAction(new Bottle(Types.Borjomi, (float) Math.random()*0.5f+0.5f, Colors.Red));
        Hertsog.performAction(new Bottle(Types.Borjomi, (float) Math.random()*0.5f+0.5f, Colors.Yellow));
    }
}