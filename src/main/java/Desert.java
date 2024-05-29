import java.io.Serializable;
import java.util.*;
public class Desert implements Steppable, Serializable {
    private ArrayList<Field> fields;
    private transient PointCounter pointCounter;

    /**
     * Constructs a level from the given fields and creates a new Point Counter
     * @param fields    The list of Field objects that make up the current level
     */
    public Desert(ArrayList<Field> fields) {
        this.fields = fields;
        this.pointCounter = new PointCounter();
    }
    public void addField(Field f) {
        fields.add(f);
    }
    public ArrayList<Field> getFields() {
        return fields;
    }

    /**
     * Steps through and handles points for each of its fields.
     */
    public void step() {
        //System.out.println("\"Desert.step\" function called");
        Iterator<Field> iterator = fields.iterator();
        while(iterator.hasNext()) {
            Field f = iterator.next();
            f.step();
            f.givePoints(pointCounter);
        }
    }

    /**
     * Getter for its point counter
     */
    public PointCounter getPointCounter() {return this.pointCounter;}
}
