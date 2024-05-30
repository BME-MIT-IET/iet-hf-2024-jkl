import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private Table t;
    public Pawn p;

    @BeforeEach
    void setUp() {
        t = new Table();
        p = new Pawn(new Coordinate(4, 4), ChessPieceColor.white, t.getPieces());
        t.add(p);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void PawnStepsTest() {
        ArrayList<Coordinate> steps = p.steps;
        assertEquals(p.coord, new Coordinate(4, 4));
        for(int i = 0; i < steps.size(); ++i) {

        }
        ArrayList<Coordinate> expectedSteps = new ArrayList<Coordinate>();

        //Pawn step options on empty board
        expectedSteps.add(new Coordinate(4, 3));
        boolean allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Pawn step options on empty board after a step
        p.step(new Coordinate(4, 3), t.getPieces());
        steps = p.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 2));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Pawn step options when there is a piece in the way from the same color
        ChessPiece p1 = new Pawn(new Coordinate(3, 2), ChessPieceColor.white, t.getPieces());
        t.add(p1);
        p.step(new Coordinate(4, 3), t.getPieces());
        steps = p.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 2));
        allUniqe = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUniqe = false;
            }
        }
        assertTrue(allUniqe && steps.size() == expectedSteps.size() && steps.containsAll(expectedSteps));

        //Pawn step options when there is a piece in the way from the opposing color
        /*
        Pawn p2 = new Pawn(new Coordinate(5, 1), ChessPieceColor.black, t.getPieces());
        t.add(p2);
        for (int i = 0; i < p2.steps.size(); ++i) {
            p2.steps.get(i).display();
        }
        */
        t.remove(p1);
        Pawn p2 = new Pawn(new Coordinate(3, 2), ChessPieceColor.black, t.getPieces());
        t.add(p2);
        p.step(new Coordinate(4, 3), t.getPieces());
        steps = p.steps;
        expectedSteps.clear();
        expectedSteps.add(new Coordinate(4, 2));
        expectedSteps.add(new Coordinate(3, 2));
        steps.get(0).display();

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
    void PawnColorTest() {
        //Pawn color when it is white
        assertTrue(p.isWhitePawn());

        //Pawn color when it is black
        p.col = ChessPieceColor.black;
        assertTrue(p.isBlackPawn());
    }
}