package Actions;

import Characters.Character;
import Records.Bottle;

public class Drink extends Action {
    @Override
    public void perform(Object bottle, Character character) {
        character.addStressLevel(((Bottle)bottle).volume());
    }
}
