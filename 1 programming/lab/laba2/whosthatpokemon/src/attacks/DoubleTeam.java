package attacks;

import ru.ifmo.se.pokemon.*;

public final class DoubleTeam extends StatusMove {
    public DoubleTeam(Type type, double power, double accuracy) {
        super(type,power,accuracy);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.EVASION,+1);
    }
    @Override
    protected String describe(){
        return "Used Double team";
    }
}
