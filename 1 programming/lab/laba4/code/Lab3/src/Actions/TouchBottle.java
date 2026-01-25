package Actions;

import Characters.Character;
import Enums.Colors;
import Exceptions.WrongPositionException;
import Items.Door;
import Records.Bottle;

public class TouchBottle extends Action {
    @Override
    public void perform(Object Bottle, Character character){
        if (((Bottle) Bottle).color() == Colors.Yellow) {
            try {
                if (!(character.getLocation() instanceof Door)){
                    throw new WrongPositionException((String) character.getLocation());
                }
                else {
                    ((Door) character.getLocation()).Open();
                    System.out.println(character.getName()+" с трудом взял бутылку с желтым ярлыком и дверь открылась");
                }
            }
            catch (WrongPositionException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }

        }
        else {
            System.out.println(character.getName()+" потрогал не ту бутылку");
        }
    }
}