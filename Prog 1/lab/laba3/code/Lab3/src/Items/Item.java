package Items;
import java.util.Objects;

public class Item {
    protected String Name;
    protected String Location;
    public Item(String Name, String Location) {
        this.Name = Name;
        this.Location = Location;
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String Name) {this.Name = Name;}
    public String getLocation() {return this.Location;}
    public void setLocation(String Location) {this.Location = Location;}
    @Override
    public String toString() {
        return "Item{" +
                "Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Item i = (Item) o;
        return Name.equals(i.Name) &&
                Location.equals(i.Location);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Name, Location);
    }
}
