public abstract class ActiveField extends Field {

    /**
     * Always accepts the player, since a player can always step on an ActiveField.
     * Player p is added to the players Array of this field.
     * @param p     The player that moves to this field
     * @return      Always returns true
     */
    public boolean accept(Player p) {
        if (p.currentField != null && p.currentField.isSticky() && !p.currentField.stickyImmunity) {
            return false;
        }

        players.add(p);
        //System.out.println("\"ActiveField.accept\" function called");
        return true;
    }

    /**
     * Removes the given player from this field's players array
     * @param p Player to be removed
     */
    public void remove(Player p) {
        players.remove(p);
        //System.out.println("\"ActiveField.remove\" function called");
    }
}
