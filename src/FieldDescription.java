import java.util.ArrayList;

public class FieldDescription {
    private final FieldType type;
    private final String name;
    private final ArrayList<Double> coordinates;
    private final boolean isBroken;
    private final boolean isBreakable;
    private final boolean isSticky;
    private final boolean isSlippery;
    private final boolean hasWater;

    public FieldDescription(FieldType type, String name, ArrayList<Double> coordinates, boolean isBroken, boolean isBreakable, boolean isSticky, boolean isSlippery, boolean hasWater) {
        this.type = type;
        this.name = name;
        this.coordinates = coordinates;
        this.isBroken = isBroken;
        this.isBreakable = isBreakable;
        this.isSticky = isSticky;
        this.isSlippery = isSlippery;
        this.hasWater = hasWater;
    }

    public FieldType getType() { return type; }

    public String getName() { return name; }

    // may be empty if field is held by a player (see PlayerDescription)
    public ArrayList<Double> getCoordinates() { return coordinates; }

    public boolean isBroken() { return isBroken; }

    public boolean isBreakable() { return isBreakable; }

    public boolean isSticky() { return isSticky; }

    public boolean isSlippery() { return isSlippery; }
    public boolean hasWater() { return hasWater; }
}
