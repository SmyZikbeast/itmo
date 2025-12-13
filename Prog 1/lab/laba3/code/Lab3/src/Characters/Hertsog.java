package Characters;

import Actions.Drink;
import Actions.TouchWall;
import Enums.Locations;
import Exceptions.MissionFailedException;
import Items.Door;
import Records.Bottle;

public class Hertsog extends Character {
    float AngerLevel = 0;


    public Hertsog(String name) {
        super(name);
    }

    public float getAngerLevel(){
        return this.AngerLevel;
    }
    public String getLocation(){
        return this.Location;
    }
    void addAngerLevel(float level){
        this.AngerLevel = this.getAngerLevel() + level;
    }

    public void performAction(Door door) {
        if (Action instanceof TouchWall) {
            ((TouchWall) Action).perform(door,this);
            this.addAngerLevel(0.5f);
        }
    }

}
