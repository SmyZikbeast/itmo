package Actions;

import Characters.Character;
import Enums.Types;
import Records.Bottle;

import java.util.ArrayList;
import java.util.List;

public class Drink extends Action {

    @Override
    public void perform(Object bottle, Character character) {
        character.addDrunkLevel(((Bottle)bottle).volume());
    }


}
