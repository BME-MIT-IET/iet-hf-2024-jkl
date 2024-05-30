import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Table t;
    public Bishop b;

    @BeforeEach
    void setUp() {
        t = new Table();
        b = new Bishop(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(b);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void BishopStepsTest() {
        ArrayList<Coordinate> steps = b.steps;
        assertEquals(b.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();
        /*
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(5, 6));
        expectedSteps.add(new Coordinate(2, 3));
        expectedSteps.add(new Coordinate(3, 2));
        expectedSteps.add(new Coordinate(6, 3));
        expectedSteps.add(new Coordinate(3, 6));
        expectedSteps.add(new Coordinate(5, 2));
        expectedSteps.add(new Coordinate(2, 5));
        */
        //assertTrue(steps.containsAll(expectedSteps));

        //Bishop step options on empty board
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(8, 8));
        expectedSteps.add(new Coordinate(3, 3));
        expectedSteps.add(new Coordinate(2, 2));
        expectedSteps.add(new Coordinate(1, 1));
        expectedSteps.add(new Coordinate(5, 3));
        expectedSteps.add(new Coordinate(6, 2));
        expectedSteps.add(new Coordinate(7, 1));
        expectedSteps.add(new Coordinate(3, 5));
        expectedSteps.add(new Coordinate(2, 6));
        expectedSteps.add(new Coordinate(1, 7));
        boolean allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Bishop step options on empty board after a step
        b.step(new Coordinate(8, 8), t.getPieces());
        steps = b.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(3, 3));
        expectedSteps.add(new Coordinate(2, 2));
        expectedSteps.add(new Coordinate(1, 1));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Bishop step options when there is a piece in the way from the same color
        ChessPiece p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
        b.step(new Coordinate(7, 7), t.getPieces());
        steps = b.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(8, 8));
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(6, 8));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Bishop step options when there is a piece in the way from the opposing color
        p.col = ChessPieceColor.black;
        b.step(new Coordinate(8, 8), t.getPieces());
        steps = b.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(4, 4));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

    }

    @Test
    void BishopColorTest() {
        //Bishop color when it is white
        assertTrue(b.isWhiteBishop());

        //Bishop color when it is black
        b.col = ChessPieceColor.black;
        assertTrue(b.isBlackBishop());
    }
}