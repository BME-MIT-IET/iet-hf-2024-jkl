import java.io.Serializable;

public class PointCounter {
    private int mechanicPoints;
    private int saboteurPoints;
    public PointCounter() {
        mechanicPoints = 0;
        saboteurPoints = 0;
    }

    /**
     * Increments mechanicPoints by one
     */
    public void addMechanicPoints() {
        //System.out.println("\"PointCounter.addMechanicPoints\" function called");
        ++mechanicPoints;
    }

    /**
     * Increments saboteurPoints by one
     */
    public void addSaboteurPoints() {
        //System.out.println("\"PointCounter.addSaboteurPoints\" function called");
        ++saboteurPoints;
    }

    /**
     * Getter for mechanicPoints
     */
    public int getMechanicPoints(){
        //System.out.println("\"PointCounter.getMechanicPoints\" function called");
        return this.mechanicPoints;
    }

    /**
     * Getter for saboteurPoints
     */
    public int getSaboteurPoints(){
        //System.out.println("\"PointCounter.getSaboteurPoints\" function called");
        return this.saboteurPoints;
    }
}
