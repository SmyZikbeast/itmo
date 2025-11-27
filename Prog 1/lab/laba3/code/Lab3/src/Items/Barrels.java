package Items;

public class Barrels extends Item implements fallable {
    public Barrels(String Name, String Location) {
        super(Name, Location);
    }
    void drop(){};
    @Override
    public void fall(float level) {
        if (level > 60) {
            this.drop();
        }
    }
}
