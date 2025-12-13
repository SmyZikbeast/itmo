import Actions.Action;
import Actions.Drink;
import Actions.TouchWall;
import Characters.Baron;
import Characters.Character;
import Characters.Hertsog;
import Enums.Locations;
import Enums.Types;
import Items.Barrels;
import Items.Bottles;
import Items.Door;
import Records.Bottle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static Enums.Locations.*;

public class Main {
    public static void main(String[] args){
        Barrels barrels = new Barrels("Бочки", (Passage).name());
        Door door = new Door("Дверь", (Exit).name());
        Action touch = new TouchWall();
        Hertsog Hertsog = new Hertsog("Герцог");
        Hertsog.setAction(touch);
        System.out.println(Hertsog.getName()+" начал ощупывать дверцу, ища секретный замок.");
        while (Hertsog.getAngerLevel() < 5) {
            Hertsog.performAction(door);
        }
        System.out.println("Сколько он ни щупал дверь, она оставалась запертой");
        Baron Baron = new Baron("Барон");
        Action drink = new Drink();
        Baron.setAction(drink);
        Bottles bottles = new Bottles("Бутылки", Storage.name());
        bottles.fillBottles();
        List<String> drunkBottles = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            Bottle bottle = bottles.getBottles()[i];
            Baron.performAction(bottle);
            Types name = ((Bottle) bottle).getName();
            drunkBottles.add(String.format("%.2f",(((Bottle) bottle).volume())) + " " + name);
        }
        System.out.println(Baron.getName()+" расправился с бутылками, стоящими у входа: " + drunkBottles);
        Baron.moveTo(barrels);
        Baron.moveTo(Hertsog);
        System.out.println(Hertsog.getName()+" продолжил ощупывать дверцу, все больше раздражаясь.");
        while (Hertsog.getAngerLevel() < 10) {
            Hertsog.performAction(door);
        }
        System.out.println("Дверь не открылась");
    }
}