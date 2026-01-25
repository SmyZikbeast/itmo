package attacks;

import ru.ifmo.se.pokemon.*;

public final class WaterGun extends SpecialMove {
    public WaterGun(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    @Override
    protected String describe(){
        return "Used Water gun";
    }
}
