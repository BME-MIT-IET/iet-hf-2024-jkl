import java.awt.Color;
import java.io.*;
import java.util.*;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * 
 * @author vassp
 *
 */
public class Table implements Serializable {
	/**
	 * sakkbábuk tömbje
	 */
	private ChessPieceArray pieces;
	/**
	 * konstruktor
	 */
	public Table() {
		pieces = new ChessPieceArray();
	}
	/**
	 * hozzáad egy bábut a sakkbábukhoz
	 * @param cp sakkbábu
	 */
	public void add(ChessPiece cp) {
		pieces.add(cp);
		pieces = pieces.setSteps();
		//pieces.checkSteps();
	}
	/**
	 * eltávolít egy bábut a tömbből
	 * @param cp sakkbábu
	 */
	public void remove(ChessPiece cp) {
		pieces.remove(cp);
		pieces = pieces.setSteps();
	}
	/**
	 * lépteti a sakkbábut
	 * @param cp sakkbábu
	 * @param coord pozíció
	 */
	public void step(ChessPiece cp, Coordinate coord) {
		cp.step(coord, pieces);
	}
	/**
	 * eltávolítja a kiütött bábut
	 * @param cp sakkbábu
	 */
	public void removeHit(ChessPiece cp) {
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).getPosition().equals(cp.getPosition()) && pieces.get(i) != cp) {
				remove(pieces.getChessPieceAt(cp.getPosition()));
			}
		}
	}
	/**
	 * visszaadja a sakkbábuk tömbjét
	 * @return sakkbábutömb
	 */
	public ChessPieceArray getPieces() {
		return pieces;
	}
	/**
	 * visszaadja a fehér sakkbábukat
	 * @return sakkbábutömb
	 */
	public ChessPieceArray getWhitePieces() {
		ChessPieceArray whitePieces = new ChessPieceArray();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).getColor() == ChessPieceColor.white) {
				whitePieces.add(pieces.get(i));
			}
		}
		return whitePieces;
	}
	/**
	 * visszaadja a fekete sakkbábukat
	 * @return sakkbábutömb
	 */
	public ChessPieceArray getBlackPieces() {
		ChessPieceArray blackPieces = new ChessPieceArray();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).getColor() == ChessPieceColor.black) {
				blackPieces.add(pieces.get(i));
			}
		}
		return blackPieces;
	}
	/**
	 * ellenőrzi, hogy van-e sakkmatt
	 * @return igazságérték
	 */
	public boolean checkCheckMate() {
		return pieces.checkCheckMate();
	}
	/**
	 * király sakkban van-e
	 * @return igazságérték
	 */
	public boolean kingIsInCheck() {
		return pieces.kingIsInCheck();
	}
	/**
	 * király sakkmattban van-e
	 * @return igazságérték
	 */
	public boolean kingIsInCheckMate() {
		return pieces.kingIsInCheckMate();
	}
	/**
	 * visszaadja a fehér parasztor pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhitePawnPositions() {
		ArrayList<Coordinate> whitepawns = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhitePawn()) {
				whitepawns.add(pieces.get(i).getPosition());
			}
		}
		return whitepawns;
	}
	/**
	 * visszaadja a fehér bástyák pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteRookPositions() {
		ArrayList<Coordinate> whiterooks = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhiteRook()) {
				whiterooks.add(pieces.get(i).getPosition());
			}
		}
		return whiterooks;
	}
	/**
	 * visszaadja a fehér huszárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteKnightPositions() {
		ArrayList<Coordinate> whiteknights = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhiteKnight()) {
				whiteknights.add(pieces.get(i).getPosition());
			}
		}
		return whiteknights;
	}
	/**
	 * visszaadja a fehér futárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteBishopPositions() {
		ArrayList<Coordinate> whitebishops = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhiteBishop()) {
				whitebishops.add(pieces.get(i).getPosition());
			}
		}
		return whitebishops;
	}
	/**
	 * visszaadja a fehér királynők pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteQueenPositions() {
		ArrayList<Coordinate> whitequeens = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhiteQueen()) {
				whitequeens.add(pieces.get(i).getPosition());
			}
		}
		return whitequeens;
	}
	/**
	 * visszaadja a fehér királyok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getWhiteKingPositions() {
		ArrayList<Coordinate> whitekings = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isWhiteKing()) {
				whitekings.add(pieces.get(i).getPosition());
			}
		}
		return whitekings;
	}
	/**
	 * visszaadja a fekete parasztor pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackPawnPositions() {
		ArrayList<Coordinate> blackpawns = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackPawn()) {
				blackpawns.add(pieces.get(i).getPosition());
			}
		}
		return blackpawns;

	}
	/**
	 * visszaadja a fekete bástyák pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackRookPositions() {
		ArrayList<Coordinate> blackrooks = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackRook()) {
				blackrooks.add(pieces.get(i).getPosition());
			}
		}
		return blackrooks;

	}
	/**
	 * visszaadja a fekete huszárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackKnightPositions() {
		ArrayList<Coordinate> blackknights = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackKnight()) {
				blackknights.add(pieces.get(i).getPosition());
			}
		}
		return blackknights;

	}
	/**
	 * visszaadja a fekete futárok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackBishopPositions() {
		ArrayList<Coordinate> blackbishops = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackBishop()) {
				blackbishops.add(pieces.get(i).getPosition());
			}
		}
		return blackbishops;

	}
	/**
	 * visszaadja a fekete királynők pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackQueenPositions() {
		ArrayList<Coordinate> blackqueens = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackQueen()) {
				blackqueens.add(pieces.get(i).getPosition());
			}
		}
		return blackqueens;

	}
	/**
	 * visszaadja a fekete királyok pozícióját
	 * @return koordináták tömbje
	 */
	public ArrayList<Coordinate> getBlackKingPositions() {
		ArrayList<Coordinate> blackkings = new ArrayList<Coordinate>();
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).isBlackKing()) {
				blackkings.add(pieces.get(i).getPosition());
			}
		}
		return blackkings;

	}
}