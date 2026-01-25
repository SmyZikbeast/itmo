package Actions;

import Characters.Character;
import Items.Door;

public class TouchWall extends Action {
    @Override
    public void perform(Object Door, Character character){
        if (Math.random() < .005) {
            System.out.println(character.getName()+" нащупал нужное отверстие");
            ((Door)Door).fall(character);
            System.exit(0);
        }
    }
}
