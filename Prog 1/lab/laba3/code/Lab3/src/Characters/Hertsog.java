package Characters;

import Actions.TouchWall;
import Items.Door;

public class Hertsog extends Character {

    public Hertsog(String name) {
        super(name);
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
