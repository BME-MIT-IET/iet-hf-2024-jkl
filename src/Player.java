import java.io.Serializable;
import java.util.*;
public abstract class Player {
    protected String name;
    protected Field currentField;

    public boolean setCurrentField(Field f) {
        if(currentField != null) {
            currentField.remove(this);
        }

        boolean success = f.accept(this);

        if (!success) {
            // Puts player back to original field
            currentField.accept(this);
            return false;
        } else {
            // Sets current field to new field
            currentField = f;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public Field getCurrentField() {
        return currentField;
    }

    /**
     * Player sets the input and output pipes of a Pump.
     * Checks if the given fields are neighbours of the player's current field.
     * @param in        Input pipe, directs water into pump.
     * @param out       Output pipe, leads water away from pump.
     * @throws IllegalArgumentException     If the given fields are not neighbours of the player's current field.
     */
    public boolean redirectPump(Field in, Field out) throws IllegalArgumentException {
        //System.out.println("\"Player.redirectPump\" function called");
        ArrayList<Field> neighbours = this.currentField.getNeighbours();
        if (neighbours != null) {
            if (neighbours.contains(in) && neighbours.contains(out)) {
                this.currentField.redirect(in, out);
                return true;
            }
        }
        return false;
        //throw new IllegalArgumentException("Invalid input and/or output field.");
    }

    /**
     * Checks if the field that the player wants to move to is neighbours with the player's current field.
     * If it is, it checks if the desired field accepts the player or not.
     * In case it accepts, the player is removed from the current field, and the desired field becomes the current.
     * @param nextField     The desired field to move to.
     * @return Was the move successful or not
     */
    public boolean move(Field nextField) {
        //System.out.println("\"Player.move\" function called");
        ArrayList<Field> neighbours = this.currentField.getNeighbours();
        if (neighbours != null) {
            if (neighbours.contains(nextField)) {
                boolean isAccepted = nextField.accept(this);
                if (isAccepted) {
                    this.currentField.remove(this);
                    this.currentField = nextField;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Overwritten by Mechanic, does nothing when called by non-mechanic players.
     * @param p     pump to be held by the player
     */
    public void addPump(Pump p) {
        System.out.println("\"Player.addPump\" function called");
    }



    /**
     * Calls the puncture function on its current field.
     * If currentField is a Pipe it gets punctured, nothing happens on ActiveFields.
     */
    public boolean puncture() {
        //System.out.println("\"Player.puncture\" function called");
        if(this.currentField.puncture()) {
            return true;
        }

        return false;
    }
    public boolean makeSticky() {
        if(this.currentField.makeSticky()) {
            this.currentField.stickyImmunity = true;
            return true;
        }
        return false;
    }

    public Pump getPickedUpPump() {
        return null;
    }

    public Pipe getPickedUpPipe() {
        return null;
    }

    public boolean pickUpPipe(Field p) throws IllegalArgumentException {
        return false;
    }

    public boolean pickUpPump() {
        return false;
    }
    public boolean placePipe() {
        return false;
    }
    public boolean placePump() {
        return false;
    }
    public boolean repair() {
        return false;
    }
    public boolean makeSlippery() {
        return false;
    }

    public String toString() {
        return (this.getClass().getName() + " - " + this.name);
    }
}
