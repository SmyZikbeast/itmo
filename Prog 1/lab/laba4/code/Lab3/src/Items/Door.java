package Items;

import Characters.Character;

import java.util.Objects;

public class Door extends Item implements fallable{
    private Boolean IsOpened = false;
    public Door(String Name, String Location) {
        super(Name, Location);
        this.IsOpened = (Math.random() > 0.1);
    }
    public Door(String Name, String Location, Boolean isOpened) {
        super(Name, Location);
        this.IsOpened = isOpened;
    }
    public Boolean getState() {
        return IsOpened;
    }
    @Override
    public void fall(Character character){
        IsOpened = true;
        System.out.println("Дверь упала благодаря " + character.getName()+"y");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Door i = (Door) o;
        return Name.equals(i.Name) && Location.equals(i.Location) && IsOpened.equals(i.IsOpened);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Name, Location, IsOpened);
    }
}
