package attacks;

import ru.ifmo.se.pokemon.*;

public final class SwordsDance extends StatusMove {
    public SwordsDance(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    Effect e = new Effect();
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK,+2);
    }
    @Override
    protected String describe(){
        return "Used Swords dance";
    }
}
