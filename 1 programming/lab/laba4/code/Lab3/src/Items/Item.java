package Items;
import obj.Obj;

import java.util.Objects;

public class Item extends Obj {

    public Item(String Name, String Location) {
        super(Name,Location);
    }

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
