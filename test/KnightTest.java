import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private Table t;
    public Knight k;

    @BeforeEach
    void setUp() {
        t = new Table();
        k = new Knight(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(k);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void KnightStepsTest() {
        ArrayList<Coordinate> steps = k.steps;
        assertEquals(k.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();

        //Knight step options on empty board
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(5, 6));
        expectedSteps.add(new Coordinate(2, 3));
        expectedSteps.add(new Coordinate(3, 2));
        expectedSteps.add(new Coordinate(6, 3));
        expectedSteps.add(new Coordinate(3, 6));
        expectedSteps.add(new Coordinate(5, 2));
        expectedSteps.add(new Coordinate(2, 5));
        boolean allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Knight step options on empty board after a step
        k.step(new Coordinate(6, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(5, 3));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(5, 7));
        expectedSteps.add(new Coordinate(7, 3));
        expectedSteps.add(new Coordinate(4, 6));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Knight step options when there is a piece in the way from the same color
        ChessPiece p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
        k.step(new Coordinate(8, 6), t.getPieces());
        k.step(new Coordinate(6, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(5, 3));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(5, 7));
        expectedSteps.add(new Coordinate(7, 3));
        expectedSteps.add(new Coordinate(4, 6));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Knight step options when there is a piece in the way from the opposing color
        p.col = ChessPieceColor.black;
        //p.step(new Coordinate(4, 4), t.getPieces());
        k.step(new Coordinate(8, 7), t.getPieces());
        k.step(new Coordinate(6, 5), t.getPieces());
        steps = k.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(5, 3));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(5, 7));
        expectedSteps.add(new Coordinate(7, 3));
        expectedSteps.add(new Coordinate(4, 6));
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
    void KnightColorTest() {
        //Knight color when it is white
        assertTrue(k.isWhiteKnight());

        //Knight color when it is black
        k.col = ChessPieceColor.black;
        assertTrue(k.isBlackKnight());
    }
}