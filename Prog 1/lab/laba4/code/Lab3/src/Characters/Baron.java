package Characters;

import Actions.Drink;
import Exceptions.ActionNotFoundException;
import Exceptions.MissionFailedException;
import Items.Item;
import Items.fallable;
import Records.Bottle;

public class Baron extends Character {
    public Baron(String name) {
        super(name);
    }

    public void performAction(Bottle bottle) throws ActionNotFoundException {
        if (this.getAction() instanceof Drink) {
            Action.perform(bottle, this);
        } else {
            throw new ActionNotFoundException();
        }
    }

    @Override
    public void moveTo(Object place) {
        try {
            if (place instanceof Item) {
                if (StressLevel > 8.5f) {
                    ((fallable) place).fall(this);
                    throw new MissionFailedException("Барона завалило");
                }
            }
            super.moveTo(place);
        } catch (MissionFailedException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}