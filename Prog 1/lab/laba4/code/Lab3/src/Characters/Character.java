package Characters;

import Actions.Action;
import Enums.Locations;
import Items.Item;
import java.util.Objects;
import obj.Obj;

public abstract class Character extends Obj{
    public Character(String Name) {super(Name);}
    public Character(String Name, String Location) {super(Name, Location);}

    protected Action Action;
    public void setAction(Action action){
        this.Action = action;
    }
    public Action getAction(){return this.Action;}

    protected float StressLevel = 0f;

    public float getStressLevel(){
        return this.StressLevel;
    }
    public void addStressLevel(float level){
        this.StressLevel = this.getStressLevel() + level;
    }

    public void Want(String s){
        System.out.println(this.getName()+" хотел "+s);
    }
    public void NotWant(String s){
        System.out.println(this.getName()+" не хотел "+s);
    }
    public void Hear(String s){
        System.out.println(this.getName()+" слышал, что "+s);
    }
    public void Explain(String s){
        System.out.println("У "+this.getName()+"а было оправдание: \""+s+"\"");
    }
    public void moveTo(Object place){
        if (place instanceof Locations){
            this.Location = ((Locations) place).name();
            System.out.println(this.getName() +" в локации:" + ((Locations)place).name());
        }
        else if (place instanceof Item) {
            this.Location = (place);
            System.out.println(this.getName() +" в локации:" + ((Item)place).getName());
        }
        else if (place instanceof Character) {
            this.Location = ((Character) place).getName();
            System.out.println(this.getName() +" в локации:" + ((Character)place).getName());
        }
        else {
            throw new IllegalArgumentException("Сюда нельзя");
        }

    }

    @Override
    public String toString() {
        return "Character{" +
                "Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Action='" + Action + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Name.equals(character.getName()) && Location.equals(character.getLocation()) && Action.equals(character.getAction()) &&
                (Math.abs(StressLevel-character.getStressLevel())<0.00001f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Location, Action, StressLevel);
    }
}
