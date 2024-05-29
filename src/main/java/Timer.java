import java.util.*;
public class Timer {
    private final ArrayList<Steppable> steppables;

    public Timer(ArrayList<Steppable> steppables) {
        this.steppables = steppables;
    }
    public Timer(Game g) {
        steppables = new ArrayList<Steppable>();
        steppables.add(g);
    }

    /**
     * Steps every steppable object when called
     */
    public void tick() {
        Iterator<Steppable> iterator = steppables.iterator();
        while(iterator.hasNext()) {
            iterator.next().step();
        }
    }
}
