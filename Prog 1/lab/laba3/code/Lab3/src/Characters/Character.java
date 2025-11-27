package Characters;

import Actions.Action;
import Enums.Locations;
import Items.Barrels;
import Items.Item;

public abstract class Character {
    String Name;
    String Location;
    Action Action;
    abstract void getStatus();
    abstract void performAction();
    void setName(String Name){
        this.Name = Name;
    }
    String getName(){
        return this.Name;
    }
    void moveTo(Object place){
        if (place instanceof Locations){}
        else if (place instanceof Item) {}
        else if (place instanceof Character) {}
        else {}

    }
}
