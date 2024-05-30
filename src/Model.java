import java.util.ArrayList;
import java.io.Serializable;
import java.util.Random;

/**
 * 
 * @author vassp
 *
 */
enum GameMode {
	singlePlayer,
	multiPlayer;
}

enum ActivePlayer {
	white,
	black;
}
/**
 * 
 * @author vassp
 *
 */
public class Model implements Serializable {
	/**
	 * sakktábla
	 */
	private Table t;
	/**
	 * játékmód
	 */
	private GameMode gm;
	/**
	 * éppen aktív játékos
	 */
	private ActivePlayer ap;
	/**
	 * konstruktor
	 */
	public Model() {
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
		
		gm = GameMode.multiPlayer;
		ap = ActivePlayer.white;
	}
	/**
	 * visszaadja a fehér parasztok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhitePawnPositions() {
		return t.getWhitePawnPositions();
	}
	/**
	 * visszaadja a fehér bástyák pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteRookPositions() {
		return t.getWhiteRookPositions();
	}
	/**
	 * visszaadja a fehér huszárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteKnightPositions() {
		return t.getWhiteKnightPositions();
	}
	/**
	 * visszaadja a fehér futárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteBishopPositions() {
		return t.getWhiteBishopPositions();
	}
	/**
	 * visszaadja a fehér királynő pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteQueenPositions() {
		return t.getWhiteQueenPositions();
	}
	/**
	 * visszaadja a fehér király pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteKingPositions() {
		return t.getWhiteKingPositions();
	}
	/**
	 * visszaadja a fekete parasztok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackPawnPositions() {
		return t.getBlackPawnPositions();
	}
	/**
	 * visszaadja a fekete bástyák pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackRookPositions() {
		return t.getBlackRookPositions();
	}
	/**
	 * visszaadja a fekete huszárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackKnightPositions() {
		return t.getBlackKnightPositions();
	}
	/**
	 * visszaadja a fekete futárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackBishopPositions() {
		return t.getBlackBishopPositions();
	}
	/**
	 * visszaadja a fekete királynők pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackQueenPositions() {
		return t.getBlackQueenPositions();
	}
	/**
	 * visszaadja a fekete királyok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackKingPositions() {
		return t.getBlackKingPositions();
	}
	/**
	 * visszaadja a sakktáblát
	 * @return sakktábla
	 */
	public Table getTable() {
		return t;
	}
	/**
	 * beállítja a játékmódot
	 * @param gm játékmód
	 */
	public void setGameMode(GameMode gm) {
		this.gm = gm;
	}
	/**
	 * visszaadja a játékmódot
	 * @return játékmód
	 */
	public GameMode getGameMode() {
		return gm;
	}
	/**
	 * beállítja az éppen aktív játékost
	 * @param ap aktív játékos
	 */
	public void setActivePlayer(ActivePlayer ap) {
		this.ap = ap;
	}
	/**
	 * visszaadja az éppen aktív játékost
	 * @return aktív játékos
	 */
	public ActivePlayer getActivePlayer() {
		return ap;
	}
	/**
	 * program lépést végez
	 */
	public void AIStep() {
		ChessPieceArray blackPieces = t.getBlackPieces();
		Random r = new Random();
		if (blackPieces.size() > 0) {
			int cp;
			do {
				cp = r.nextInt(blackPieces.size());
			} while (blackPieces.get(cp).getSteps().size() == 0);
			int step = r.nextInt(blackPieces.get(cp).getSteps().size());
			t.step(blackPieces.get(cp), blackPieces.get(cp).getSteps().get(step));
		}
	}
}

