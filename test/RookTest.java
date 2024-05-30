import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Table t;
    public Rook r;

    @BeforeEach
    void setUp() {
        t = new Table();
        r = new Rook(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(r);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void RookStepsTest() {
        ArrayList<Coordinate> steps = r.steps;
        assertEquals(r.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();

        //Rook step options on empty board
        expectedSteps.add(new Coordinate(4, 3));
        expectedSteps.add(new Coordinate(4, 2));
        expectedSteps.add(new Coordinate(4, 1));
        expectedSteps.add(new Coordinate(4, 5));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(4, 7));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 4));
        expectedSteps.add(new Coordinate(2, 4));
        expectedSteps.add(new Coordinate(1, 4));
        expectedSteps.add(new Coordinate(5, 4));
        expectedSteps.add(new Coordinate(6, 4));
        expectedSteps.add(new Coordinate(7, 4));
        expectedSteps.add(new Coordinate(8, 4));
        boolean allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Rook step options on empty board after a step
        r.step(new Coordinate(4, 5), t.getPieces());
        steps = r.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(4, 3));
        expectedSteps.add(new Coordinate(4, 2));
        expectedSteps.add(new Coordinate(4, 1));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(4, 7));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 5));
        expectedSteps.add(new Coordinate(2, 5));
        expectedSteps.add(new Coordinate(1, 5));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(7, 5));
        expectedSteps.add(new Coordinate(8, 5));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Rook step options when there is a piece in the way from the same color
        ChessPiece p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
        r.step(new Coordinate(4, 3), t.getPieces());
        r.step(new Coordinate(4, 5), t.getPieces());
        steps = r.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(4, 7));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 5));
        expectedSteps.add(new Coordinate(2, 5));
        expectedSteps.add(new Coordinate(1, 5));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(7, 5));
        expectedSteps.add(new Coordinate(8, 5));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Rook step options when there is a piece in the way from the opposing color
        p.col = ChessPieceColor.black;
        //p.step(new Coordinate(4, 4), t.getPieces());
        r.step(new Coordinate(4, 3), t.getPieces());
        r.step(new Coordinate(4, 5), t.getPieces());
        steps = r.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(4, 6));
        expectedSteps.add(new Coordinate(4, 7));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 5));
        expectedSteps.add(new Coordinate(2, 5));
        expectedSteps.add(new Coordinate(1, 5));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(6, 5));
        expectedSteps.add(new Coordinate(7, 5));
        expectedSteps.add(new Coordinate(8, 5));
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
    void RookColorTest() {
        //Rook color when it is white
        assertTrue(r.isWhiteRook());

        //Rook color when it is black
        r.col = ChessPieceColor.black;
        assertTrue(r.isBlackRook());
    }
}