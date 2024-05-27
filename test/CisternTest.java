import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CisternTest {

    @org.junit.jupiter.api.Test
    void givePoints() {
        PointCounter p = new PointCounter();
        Cistern c = new Cistern();
        c.addWater();
        c.givePoints(p);
        assertEquals(p.getMechanicPoints(), 1);
    }


    @org.junit.jupiter.api.Test
    void givePump() {
        Mechanic m = new Mechanic();
        Cistern c = new Cistern();
        c.givePump(m);
        assertNotNull(m.getPickedUpPump());
    }

}