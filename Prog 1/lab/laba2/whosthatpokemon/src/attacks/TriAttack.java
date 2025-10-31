package attacks;

import ru.ifmo.se.pokemon.*;

public final class TriAttack extends SpecialMove {
    public TriAttack(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    Effect e = new Effect();
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random()<0.0667){
            e.paralyze(p);
        } else if (Math.random()<0.13333) {
            e.burn(p);
        } else if (Math.random()<0.2) {
            e.freeze(p);
        }
    }
    @Override
    protected String describe(){
        return "Used Tri attack";
    }
}
