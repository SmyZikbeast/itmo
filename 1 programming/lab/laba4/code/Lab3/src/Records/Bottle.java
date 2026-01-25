package Records;
import Enums.Colors;
import Enums.Types;

public record Bottle(Types type, float volume, Colors color) {
    public Types getName(){
        return this.type;
    }
}
