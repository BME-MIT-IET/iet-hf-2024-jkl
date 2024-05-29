import java.util.ArrayList;

public class Sand extends ActiveField {
    public static int index = 0;
    /**
     * Default constructor with initial values
     */
    public Sand() {
        waterCount = 0;
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        name = "sand" + ++index;
    }
    public Sand(String name) {
        this.name = name;
        ++index;
    }

    /**
     * Adds a point to the saboteurs when the sand has water in it.
     * Decrements waterCount after accounting for points.
     */
    public void givePoints(PointCounter p) {
        //System.out.println("\"Sand.givePoints\" function called");
        while (waterCount > 0) {
            p.addSaboteurPoints();
            --waterCount;
        }
    }

    public void step() {
        //System.out.println("\"Sand.step\" function called");
    }
}
