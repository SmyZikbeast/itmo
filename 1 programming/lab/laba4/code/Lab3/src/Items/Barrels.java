package Items;

import Characters.Character;

public class Barrels extends Item implements fallable {
    public Barrels(String Name, String Location) {
        super(Name, Location);
    }

    @Override
    public void fall(Character character) {
        {
            System.out.println("Бочки упали");
        }
    }
}
