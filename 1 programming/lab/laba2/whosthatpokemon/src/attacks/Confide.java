package attacks;

import ru.ifmo.se.pokemon.*;

public final class Confide extends StatusMove {
    public Confide(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random()<0.1) {
            p.setMod(Stat.SPECIAL_ATTACK,-1);
        }
    }
    @Override
    protected String describe(){
        return "Used Confide";
    }
}
