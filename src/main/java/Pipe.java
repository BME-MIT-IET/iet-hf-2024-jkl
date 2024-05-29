import java.util.ArrayList;
import java.util.*;

public class Pipe extends Field {
    private boolean isOccupied;
    private boolean isPunctured;
    private int timeCannotBePunctured;
    private int timeIsSlippery;
    private int timeIsSticky;
    public static int index = 0;

    public void setTimeCannotBePunctured(int timeCannotBePunctured) {
        this.timeCannotBePunctured = timeCannotBePunctured;
    }

    public int getTimeCannotBePunctured() { return timeCannotBePunctured; }

    public int getTimeIsSlippery() {
        return timeIsSlippery;
    }

    /**
     * Constructor for creating new a new Pipe with the same default values.
     * A new pipe will always have 0 water in it, no-one standing on it,
     * not punctured and without any neighbouring fields.
     */
    public Pipe() {
        waterCount = 0;
        isOccupied = false;
        isPunctured = false;
        timeCannotBePunctured = 0;
        timeIsSlippery = 0;
        timeIsSticky = 0;
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        name = "pipe" + ++index;
    }
    public Pipe(String name) {
        waterCount = 0;
        isOccupied = false;
        isPunctured = false;
        timeCannotBePunctured = 0;
        timeIsSlippery = 0;
        timeIsSticky = 0;
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        this.name = name;
        ++index;
    }
    public boolean isPunctured() {
        return isPunctured;
    }

    /**
     * Sets isPunctured to false when called, which means the pipe has no holes on it.
     * Called by the repair function of Mechanic.
     */
    public boolean repair() {
        //System.out.println("\"Pipe.repair\" function called");
        isPunctured = false;
        if (RandomToggle.isTurnedOn()) {
            Random r = new Random();
            timeCannotBePunctured = r.nextInt(11);
        } else {
            timeCannotBePunctured = 4;
        }

        return true;
    }

    /**
     * Sets isPunctured to true, meaning the Pipe has a hole in it.
     * Checks if the Pipe can be punctured, if not, does nothing.
     * Called by the puncture function of Saboteur.
     */
    public boolean puncture() {
        //System.out.println("\"Pipe.puncture\" function called");
        if (timeCannotBePunctured == 0) {
            isPunctured = true;
            return true;
        }
        return false;
    }

    public void makeSlippery() {
        timeIsSlippery = 3;
    }
    public boolean makeSticky() {
        timeIsSticky = 3;
        return true;
    }
    public boolean isSticky() {
        return timeIsSticky > 0;
    }
    public boolean isSlippery() {return timeIsSlippery > 0;}

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    /**
     * Checks if it's occupied by another player, since only one player can stand on a Pipe field at once.
     *
     * If Pipe is not occupied: Adds the given player to the list of players standing on the field (players ArrayList contains 0 or 1 player
     * at any given time), sets isOccupied to true.
     *
     * If Pipe is occupied: Doesn't accept the player.
     *
     * @param p     The player that wants to move to this field.
     *
     * @return      Returns true if player can move to this field, false when field is already occupied.
     */

    public boolean accept(Player p) {
        //System.out.println("\"Pipe.accept\" function called");
        if (isOccupied) {
            return false;
        }
        if (timeIsSlippery > 0) {
            if(this.neighbours.size() == 0){
                throw new IllegalStateException("The pipe " + p.getName() + " tried to step on" +
                                                "does not have a neighbour.");
            }

            int n = 0;
            if (RandomToggle.isTurnedOn()){
                Random r = new Random();
                n = r.nextInt(this.neighbours.size());
            }
            //System.out.println(this.neighbours.get(0));
            p.move(this.neighbours.get(n));
            return false;
        }
        isOccupied = true;
        players.add(p);
        return true;
    }

    /**
     * Removes given player from this field and sets isOccupied to false
     * after checking that the player is actually standing on this field.
     * @param p     Player to be removed
     */
    public void remove(Player p) {
        //System.out.println("\"Pipe.remove\" function called");
        if(players.contains(p)) {
            isOccupied = false;
            players.remove(p);
        }
    }

    /**
     * Saboteurs get points if pipe is punctured, and has water in it.
     * Called in every game step by Desert.
     * @param p
     */
    public void givePoints(PointCounter p) {
        //System.out.println("\"Pipe.givePoints\" function called");
        while (isPunctured && waterCount > 0) {
            p.addSaboteurPoints();
            --waterCount;
        }
    }

    public boolean cutAndPlace(Pump p) {
        Pipe newPipe = new Pipe();
        newPipe.addNeighbour(p);
        newPipe.addNeighbour(neighbours.get(1));
        p.addNeighbour(newPipe);
        p.addNeighbour(this);
        this.addNeighbour(p);
        this.removeNeighbour(neighbours.get(1));
        neighbours.get(1).removeNeighbour(this);
        return true;

        /*
        Pipe pi = new Pipe();
        pi.addNeighbour(neighbours.get(0));
        pi.addNeighbour(p);
        p.addNeighbour(pi);
        p.addNeighbour(this);
        this.addNeighbour(p);
        this.removeNeighbour(neighbours.get(1));
        neighbours.get(1).removeNeighbour(this);*/
       //System.out.println("\"Pipe.cutAndPlace\" function called");

    }
    public void step() {
        //System.out.println("\"Pipe.step\" function called");
        if (timeCannotBePunctured != 0) {
            --timeCannotBePunctured;
        }
        if (timeIsSlippery != 0) {
            --timeIsSlippery;
        }
        if (timeIsSticky != 0) {
            --timeIsSticky;
        }
        stickyImmunity = false;
    }
}
