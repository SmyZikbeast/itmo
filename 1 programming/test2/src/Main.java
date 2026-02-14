import java.util.Set;
import java.util.HashSet;

public class Main{

    public static void main(String[] args) {

        Set<String> data = Set.<String>of("Java", "JavaScript", "C#");

        HashSet<String> langs = new HashSet<String>(data);
        langs.add("C");
        System.out.println(langs); // [C#, Java, JavaScript]
    }
}