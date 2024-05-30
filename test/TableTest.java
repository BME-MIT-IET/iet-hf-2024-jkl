import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    private Table t;

    @BeforeEach
    void setUp() {
        t = new Table();

        t.add(new Pawn(new Coordinate(1, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(2, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(3, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(4, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(5, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(6, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(7, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Pawn(new Coordinate(8, 7), ChessPieceColor.white, t.getPieces()));
        t.add(new Rook(new Coordinate(1, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Rook(new Coordinate(8, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Knight(new Coordinate(2, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Knight(new Coordinate(7, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Bishop(new Coordinate(3, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Bishop(new Coordinate(6, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new Queen(new Coordinate(4, 8), ChessPieceColor.white, t.getPieces()));
        t.add(new King(new Coordinate(5, 8), ChessPieceColor.white, t.getPieces()));

        t.add(new Pawn(new Coordinate(1, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(2, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(3, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(4, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(5, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(6, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(7, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Pawn(new Coordinate(8, 2), ChessPieceColor.black, t.getPieces()));
        t.add(new Rook(new Coordinate(1, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Rook(new Coordinate(8, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Knight(new Coordinate(2, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Knight(new Coordinate(7, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Bishop(new Coordinate(3, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Bishop(new Coordinate(6, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new Queen(new Coordinate(4, 1), ChessPieceColor.black, t.getPieces()));
        t.add(new King(new Coordinate(5, 1), ChessPieceColor.black, t.getPieces()));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void GameplayTest() {
        //Check number of pieces
        assertEquals(t.getPieces().size(), 32);

        //Check WhitePawn positions
        ArrayList<Coordinate> steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(1, 7));
        steps.add(new Coordinate(2, 7));
        steps.add(new Coordinate(3, 7));
        steps.add(new Coordinate(4, 7));
        steps.add(new Coordinate(5, 7));
        steps.add(new Coordinate(6, 7));
        steps.add(new Coordinate(7, 7));
        steps.add(new Coordinate(8, 7));
        boolean allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhitePawnPositions().size() && steps.containsAll(t.getWhitePawnPositions()));

        //Check WhiteRook positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(1, 8));
        steps.add(new Coordinate(8, 8));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhiteRookPositions().size() && steps.containsAll(t.getWhiteRookPositions()));

        //Check WhiteKnight positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(2, 8));
        steps.add(new Coordinate(7, 8));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhiteKnightPositions().size() && steps.containsAll(t.getWhiteKnightPositions()));

        //Check WhiteBishop positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(3, 8));
        steps.add(new Coordinate(6, 8));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhiteBishopPositions().size() && steps.containsAll(t.getWhiteBishopPositions()));

        //Check WhiteQueen positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(4, 8));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhiteQueenPositions().size() && steps.containsAll(t.getWhiteQueenPositions()));

        //Check WhiteKing positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(5, 8));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getWhiteKingPositions().size() && steps.containsAll(t.getWhiteKingPositions()));

        //Check BlackPawn positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(1, 2));
        steps.add(new Coordinate(2, 2));
        steps.add(new Coordinate(3, 2));
        steps.add(new Coordinate(4, 2));
        steps.add(new Coordinate(5, 2));
        steps.add(new Coordinate(6, 2));
        steps.add(new Coordinate(7, 2));
        steps.add(new Coordinate(8, 2));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackPawnPositions().size() && steps.containsAll(t.getBlackPawnPositions()));

        //Check BlackRook positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(1, 1));
        steps.add(new Coordinate(8, 1));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackRookPositions().size() && steps.containsAll(t.getBlackRookPositions()));

        //Check BlackKnight positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(2, 1));
        steps.add(new Coordinate(7, 1));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackKnightPositions().size() && steps.containsAll(t.getBlackKnightPositions()));

        //Check BlackBishop positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(3, 1));
        steps.add(new Coordinate(6, 1));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackBishopPositions().size() && steps.containsAll(t.getBlackBishopPositions()));

        //Check BlackQueen positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(4, 1));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackQueenPositions().size() && steps.containsAll(t.getBlackQueenPositions()));

        //Check BlackKing positions
        steps = new ArrayList<Coordinate>();
        steps.add(new Coordinate(5, 1));
        allUnique = true;
        for (int i = 0; i < steps.size(); ++i) {
            for (int j = i + 1; j < steps.size(); ++j) {
                if (steps.get(i).equals(steps.get(j)))
                    allUnique = false;
            }
        }
        assertTrue(allUnique && steps.size() == t.getBlackKingPositions().size() && steps.containsAll(t.getBlackKingPositions()));

    }

    @Test
    void CheckMove() {
        Coordinate step = t.getPieces().get(0).getSteps().get(0);
        t.getPieces().get(0).step(t.getPieces().get(0).getSteps().get(0), t.getPieces());
        assertEquals(step, t.getPieces().get(0).getPosition());
    }
}