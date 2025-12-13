package Records;
import Enums.Types;

public record Bottle(Types type, float volume) {
    public Types getName(){
        return this.type;
    }
}
