package attacks;

import ru.ifmo.se.pokemon.*;

public final class SteelWing extends PhysicalMove {
    public SteelWing(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        if (Math.random()<0.1) {
            p.setMod(Stat.DEFENSE,+1);
        }
    }
    @Override
    protected String describe(){
        return "Used Steel wing";
    }
}
