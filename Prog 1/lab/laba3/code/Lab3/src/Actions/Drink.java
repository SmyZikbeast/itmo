package Actions;

import Characters.Character;
import Records.Bottle;

public class Drink extends Action {
    @Override
    public void perform(Object bottle, Character character) {
        character.addDrunkLevel(((Bottle)bottle).volume());
    }
}
