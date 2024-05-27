import static org.junit.jupiter.api.Assertions.*;

class SaboteurTest {

    @org.junit.jupiter.api.Test
    void makeSlippery() {
        Saboteur s = new Saboteur();
        Pipe p = new Pipe();
        s.setCurrentField(p);
        s.makeSlippery();
        assertTrue(p.getTimeIsSlippery()==3);
    }
}