package Characters;

import Actions.Drink;
import Enums.Locations;
import Exceptions.MissionFailedException;
import Items.Item;
import Items.fallable;
import Records.Bottle;

public class Baron extends Character {

    public Baron(String name) {
        super(name);
    }

    public void performAction(Bottle bottle) {
        if (Action instanceof Drink) {
            ((Drink) Action).perform(bottle,this);
        }
    }
    public String getLocation(){
        return this.Location;
    }
        @Override
        public void moveTo (Object place){
        try {
            if (place instanceof Item) {
                if (this.DrunkLevel > 7f) {
                    ((fallable)place).fall(this);
                    throw new MissionFailedException("Барона завалило");
                }
                else {
                    super.moveTo(place);
                }
            }
             else {
                super.moveTo(place);
            }
        }
        catch (MissionFailedException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
