package attacks;

import ru.ifmo.se.pokemon.*;

public final class IceBeam extends SpecialMove {
    public IceBeam(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    Effect e = new Effect();
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random()<0.1) {
            e.freeze(p);
        }
    }
    @Override
    protected String describe(){
        return "Used Ice beam";
    }
}