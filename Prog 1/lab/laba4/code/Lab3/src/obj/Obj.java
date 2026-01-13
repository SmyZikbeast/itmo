package obj;


public abstract class Obj {
    public String Name;
    public Object Location;

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
    public void setLocation(Object Location) {this.Location = Location;}
    public Object getLocation(){ return this.Location;}
}