import java.util.ArrayList;
import java.util.Random;

public class Pump extends ActiveField {
    private boolean isBroken;
    private Pipe inputPipe;
    private Pipe outputPipe;
    public static int index = 0;

    public Pipe getInputPipe() {
        return inputPipe;
    }

    public Pipe getOutputPipe() {
        return outputPipe;
    }

    public boolean isBroken() {
        return isBroken;
    }

    /**
     * Default constructor, initializes a pump with default values.
     * By default, pumps have no water, aren't broken, and are not connected to any other fields.
     */
    public Pump() {
        this.waterCount = 0;
        this.isBroken = false;
        this.inputPipe = null;
        this.outputPipe = null;
        players = new ArrayList<>();
        neighbours = new ArrayList<>();
        name = "pump" + ++index;
    }
    public Pump(String name) {
        this.name = name;
        ++index;
    }

    /**
     * Alternate constructor for making level building easier later on.
     * @param in        Input pipe
     * @param out       Output pipe
     */
    public Pump(Pipe in, Pipe out) {
        this.isBroken = false;
        this.waterCount = 0;
        this.inputPipe = in;
        this.outputPipe = out;
    }

    /**
     * Sets the input and output pipes.
     *
     * @param in        Input pipe, directs water into pump.
     * @param out       Output pipe, leads water away from pump.
     */
    public void redirect(Field in, Field out) {
        //System.out.println("\"Pump.redirect\" function called");
        this.inputPipe = (Pipe)in;
        this.outputPipe = (Pipe)out;
    }

    /**
     * Repairs the pump by setting isBroken to false.
     */
    public boolean repair() {
        //System.out.println("\"Pump.repair\" function called");
        isBroken = false;
        return true;
    }

    /**
     * Breaks the pump by setting isBroken to true.
     */
    public void break_() {
        //System.out.println("\"Pump.break\" function called");
        isBroken = true;
    }

    public void givePoints(PointCounter p) {
        //System.out.println("\"Pump.givePoints\" function called");
    }

    /**
     * Tries taking water from the input pipe, and passing water to the output pipe
     * after checking if they are valid.
     */
    public void step() {
        //System.out.println("\"Pump.step\" function called");
        if (inputPipe != null) {
            inputPipe.removeWater();
        }
        if (outputPipe != null) {
            outputPipe.addWater();
        }
        if (RandomToggle.isTurnedOn()){
            Random r = new Random();
            if (r.nextInt(11) == 1) { // 10% chance
                this.break_();
            }
        }
    }
}
