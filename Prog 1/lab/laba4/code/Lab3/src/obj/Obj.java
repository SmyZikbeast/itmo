package obj;

public class Obj {
    public String Name;
    public String Location;

    public Obj(String name) {
        this.Name = name;
    }
    public Obj(String name, String Location) {
        this.Name = name;
        this.Location = Location;
    }

    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void setLocation(String Location) {this.Location = Location;}
    public String getLocation(){ return this.Location;}
}