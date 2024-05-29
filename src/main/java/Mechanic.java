public class Mechanic extends Player {
    private Pump pickedUpPump;
    private Pipe pickedUpPipe;
    public Mechanic() {

    }
    public Mechanic(String name) {
        this.name = name;
    }

    public Pump getPickedUpPump() {
        return pickedUpPump;
    }

    public Pipe getPickedUpPipe() {
        return pickedUpPipe;
    }

    /**
     * Calls the repair function of the field it currently stands on
     */
    public boolean repair() {
        //System.out.println("\"Mechanic.repair\" function called");
        this.currentField.repair();
        return true;
    }

    /**
     * Picks up a pipe connected to the field it is standing on.
     * Checks if the action can be performed, if not, throws an exception.
     * @param p    Pipe to be picked up
     * @throws IllegalArgumentException    If the given field is not a pipe, or if the player already has a pipe, or if the given pipe is not a neighbour of the player's current field.
     */
    public boolean pickUpPipe(Field p) throws IllegalArgumentException {
        if (!(p instanceof Pipe)) {
            return false;
        }
        if (this.pickedUpPipe != null) {
            return false;
        }
        if (!this.currentField.getNeighbours().contains(p)) {
            return false;
        }
        p.removeNeighbour(this.currentField);
        this.currentField.removeNeighbour(p);
        this.pickedUpPipe = (Pipe) p;
        return true;
    }

    /**
     * Tries to pick up a pump. Calls the givePump function of the field it is standing on.
     * If currentField is of type Cistern, the player's pickedUpPump will be set to a new Pump.
     * Otherwise, nothing happens.
     */
    public boolean pickUpPump() {
        //System.out.println("\"Mechanic.pickUpPump\" function called");
        if(getPickedUpPump() == null) {
            if (this.currentField.givePump(this)) {
                return true;
            }
        }
        return false;
    }


    public boolean placePipe() {
        if (this.pickedUpPipe == null)
            return false;
        currentField.addNeighbour(this.pickedUpPipe);
        this.pickedUpPipe.addNeighbour(currentField);
        this.pickedUpPipe = null;
        //System.out.println("\"Mechanic.placePipe\" function called");
        return true;
    }

    public boolean placePump() {
        return this.currentField.cutAndPlace(pickedUpPump);
        //System.out.println("\"Mechanic.placePump\" function called");

    }

    /**
     * Setter for the mechanic's pickedUpPump. Called when pickUpPump is called on a Cistern.
     * @param p     The Pump to be set as the mechanic's pickedUpPump
     */
    public void addPump(Pump p) {
        //System.out.println("\"Mechanic.addPump\" function called");
        this.pickedUpPump = p;
    }
    public void addPipe(Pipe p) {
        this.pickedUpPipe = p;
    }
}
