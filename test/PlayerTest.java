import java.awt.print.PrinterIOException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void redirectPump() {
        Pump p = new Pump();
        Mechanic m = new Mechanic();
        m.setCurrentField(p);
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        m.redirectPump(p1,p2);
        assertTrue(p.getInputPipe() == p1 && p.getOutputPipe() == p2);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Pump p = new Pump();
        Mechanic m = new Mechanic();
        Pipe pi =  new Pipe();
        m.setCurrentField(pi);
        pi.addNeighbour(p);
        m.move(p);
        assertTrue(m.currentField == p);
    }


    @org.junit.jupiter.api.Test
    void puncture() {
        Mechanic m = new Mechanic();
        Pipe pi =  new Pipe();
        m.setCurrentField(pi);
        m.puncture();
        assertTrue(pi.isPunctured());
    }

    @org.junit.jupiter.api.Test
    void makeSticky() {
        Mechanic m = new Mechanic();
        Pipe pi =  new Pipe();
        m.setCurrentField(pi);
        m.makeSticky();
        assertTrue(pi.isSticky());
    }
}