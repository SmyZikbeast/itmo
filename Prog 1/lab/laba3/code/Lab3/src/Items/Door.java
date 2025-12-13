package Items;

import Characters.Character;

public class Door extends Item implements fallable{
    Boolean IsOpened = false;
    public Door(String Name, String Location) {
        super(Name, Location);
    }

    @Override
    public void fall(Character character){
        IsOpened = true;
        System.out.println("Дверь упала благодаря " + character.getName());
    }
}
