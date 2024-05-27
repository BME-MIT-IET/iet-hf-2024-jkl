import static org.junit.jupiter.api.Assertions.*;

class PumpTest {

    @org.junit.jupiter.api.Test
    void redirect() {
        Pump p = new Pump();
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        p.redirect(p1,p2);
        assertTrue(p.getInputPipe()== p1 && p.getOutputPipe()==p2);
    }

    @org.junit.jupiter.api.Test
    void givePoints() {
        Pump p = new Pump();
        PointCounter po = new PointCounter();
        p.givePoints(po);
        //Mit kene itt tesztelni?
    }
}