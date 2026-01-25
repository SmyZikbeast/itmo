package Characters;

import Actions.Action;
import Enums.Locations;
import Items.Item;
import java.util.Objects;

public class Character {
    protected String Name;
    protected String Location;
    protected Action Action;
    protected float DrunkLevel = 0;
    protected float AngerLevel = 0;
    public Character(String name) {
        this.Name = name;
    }
    public void setAction(Action action){
        this.Action = action;
    }
    public float getDrunkLevel(){
        return this.DrunkLevel;
    }
    public float getAngerLevel(){
        return this.AngerLevel;
    }
    public void addDrunkLevel(float level){
        this.DrunkLevel = this.getDrunkLevel() + level;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public String getLocation(){ return this.Location;}
    public Action getAction(){return this.Action;}
    void moveTo(Object place){
        if (place instanceof Locations){
            this.Location = ((Locations) place).name();
        }
        else if (place instanceof Item) {
            this.Location = ((Item)place).getName();
        }
        else if (place instanceof Character) {
            this.Location = ((Character) place).getName();
        }
        else {
            throw new IllegalArgumentException("Сюда нельзя");
        }
        System.out.println(this.getName() +" в локации:" + Location);
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
                (Math.abs(DrunkLevel-character.getDrunkLevel())<0.00001f) && (Math.abs(AngerLevel-character.getAngerLevel())<0.00001f);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Name, Location, Action, DrunkLevel, AngerLevel);
    }
}
