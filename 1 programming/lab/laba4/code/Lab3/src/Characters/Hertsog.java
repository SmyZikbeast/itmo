package Characters;

import Actions.*;
import Exceptions.ActionNotFoundException;

public class Hertsog extends Character {

    public Hertsog(String name) {
        super(name);
    }

    public void performAction(Object object) throws ActionNotFoundException {
        if (Action instanceof TouchWall) {
            Action.perform(object, this);
            this.addStressLevel(0.5f);
        } else if (Action instanceof TouchBottle) {
            Action.perform(object, this);
        }
        else
        {
            throw new ActionNotFoundException();
        }
    }
}

