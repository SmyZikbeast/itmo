package Items;

import Characters.Character;
import Exceptions.MissionFailedException;
import obj.Obj;

import java.util.Objects;

import static Enums.Locations.CellarDoor;

public class Cart extends Item {
    private Obj Content = null;
    private Character Driver = null;
    public Cart(String Name, String Location) {
        super(Name, Location);
    }

    public Character getDriver() {
        return Driver;
    }
    public void setDriver(Character driver) {
        Driver = driver;
    }
    public Obj getContent() {
        return Content;
    }
    public void setContent(Obj content) {
        this.Content = content;
    }
    public void moveTo(Item Location) {
        if (Content != null) {
            System.out.println(Driver.getName() + " толкает тележку с " + Content.getName() + " в " + Location.getName());
        }
        else {
            System.out.println(Driver.getName() + " толкает тележку в " + Location.getName());
        }
        if (!(Location instanceof Door) || ((Door) Location).getState() == Boolean.TRUE) {
            Driver.setLocation(Location.getLocation());
            Content.setLocation(Location.getLocation());
            this.Location = Location.getLocation();
            if (Location instanceof Door){
                System.out.println("К счастью, дверь оказалась открытой");
            }
        }
        else{
            throw new MissionFailedException("ребята разбились об закрытую дверь");
        }
    }
    @Override
    public void setLocation(String Location) {
        if (Content != null) {
            System.out.println(Driver.getName() + " толкает тележку с " + Content.getName() + " в " + Location);
        }
        else {
            System.out.println(Driver.getName() + " толкает тележку в " + Location);
        }
        Driver.setLocation(Location);
        this.Location = Location;
        Content.setLocation(Location);
    }
    @Override
    public String toString() {
        return "Item{" +
                "Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Contains='" + Content + '\'' +
                ", Driver='" + Driver + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Cart i = (Cart) o;
        return Name.equals(i.Name) &&
                Location.equals(i.Location) &&
                Content.equals(i.Content);

    }
    @Override
    public int hashCode() {
        return Objects.hash(Name, Location, Content);
    }
}
