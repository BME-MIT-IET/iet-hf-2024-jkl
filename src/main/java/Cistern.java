import java.util.*;
public class Cistern extends ActiveField {
    public static int index = 0;
    public Cistern() {
        waterCount = 0;
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        name = "cistern" + ++index;
    }
    public Cistern(String name) {
        this.name = name;
        ++index;
    }

    /**
     * Gives points to the Mechanics, if the Cistern has water.
     * @param p
     */
    public void givePoints(PointCounter p) {
        //System.out.println("\"Cistern.givePoints\" function called");
        while (waterCount > 0){
            p.addMechanicPoints();
            waterCount--;
        }
    }

    /**
     * Randomly generates a Pipe and makes it its neighbour.
     */
    public boolean generatePipe() {
        //System.out.println("\"Cistern.generatePipe\" function called");

        Random rand = new Random();
        if (!RandomToggle.isTurnedOn()){
            Pipe p = new Pipe();
            p.addNeighbour(this);
            this.addNeighbour(p);
            return true;
        }else
        if (rand.nextInt(11) == 1) { // 10% chance
            Pipe p = new Pipe();
            p.addNeighbour(this);
            this.addNeighbour(p);
            return true;
        }
        return false;
    }

    /**
     * Gives pump to a Player
     * @param p
     */
    public boolean givePump(Player p) {
        //System.out.println("\"Cistern.givePump\" function called");
        Pump pump = new Pump();
        p.addPump(pump);
        return true;
    }

    /**
     * Removes water from its every neighbouring Pipe
     */
    public void step() {
        //System.out.println("\"Cistern.step\" function called");
        Iterator<Field> iterator = neighbours.iterator();
        while(iterator.hasNext()) {
            iterator.next().removeWater();
        }
        if (RandomToggle.isTurnedOn()){
            generatePipe();
        }

    }
}
