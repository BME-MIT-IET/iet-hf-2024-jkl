import java.util.ArrayList;
import java.util.Iterator;

public class Spring extends ActiveField {
    public static int index = 0;
    /**
     * Default constructor with initial values.
     * A new Spring has no players on it, and is not connected to any fields.
     */
    public Spring() {
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        name = "spring" + ++index;
    }
    public Spring(String name) {
        this.name = name;
        ++index;
    }

    /**
     * Adds water to each of its neighbours in every step
     */
    public void step() {
        //System.out.println("\"Spring.step\" function called");
        Iterator<Field> iterator = neighbours.iterator();
        while(iterator.hasNext()) {
            iterator.next().addWater();
        }
    }
}
