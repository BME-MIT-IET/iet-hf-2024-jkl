public class Saboteur extends Player {
    public Saboteur() {

    }
    public Saboteur(String name) {
        this.name = name;
    }
    public boolean makeSlippery() {
        this.currentField.makeSlippery();
        return true;
    }
}
