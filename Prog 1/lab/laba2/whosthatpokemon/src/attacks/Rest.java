package attacks;

import ru.ifmo.se.pokemon.*;

public final class Rest extends StatusMove {
    public Rest(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    Effect e = new Effect().turns(2);

    @Override
    protected void applySelfEffects(Pokemon p) {
        e.sleep(p);
        p.restore();
    }
    @Override
    protected String describe(){
        return "Used Rest";
    }
}