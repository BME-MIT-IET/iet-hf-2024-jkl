import java.io.Serializable;
import java.util.*;
public abstract class Field implements Steppable, Serializable {
    protected String name;
    protected int waterCount = 0;
    protected ArrayList<Player> players = new ArrayList<>();
    protected ArrayList<Field> neighbours = new ArrayList<>();
    protected boolean stickyImmunity = false;
    public String getName() {
        return name;
    }
    /**
     * Adds the given field to this field's list of neighbours if it exists, is not itself, and is not already a neighbour.
     * @param f     Field to be added to current field's neighbours
     */
    public void addNeighbour(Field f) {
        //System.out.println("\"Field.addNeighbour\" function called");
        if (f != null && f != this && !neighbours.contains(f)) {
            neighbours.add(f);
        }
    }

    /**
     * Removes given field from this field's neighbours. If given field isn't valid, nothing happens
     * @param f     Field to be removed from list of neighbours
     */
    public void removeNeighbour(Field f) {
        //System.out.println("\"Field.removeNeighbour\" function called");
        neighbours.remove(f);
    }

    /**
     * Gets the neighbours of the current field
     */
    public ArrayList<Field> getNeighbours() {
        //System.out.println("\"Field.getNeighbours\" function called");
        return neighbours;
    }


    public void redirect(Field in, Field out) {
        //System.out.println("\"Field.redirect\" function called");
    }

    /**
     * Increments waterCount by 1
     */
    public void addWater() {
        //System.out.println("\"Field.addWater\" function called");
        ++waterCount;
    }
    /**
     * Decrements waterCount by 1
     */
    public void removeWater() {
        //System.out.println("\"Field.removeWater\" function called");
        if (waterCount > 0) {
            --waterCount;
        }
    }
    public int getWaterCount() {
        return waterCount;
    }
    public void givePoints(PointCounter p) {
        //System.out.println("\"Field.givePoints\" function called");
    }
    public boolean accept(Player p) {
        //System.out.println("\"Field.accept\" function called");
        return false;
    }
    public void remove(Player p) {
        //System.out.println("\"Field.remove\" function called");
    }

    public boolean repair() {
        //System.out.println("\"Field.repair\" function called");
        return false;
    }
    public boolean puncture() {
        //System.out.println("\"Field.puncture\" function called");
        return false;
    }
    public void makeSlippery() {}
    public boolean makeSticky() {
        return false;
    }
    public boolean isSticky() {return false;}
    public boolean isSlippery() {return false;}
    public boolean cutAndPlace(Pump p) {
        return false;
        //System.out.println("\"Field.cutAndPlace\" function called");
    }
    public boolean generatePipe() {
        //System.out.println("\"Field.generatePipe\" function called");
        return false;
    }

    public boolean givePump(Player p) {
        //System.out.println("\"Field.givePump\" function called");
        return false;
    }
    public void step() {
        //System.out.println("\"Field.step\" function called");
    }

    public String toString() {
        return (this.getClass().getName() + " - " + this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Field)) return false;
        Field f = (Field) o;
        return this.name.equals(f.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
