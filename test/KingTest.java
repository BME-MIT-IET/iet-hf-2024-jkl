import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    private Table t;
    public King k;

    @BeforeEach
    void setUp() {
        t = new Table();
        k = new King(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(k);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void KingStepsTest() {
        ArrayList<Coordinate> steps = k.steps;
        assertEquals(k.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();

        //King step options on empty board
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(3, 3));
        expectedSteps.add(new Coordinate(5, 3));
        expectedSteps.add(new Coordinate(3, 5));
        expectedSteps.add(new Coordinate(4, 5));
        expectedSteps.add(new Coordinate(5, 4));
        expectedSteps.add(new Coordinate(4, 3));
        expectedSteps.add(new Coordinate(3, 4));
        boolean allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //King step options on empty board after a step
        k.step(new Coordinate(5, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(6, 4));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(5, 6));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(5, 4));
        expectedSteps.add(new Coordinate(4, 5));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //King step options when there is a piece in the way from the same color
        ChessPiece p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
        k.step(new Coordinate(6, 6), t.getPieces());
        k.step(new Coordinate(5, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(6, 4));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(5, 6));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(5, 4));
        expectedSteps.add(new Coordinate(4, 5));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //King step options when there is a piece in the way from the opposing color
        p.col = ChessPieceColor.black;
        k.step(new Coordinate(6, 6), t.getPieces());
        k.step(new Coordinate(5, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(6, 4));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(5, 6));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(5, 4));
        expectedSteps.add(new Coordinate(4, 5));
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
    void KingColorTest() {
        //King color when it is white
        assertTrue(k.isWhiteKing());

        //King color when it is black
        k.col = ChessPieceColor.black;
        assertTrue(k.isBlackKing());
    }
}