import java.io.Serializable;
import java.util.*;
public class Game implements Steppable, Serializable {
    protected transient int roundsLeft;
    protected final Desert desert;
    protected transient ArrayList<Player> players;
    protected transient Player activePlayer;
    public ArrayList<String> mechanicNameList = new ArrayList<>();
    public ArrayList<String> saboteurNameList = new ArrayList<>();

    public Game() {
        roundsLeft = 100;
        desert = new Desert(new ArrayList<>());
        players = new ArrayList<>();
    }

    public Game(int totalRounds, Desert desert, ArrayList<Player> players) {
        this.roundsLeft = players.size() * totalRounds;
        this.desert = desert;
        this.players = players;
    }

    /**
     * Adds a player to the game. Checks if the player already exists, and throws an exception if they do.
     * @param p The player to be added.
     * @throws IllegalArgumentException If the player already exists.
     */
    public void addPlayer(Player p) throws IllegalArgumentException {
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player pl = iter.next();
            if (pl.getName().equals(p.getName())) {
                throw new IllegalArgumentException("Player with name " + p.getName() + " already exists.");
            }
        }
        players.add(p);
        if (p instanceof Mechanic) {
            mechanicNameList.add(p.getName());
        } else {
            saboteurNameList.add(p.getName());
        }
    }

    /**
     * Removes a player from the game by their name.
     * @param name The name of the player to be removed.
     * @return True if the player was successfully removed, false if the player was not found.
     */
    public boolean removePlayer(String name) {
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player p = iter.next();
            if (p.getName().equals(name)) {
                players.remove(p);
                return true;
            }
        }
        return false;
    }
    protected void addField(Field f) {
        desert.addField(f);
    }

    /**
     * Adds a cistern to the desert.
     * @return The cistern that was added.
     */

    public Cistern addCistern() {
        Cistern cis = new Cistern();
        addField(cis);
        return cis;
    }

    /**
     * Adds a spring to the desert.
     * @return The spring that was added.
     */
    public Spring addSpring() {
        Spring s = new Spring();
        addField(s);
        return s;
    }

    /**
     * Adds a pump to the desert.
     * @return The pump that was added.
     */
    public Pump addPump() {
        Pump p = new Pump();
        addField(p);
        return p;
    }

    /**
     * Adds a pipe to the desert.
     * @return The pipe that was added.
     */
    public Pipe addPipe() {
        Pipe p = new Pipe();
        addField(p);
        return p;
    }

    /**
     * Adds a sand object to the desert.
     * @return The sand that was added.
     */
    public Sand addSand() {
        Sand s = new Sand();
        addField(s);
        return s;
    }

    public int getRoundsLeft() {
        return roundsLeft;
    }

    public Player getPlayerByName(String name) {
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player p = iter.next();
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No player with name " + name + " found");
    }

    public Field getFieldByName(String name) throws IllegalArgumentException {
        Iterator<Field> iter = desert.getFields().iterator();
        while (iter.hasNext()) {
            Field f = iter.next();
            if (f.getName().equals(name)) {
                return f;
            }
        }
        throw new IllegalArgumentException("No field with name " + name + " found");
    }
    public Player getActivePlayer() {
        if (activePlayer == null) {
            activePlayer = players.get(0);
        }
        return activePlayer;
    }

    /**
     * Sets the active player to the next player in the list of players.
     */
    private void nextPlayer() {
        if (activePlayer == null) {
            activePlayer = players.get(0);
        } else {
            int idx = players.indexOf(activePlayer);
            activePlayer = players.get((idx + 1) % players.size());
        }
    }

    public ArrayList<Player> getPlayers() {
        if (players == null) {
            players = new ArrayList<>();
        }
        return players;
    }

    public ArrayList<Field> getFields() {
        return desert.getFields();
    }


    public void initialize()  throws IllegalStateException {

        if(Spring.index < 1 || Cistern.index < 1) {
             throw new IllegalStateException("The game needs to have at least one Spring and one Cistern\n");
        }

        Field mechanicSpawn = getFieldByName("spring1");
        Field saboteurSpawn = getFieldByName("cistern1");

        Iterator<String> iter1 = mechanicNameList.iterator();
        while (iter1.hasNext()) {
            String str = iter1.next();
            Player player = getPlayerByName(str);
            player.setCurrentField(mechanicSpawn);
        }

        Iterator<String> iter2 = saboteurNameList.iterator();
        while (iter2.hasNext()) {
            String str = iter2.next();
            Player player = getPlayerByName(str);
            player.setCurrentField(saboteurSpawn);
        }

        activePlayer = players.get(0);
    }

    public void step() {
        --roundsLeft;
        nextPlayer();
        desert.step();
    }
}