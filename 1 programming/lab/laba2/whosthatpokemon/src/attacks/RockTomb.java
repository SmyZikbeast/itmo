package attacks;

import ru.ifmo.se.pokemon.*;

public final class RockTomb extends PhysicalMove {
    public RockTomb(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED,-1);
    }
    @Override
    protected String describe(){
        return "Used Rock tomb";
    }
}
