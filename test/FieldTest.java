import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @org.junit.jupiter.api.Test
    void addNeighbour() {
        Pipe p = new Pipe();
        Pump pu = new Pump();
        p.addNeighbour(pu);
        assertFalse(p.neighbours.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void removeNeighbour() {
        Pipe p = new Pipe();
        Pump pu = new Pump();
        p.addNeighbour(pu);
        p.removeNeighbour(pu);
        assertTrue(p.neighbours.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addWater() {
        Cistern c =new Cistern();
        c.addWater();
        assertEquals(c.waterCount, 1);
    }

    @org.junit.jupiter.api.Test
    void removeWater() {
        Cistern c =new Cistern();
        c.addWater();
        c.removeWater();
        assertEquals(c.waterCount, 0);
    }
}