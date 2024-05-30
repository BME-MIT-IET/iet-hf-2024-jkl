import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    private Table t;
    public Queen q;

    @BeforeEach
    void setUp() {
        t = new Table();
        q = new Queen(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(q);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void QueenStepsTest() {
        ArrayList<Coordinate> steps = q.steps;
        assertEquals(q.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();

        //Queen step options on empty board
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

        //Queen step options on empty board after a step
        q.step(new Coordinate(8, 8), t.getPieces());
        steps = q.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(3, 3));
        expectedSteps.add(new Coordinate(2, 2));
        expectedSteps.add(new Coordinate(1, 1));
        expectedSteps.add(new Coordinate(8, 7));
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(8, 5));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(8, 3));
        expectedSteps.add(new Coordinate(8, 2));
        expectedSteps.add(new Coordinate(8, 1));
        expectedSteps.add(new Coordinate(7, 8));
        expectedSteps.add(new Coordinate(6, 8));
        expectedSteps.add(new Coordinate(5, 8));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 8));
        expectedSteps.add(new Coordinate(2, 8));
        expectedSteps.add(new Coordinate(1, 8));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Queen step options when there is a piece in the way from the same color
        ChessPiece p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
        q.step(new Coordinate(8, 7), t.getPieces());
        q.step(new Coordinate(8, 8), t.getPieces());
        steps = q.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(8, 7));
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(8, 5));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(8, 3));
        expectedSteps.add(new Coordinate(8, 2));
        expectedSteps.add(new Coordinate(8, 1));
        expectedSteps.add(new Coordinate(7, 8));
        expectedSteps.add(new Coordinate(6, 8));
        expectedSteps.add(new Coordinate(5, 8));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 8));
        expectedSteps.add(new Coordinate(2, 8));
        expectedSteps.add(new Coordinate(1, 8));
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
        q.step(new Coordinate(8, 7), t.getPieces());
        q.step(new Coordinate(8, 8), t.getPieces());
        steps = q.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(7, 7));
        expectedSteps.add(new Coordinate(6, 6));
        expectedSteps.add(new Coordinate(5, 5));
        expectedSteps.add(new Coordinate(4, 4));
        expectedSteps.add(new Coordinate(8, 7));
        expectedSteps.add(new Coordinate(8, 6));
        expectedSteps.add(new Coordinate(8, 5));
        expectedSteps.add(new Coordinate(8, 4));
        expectedSteps.add(new Coordinate(8, 3));
        expectedSteps.add(new Coordinate(8, 2));
        expectedSteps.add(new Coordinate(8, 1));
        expectedSteps.add(new Coordinate(7, 8));
        expectedSteps.add(new Coordinate(6, 8));
        expectedSteps.add(new Coordinate(5, 8));
        expectedSteps.add(new Coordinate(4, 8));
        expectedSteps.add(new Coordinate(3, 8));
        expectedSteps.add(new Coordinate(2, 8));
        expectedSteps.add(new Coordinate(1, 8));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));
    }
}