/*
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MechanicTest {
    private Mechanic m = new Mechanic();
    private Pump p = new Pump();
    private Pipe curr = new Pipe();

    @BeforeEach
    void setUp() {
        m = new Mechanic();
        p = new Pump();
        curr = new Pipe();
        m.currentField = curr;
        curr.addNeighbour(p);
        p.addNeighbour(curr);
    }

    @org.junit.jupiter.api.Test
    void repair() {
        curr.puncture();
        m.repair();
        assertFalse(curr.isPunctured());
    }

    @org.junit.jupiter.api.Test
    void pickUpPipe() {
        m.move(p);
        m.pickUpPipe(curr);
        assertEquals(m.getPickedUpPipe(), curr);
        assertTrue(p.neighbours.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void pickUpPump() {
        Cistern c = new Cistern();
        m.currentField = c;
        m.pickUpPump();
        assertNotNull(m.getPickedUpPump());
    }

    @org.junit.jupiter.api.Test
    void placePipe() {
        m.move(p);
        m.pickUpPipe(curr);
        m.placePipe();
        assertNull(m.getPickedUpPipe());
        m.move(curr);
        assertEquals(m.currentField, curr);
    }

    @org.junit.jupiter.api.Test
    void placePump() {
        m.addPump(new Pump());
        m.placePump();
        assertNull(m.getPickedUpPump());
    }

    @org.junit.jupiter.api.Test
    void addPump() {
        Pump pu = new Pump();
        m.addPump(pu);
        assertEquals(m.getPickedUpPump(), pu);
    }

    @org.junit.jupiter.api.Test
    void addPipe() {
        Pipe pi = new Pipe();
        m.addPipe(pi);
        assertEquals(m.getPickedUpPipe(), pi);
    }
}

 */