public class RandomToggle {
    private static boolean turnedOn = true;

    public static boolean isTurnedOn() {
        return turnedOn;
    }

    public static void setTurnedOn(boolean turnedOn) {
        RandomToggle.turnedOn = turnedOn;
    }
}
