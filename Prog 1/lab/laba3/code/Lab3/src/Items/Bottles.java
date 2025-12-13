package Items;
import Characters.Character;
import Enums.Types;
import Records.Bottle;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Bottles extends Item implements fallable{
    @Override
    public void fall(Character character) {
        System.out.println("Бутылки упали");
        Arrays.fill(BottlesList, null);
    }

    private final Bottle[] BottlesList = new Bottle[10];
    public Bottles(String Name, String Location) {
        super(Name, Location);
    }
    public void fillBottles() {
        Random random = new Random();
        Types[] allTypes = Types.values();
        for (int i = 0; i < 10; i++) {
            Types type = allTypes[random.nextInt(3)];
            Bottle bottle = new Bottle(type, (float) Math.random());
            BottlesList[i] = bottle;
        }
    }
    public Bottle[] getBottles() {
        return BottlesList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Bottles i = (Bottles) o;
        return Name.equals(i.Name) && Location.equals(i.Location) && Arrays.equals(BottlesList, i.getBottles());
    }
    @Override
    public int hashCode() {
        return Objects.hash(Name, Location, Arrays.hashCode(BottlesList));
    }
}
