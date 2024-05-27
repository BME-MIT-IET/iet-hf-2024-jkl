public class PlayerDescription {
    private final PlayerType type;

    private final String name;
    private final String standingOnName;
    private final String holdingPipeName;

    public PlayerDescription(PlayerType type, String name, String standingOnName, String holdingPipeName) {
        this.type = type;
        this.name = name;
        this.standingOnName = standingOnName;
        this.holdingPipeName = holdingPipeName;
    }

    public PlayerType getType() { return type; }
    public String getName() { return name; }
    public String getStandingOnName() { return standingOnName; }
    public String getHoldingPipeName() { return holdingPipeName; }
}
