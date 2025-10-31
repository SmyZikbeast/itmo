package attacks;

import ru.ifmo.se.pokemon.*;

public final class QuickAttack extends PhysicalMove {
    public QuickAttack(Type type, double power, double accuracy, int priority, int hits){
        super(type,power,accuracy,priority,hits);
    }
    @Override
    protected String describe(){
        return "Used Quick attack";
    }
}
