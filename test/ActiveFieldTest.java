/*
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiveFieldTest {
    private Mechanic m = new Mechanic();
    private Pump p = new Pump();
    private Pipe curr = new Pipe();

    @BeforeEach
    void setUp() {
        m.currentField = curr;
        curr.addNeighbour(p);
        p.addNeighbour(curr);
    }

    @org.junit.jupiter.api.Test
    void accept() {
        assertTrue(p.accept(m));
    }

    @org.junit.jupiter.api.Test
    void accept_sticky() {
        curr.makeSticky();
        assertFalse(p.accept(m));
    }

    @Test
    void empty() {
        m.move(p);
        assertTrue(curr.players.isEmpty());
    }


}
*/