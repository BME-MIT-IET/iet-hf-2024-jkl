import static org.junit.jupiter.api.Assertions.*;

class PipeTest {

    @org.junit.jupiter.api.Test
    void puncture() {
        Pipe p = new Pipe();
        p.setTimeCannotBePunctured(0);
        p.puncture();
        assertTrue(p.isPunctured());
    }
    @org.junit.jupiter.api.Test
    void acceptoccupied() {
        Pipe p = new Pipe();
        Mechanic m = new Mechanic();
        p.setOccupied(true);
        assertFalse(p.accept(m));
    }

    @org.junit.jupiter.api.Test
    void accept() {
        Pipe p = new Pipe();
        Mechanic m = new Mechanic();
        assertTrue(p.accept(m));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Pipe p = new Pipe();
        Mechanic m = new Mechanic();
        p.accept(m);
        p.remove(m);
        assertTrue(p.players.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void givePoints() {
        PointCounter p = new PointCounter();
        Pipe pe = new Pipe();
        pe.puncture();
        pe.addWater();
        pe.givePoints(p);
        assertFalse(p.getSaboteurPoints() == 0);
    }

    @org.junit.jupiter.api.Test
    void cutAndPlace() {
        //Meg nincs kesz
    }

}