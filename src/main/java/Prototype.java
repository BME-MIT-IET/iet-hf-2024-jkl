import java.io.*;
import java.util.Scanner;

public class Prototype {
    private Game game;
    private Timer timer;
    public Prototype() {
        game = new Game();
        timer = new Timer(game);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String[] input = inputLine.split(" ");
        boolean startingFlag = false;
        while (!startingFlag) {
            switch (input[0]) {
                case "addplayer":
                    if (input.length != 3) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    switch (input[1]) {
                        case "m":
                            Mechanic m = new Mechanic(input[2]);
                            try {
                                game.addPlayer(m);
                                game.mechanicNameList.add(m.getName());
                                System.out.println("Mechanic " + m.getName() + " has been added to the list of players.");

                            } catch (IllegalArgumentException e) {
                                System.out.println(m.getName() + " could not be added to the list of players:\n\t" + e.getMessage());
                            }
                            break;
                        case "s":
                            Saboteur s = new Saboteur(input[2]);
                            try {
                                game.addPlayer(s);
                                game.saboteurNameList.add(s.getName());
                                System.out.println("Saboteur " + s.getName() + " has been added to the list of players.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(s.getName() + " could not be added to the list of players:\n\t" + e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Invalid command");
                    }
                    break;
                case "removeplayer":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }

                    if (game.removePlayer(input[1])){
                        if(game.mechanicNameList.contains(input[1])) {
                            System.out.println("REMOVED MECHANIC");
                            game.mechanicNameList.remove((input[1]));
                        } else if (game.saboteurNameList.contains(input[1])) {
                            System.out.println("REMOVED MECHANIC");
                            game.saboteurNameList.remove(input[1]);
                        }

                        System.out.println(input[1] + " has been removed from the list of players.");
                    } else {
                        System.out.println("No player named " + input[1] + " was found.");
                    }
                    break;
                case "addfield":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    switch (input[1]) {
                        case "spring":
                            try {
                                Spring s = game.addSpring();
                                System.out.println("Spring " + s.getName() + " has been created and added to the list of fields.");
                            } catch (IllegalStateException e) {
                                System.out.println("Spring creation unsuccessful:\n\t" + e.getMessage());
                            }
                            break;
                        case "cistern":
                            try {
                                Cistern c = game.addCistern();
                                System.out.println("Cistern " + c.getName() + " has been created and added to the list of fields.");
                            } catch (IllegalStateException e) {
                                System.out.println("Cistern creation unsuccessful:\n\t" + e.getMessage());
                            }
                            break;
                        case "pump":
                            Pump p = game.addPump();
                            System.out.println("Pump " + p.getName() + " has been created and added to the list of fields.");
                            break;
                        case "sand":
                            Sand sa = game.addSand();
                            System.out.println("Sand " + sa.getName() + " has been created and added to the list of fields.");
                            break;
                    }
                    break;
                case "connect":
                    if (input.length != 3) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    try {
                        Field f1 = game.getFieldByName(input[1]);
                        Field f2 = game.getFieldByName(input[2]);

                        Pipe pi = game.addPipe();
                        System.out.println("Pipe " + pi.getName() + " has been created and added to the list of fields.");
                        pi.addNeighbour(f1);
                        pi.addNeighbour(f2);
                        f1.addNeighbour(pi);
                        f2.addNeighbour(pi);
                        System.out.println(f1.getName() + " and " + f2.getName() + " are now connected by " + pi.getName() + ".");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Connection unsuccessful:\n\t" + e.getMessage());
                    }
                    break;
                case "clearlevel":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    game = new Game();
                    System.out.println("Level cleared. All fields have been removed.");
                    break;
                case "savelevel":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    try {
                        String saveFile = saveGame(input[1]);
                        System.out.println(
                                "The current configuration of fields have been saved as " + saveFile + ".\n" +
                                "You can use the command „loadlevel " + saveFile + "” to load it again.\n");
                    } catch (Exception e) {
                        System.out.println("Save unsuccessful:\n\t" + e.getMessage());
                    }
                    break;
                case "loadlevel":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    try {
                        String saveFile = loadGame(input[1]);
                        System.out.println("The configuration of fields from " + saveFile + " have been loaded.");
                    } catch (Exception e) {
                        System.out.println("Load unsuccessful:\n\t" + e.getMessage());
                    }
                    break;
                case "start":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    // First checks if the game is ready to start
                    game.initialize();
                    startingFlag = true;
                    System.out.println("The game has started!");
                    break;
                case "listfields": // NOT IN SPECIFICATION! FOR TESTING PURPOSES ONLY!
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    var fields = game.getFields();
                    for (Field f : fields) {
                        System.out.println(f);
                    }
                    break;
                case "listplayers": // NOT IN SPECIFICATION! FOR TESTING PURPOSES ONLY!
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    var players = game.getPlayers();
                    for (Player p : players) {
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
            inputLine = sc.nextLine();
            input = inputLine.split(" ");
        }

        while (!input[0].equals("quit") && game.getRoundsLeft() > 0) {


            switch (input[0]) {
                case "move":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    try {
                        // If player move is successful
                        Field _current = game.getActivePlayer().getCurrentField();


                        if(game.getActivePlayer().move(game.getFieldByName(input[1]))) {
                            System.out.println(game.getActivePlayer().getName() + " has moved from " + _current.getName() + " to " + input[1] + ".");
                            timer.tick();
                            System.out.println("It's " + game.getActivePlayer().getName() +"'s turn.");

                        } else {
                            if (game.getFieldByName(input[1]).isSlippery()) {
                                System.out.println(game.getActivePlayer().getName() + " has slid from " + game.getFieldByName(input[1]).getName() + " to " + game.getActivePlayer().currentField.getName());
                                timer.tick();
                                System.out.println("It's " + game.getActivePlayer().getName() +"'s turn.");
                            }
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Move unsuccessful:\n\t" + e.getMessage());
                    }
                    break;

                case "pass":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    System.out.println(game.getActivePlayer().getName() + " has passed their turn.");
                    timer.tick();
                    System.out.println("It's " + game.getActivePlayer().getName() +"'s turn.");
                    break;

                case "redirectpump":
                    if (input.length != 3) {
                        System.out.println("Invalid arguments");
                        break;
                    }

                    if(game.getActivePlayer().redirectPump(game.getFieldByName(input[1]), game.getFieldByName(input[2]))) {
                        System.out.println(game.getActivePlayer().getCurrentField().getName() + " is now pumping water from " + input[1] + " to " + input[2] + ".");
                    } else {
                        System.out.println("Redirect unsuccessful\n");
                    }

                    break;

                case "puncturepipe":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    if(game.getActivePlayer().puncture()) {
                        System.out.println(game.getActivePlayer().getCurrentField().getName() + " has been punctured by " + game.getActivePlayer().getName() + ".");
                    } else {
                        System.out.println("Puncture unsuccessful\n");
                    }


                    break;

                case "makesticky":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    if(game.getActivePlayer().makeSticky()) {
                        System.out.println(game.getActivePlayer().getCurrentField().getName() + " became sticky by the hands of " + game.getActivePlayer().getName() + ".");
                    } else {
                        System.out.println("Sticky unsuccessful\n");
                    }


                    break;

                case "pickuppipe":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }

                    if(game.getActivePlayer().pickUpPipe(game.getFieldByName(input[1]))) {
                        System.out.println(game.getActivePlayer().getName() + " picked up a pipe " + input[1] + ".");
                        System.out.println(input[1] + " has been disconnected from " + game.getActivePlayer().getCurrentField().getName() + ".");
                    } else {
                        System.out.println("Picking up pipe unsuccessful\n");
                    }

                    break;

                case "pickuppump":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                   if(game.getActivePlayer().pickUpPump()) {
                       System.out.println("Pump " + game.getActivePlayer().getPickedUpPump().getName() + " has been created.");
                       System.out.println(game.getActivePlayer().getName() + " picked up " + game.getActivePlayer().getPickedUpPump().getName() + " from " + game.getActivePlayer().getCurrentField().getName() + ".");
                   } else {
                       //System.out.println("Picking up pump unsuccessful\n");
                   }

                    break;

                case "placepipe":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    Pipe pipe = game.getActivePlayer().getPickedUpPipe();
                    if(pipe != null && game.getActivePlayer().placePipe()) {
                        System.out.println( game.getActivePlayer().getName() + " placed down " + pipe.getName() + ". \n" +
                                            pipe.getName() + " is now connected to " + game.getActivePlayer().getCurrentField().getName() + ".");
                    } else {
                        System.out.println("Placing pipe unsuccessful\n");
                    }

                    break;

                case "placepump":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    Field pipe1 = game.getActivePlayer().getCurrentField();
                    Field pump = ((Mechanic)game.getActivePlayer()).getPickedUpPump();
                    if(game.getActivePlayer().placePump()) {
                        Field pipe2 = pump.getNeighbours().get(0) == pipe1 ? pump.getNeighbours().get(1) : pump.getNeighbours().get(0);

                        System.out.println(pipe1.getName() + " has been cut in half by " + game.getActivePlayer().getName() +
                                " to place down " + pump.getName() + ". \n" +
                                "Pipe " + pipe2.getName() + " has been created.\n" +
                                pump.getName() + " has been placed down between " + pipe1.getName() + " and " + pipe2.getName() + ".");
                    } else {
                        //System.out.println("Placing pump unsuccessful\n");
                    }

                    break;

                case "repair":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    if(game.getActivePlayer().repair()) {
                        System.out.println(game.getActivePlayer().getCurrentField().getName() +
                                " has been repaired by " + game.getActivePlayer().getName() + ".");
                    } else {
                        System.out.println("Repair unsuccessful\n");
                    }

                    break;

                case "makeslippery":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    if(game.getActivePlayer().makeSlippery()) {
                        System.out.println(game.getActivePlayer().getCurrentField().getName() +
                                " became slippery by the hands of " + game.getActivePlayer().getName() + ".");
                    } else {
                        System.out.println("Slippery unsuccessful\n");
                    }

                    break;

                case "listplayers":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    var players = game.getPlayers();
                    for (Player p : players) {
                        System.out.println(p);
                    }
                    break;

                case "listfields":
                    if (input.length != 1) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    var fields = game.getFields();
                    for (Field f : fields) {
                        System.out.println(f);
                    }
                    break;

                case "setplayerfield":
                    if (input.length != 3) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    boolean playerFound = false;
                    Player p = null;
                    for(Player pl : game.getPlayers()){
                        if(pl.getName().equals(input[1])){
                            playerFound = true;
                            p = pl;
                            break;
                        }
                    }
                    if(!playerFound){
                        System.out.println("No player named " + input[1] + " was found.");
                        break;
                    }

                    Field _current = p.getCurrentField();
                    if(p.setCurrentField(game.getFieldByName(input[2]))) {
                        System.out.println(p.getName() + " has been moved from " + _current.getName() + " to " + input[2] + ".");
                    } else {
                        System.out.println("Setting player's field unsuccessful\n");
                    }

                    break;

                case "randomevents":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    boolean isOn = true;
                    if(input[1].equals("true")) {
                        isOn = true;
                    }
                    if(input[1].equals("false")) {
                        isOn = false;
                    }

                    if (isOn) {
                        RandomToggle.setTurnedOn(true);
                        System.out.println("Random events have been turned on.");
                    } else if (!isOn) {
                        RandomToggle.setTurnedOn(false);
                        System.out.println("Random events have been turned off.");
                    } else {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    break;

                case "generatepipe":
                    if (input.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }

                    if(game.getFieldByName(input[1]).generatePipe()) {
                        System.out.println(input[1] + " has generated a new pipe.\n"+ game.getFields());
                    } else {
                        System.out.println("Generating pipe unsuccessful\n");
                    }

                    break;

                case "quit":
                    break;

                case "breakpump":
                    // TODO
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
            inputLine = sc.nextLine();
            input = inputLine.split(" ");
        }
    }

    /**
     * Saves the current game state to a file.
     * @param fileName the name of the file to save the game to (in /saves) (with/without .sav extension)
     * @return the name of the file the game was saved to, without the extension.
     * @throws IOException if there is any error saving the game
     */
    private String saveGame(String fileName) throws IOException {
        if (fileName.contains(" ")) {
            fileName = fileName.split(" ")[0];
        }
        if (!fileName.endsWith(".sav")) {
            fileName += ".sav";
        }
        if (!new File("saves").exists()) {
            new File("saves").mkdir();
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("saves/" + fileName));
        objectOutputStream.writeObject(game);
        objectOutputStream.flush();
        objectOutputStream.close();
        return fileName.replace(".sav", "");
    }

    /**
     * Loads a game state from a file.
     * @param fileName the name of the file to load the game from (in /saves) (with/without .sav extension)
     * @return the name of the file the game was loaded from, without the extension.
     * @throws IOException if there is any error loading the game
     */
    private String loadGame(String fileName) throws IOException, ClassNotFoundException {
        if (fileName.contains(" ")) {
            fileName = fileName.split(" ")[0];
        }
        if (!fileName.endsWith(".sav")) {
            fileName += ".sav";
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("saves/" + fileName));
        game = (Game) objectInputStream.readObject();
        objectInputStream.close();
        return fileName.replace(".sav", "");
    }
}
