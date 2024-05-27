import java.util.ArrayList;
import java.util.HashMap;

public class Model extends Game {

    protected HashMap<Field, ArrayList<Double>> activeFieldCoordinates;

    /**
     * Constructor for the model. It builds up a basic map and adds the players.
     * Also calls the initialize method, so it fully initializes the model.
     * @param numberOfSaboteurs The number of saboteurs to be added.
     * @param numberOfMechanics The number of mechanics to be added.
     */
    public Model(int numberOfSaboteurs, int numberOfMechanics) {
        super();
        activeFieldCoordinates = new HashMap<>();

        // initialize players
        for (int i = 0; i < numberOfSaboteurs; i++) { addPlayer(new Saboteur("Saboteur" + (i + 1))); }
        for (int i = 0; i < numberOfMechanics; i++) { addPlayer(new Mechanic("Mechanic" + (i + 1))); }

        // initial H shaped map
        // weird indentation is to help understand the layout of the map

            // active fields
        var c0 = addCistern();                              var s4 = addSpring();
        var p1 = addPump();         var p3 = addPump();     var p5 = addPump();
        var c2 = addCistern();                              var s6 = addSpring();

            // pipes
        var p01 = addPipe();                                var p45 = addPipe();
                    var p13 = addPipe();            var p35 = addPipe();
        var p12 = addPipe();                                var p56 = addPipe();

            // connect the pipes and the other fields
        p01.addNeighbour(c0); c0.addNeighbour(p01); p01.addNeighbour(p1); p1.addNeighbour(p01);
        p12.addNeighbour(p1); p1.addNeighbour(p12); p12.addNeighbour(c2); c2.addNeighbour(p12);
        p13.addNeighbour(p1); p1.addNeighbour(p13); p13.addNeighbour(p3); p3.addNeighbour(p13);
        p35.addNeighbour(p3); p3.addNeighbour(p35); p35.addNeighbour(p5); p5.addNeighbour(p35);
        p45.addNeighbour(s4); s4.addNeighbour(p45); p45.addNeighbour(p5); p5.addNeighbour(p45);
        p56.addNeighbour(p5); p5.addNeighbour(p56); p56.addNeighbour(s6); s6.addNeighbour(p56);

        activeFieldCoordinates.put(c0, new ArrayList<>() {{ add(-0.7); add(0.7); }});
        activeFieldCoordinates.put(p1, new ArrayList<>() {{ add(-0.7); add(0.0); }});
        activeFieldCoordinates.put(c2, new ArrayList<>() {{ add(-0.7); add(-0.7); }});
        activeFieldCoordinates.put(p3, new ArrayList<>() {{ add(0.0); add(0.0); }});
        activeFieldCoordinates.put(s4, new ArrayList<>() {{ add(0.7); add(0.7); }});
        activeFieldCoordinates.put(p5, new ArrayList<>() {{ add(0.7); add(0.0); }});
        activeFieldCoordinates.put(s6, new ArrayList<>() {{ add(0.7); add(-0.7); }});

        initialize();
    }

    public ArrayList<FieldDescription> getFieldDescriptions(){
        ArrayList<FieldDescription> fieldDescriptions = new ArrayList<>();
        for (Field field : activeFieldCoordinates.keySet()) {
            FieldType type;
            try {
                type = FieldType.valueOf(field.toString().split(" - ")[0].toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid field type: " + field.toString().split(" - ")[0]
                        + "\n\t TLDR; Abel fucked up.");
                throw e;
            }
            ArrayList<Double> coords = activeFieldCoordinates.get(field);
            boolean isBreakable = false, isSticky = field.isSticky(), isSlippery = field.isSlippery(),
                    isBroken = type.equals(FieldType.PUMP) && ((Pump) field).isBroken(), hasWater = false;
            fieldDescriptions.add(new FieldDescription(type, field.getName(), coords, isBroken, isBreakable, isSticky, isSlippery, hasWater));
            //System.out.println(coords);
        }

        for (Field field : getFields()) {
            if (!field.toString().contains("Pipe"))
                continue;
            FieldType type = FieldType.PIPE;
            String name = field.getName();
            ArrayList<Double> coords = new ArrayList<>();
            for (Field neigh : field.getNeighbours()){ coords.addAll(activeFieldCoordinates.get(neigh)); }
            boolean isBroken = ((Pipe) field).isPunctured(), isBreakable = ((Pipe) field).getTimeCannotBePunctured() == 0,
                    isSticky = field.isSticky(), isSlippery = field.isSlippery(), hasWater = ((Pipe) field).getWaterCount() > 0;

            fieldDescriptions.add(new FieldDescription(type, name, coords, isBroken, isBreakable, isSticky, isSlippery, hasWater));
        }

        return fieldDescriptions;
    }

    public ArrayList<PlayerDescription> getPlayerDescriptions(){
        ArrayList<PlayerDescription> playerDescriptions = new ArrayList<>();
        for (Player player : getPlayers()) {
            PlayerType type = player.toString().contains("Saboteur") ? PlayerType.SABOTEUR : PlayerType.MECHANIC;
            String standingOn = player.getCurrentField().getName();
            String holdingPipe = player.getPickedUpPipe() != null ? player.getPickedUpPipe().getName() : "";
            playerDescriptions.add(new PlayerDescription(type, player.getName(), standingOn, holdingPipe));
        }
        return playerDescriptions;
    }

    /**
     * Gives the field coordinates on the map, so that it can be queried and displayed later.
     * Call when a new activeField is added to the map, such as when a player places down a pump.
     * Call only once it was connected to its initial neighbour(s).
     * Throws exception when the field does not have any neighbours.
     * @param activeField the field placed.
     */
    public void placeInWorld(Field activeField){
        var neighbours = activeField.getNeighbours();
        if (neighbours.size() == 2)
            throw new IllegalArgumentException("Failed to place " + activeField + " in world.\n\t"
                    + "It does not have exactly 2 neighbours: it has " + neighbours.size());
        var coordsOfAllNeighbours = new ArrayList<Double>();
        for (Field n : neighbours){
            if (!activeFieldCoordinates.containsKey(n))
                throw new IllegalArgumentException("Failed to place " + activeField + " in world.\n\t"
                        + n + "'s (neighbour of " + activeField.getName() + ") coordinates are unknown!");
            coordsOfAllNeighbours.addAll(activeFieldCoordinates.get(n));
        }
        double x = (coordsOfAllNeighbours.get(0) + coordsOfAllNeighbours.get(2))/2;
        double y = (coordsOfAllNeighbours.get(1) + coordsOfAllNeighbours.get(3))/2;
        activeFieldCoordinates.put(activeField, new ArrayList<>() {{ add(x); add(y); }});
    }

    public PointCounter getPointCounter() {
        return desert.getPointCounter();
    }
}
