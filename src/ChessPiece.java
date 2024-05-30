import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;
import java.util.ArrayList;

enum ChessPieceColor {
	white,
	black;
}
/**
 * 
 * @author vassp
 *
 */
public abstract class ChessPiece implements Serializable {
	/**
	 * sakkbábu pozíciója
	 */
	protected Coordinate coord;
	/**
	 * sakkbábu színe
	 */
	protected ChessPieceColor col;
	/**
	 * a pozíciók tömbje, ahova léphet a bábu
	 */
	protected ArrayList<Coordinate> steps;
	/**
	 * visszaadja a pozíciót
	 * @return pozíció
	 */
	public Coordinate getPosition() {
		return coord;
	}
	/**
	 * beállítja a pozíciót
	 * @param coord sakkbábu pozíciója
	 */
	public void setPosition(Coordinate coord) {
		this.coord = coord;
	}
	/**
	 * lépteti a bábut
	 * @param coord sakkbábu pozíciója
	 * @param pieces sakkbábuk tömbje
	 */
	public void step(Coordinate coord, ChessPieceArray pieces) {
		if (pieces.hasChessPieceAt(coord)) {
			pieces.remove(pieces.getChessPieceAt(coord));
		}
		this.coord = coord;
		pieces = pieces.setSteps();
	}
	/**
	 * beállítja az aktuális állás alapján a léphető mezőket
	 * @param pieces sakkbábuk tömbje
	 * @return léphető mezők tömbje
	 */
	public ArrayList<Coordinate> setSteps(ChessPieceArray pieces) {
		this.initializeSteps(pieces);
		return this.filterSteps(pieces);
	}
	/**
	 * első körben kiszámolja a léphető mezőket
	 * @param pieces sakkbábuk tömbje
	 */
	public abstract void initializeSteps(ChessPieceArray pieces);
	/**
	 * második körben kiszámolja a léphető mezőket
	 * @param pieces sakkbábuk tömbje
	 * @return léphető mezők tömbje
	 */
	public ArrayList<Coordinate> filterSteps(ChessPieceArray pieces) {
		ArrayList<Coordinate> filteredSteps = new ArrayList<Coordinate>();
		if (col == ChessPieceColor.white) {
			for (int i = 0; i < steps.size(); ++i) {
				Coordinate position = new Coordinate(coord.getHor(), coord.getVert());
				if (pieces.hasChessPieceAt(steps.get(i))) {
					if (pieces.getChessPieceAt(steps.get(i)).getSteps().contains(pieces.getWhiteKingPosition())) {
						for (int j = 0; j < pieces.size(); ++j) {
							if (pieces.get(j).getColor() == ChessPieceColor.black && pieces.get(j).getSteps().contains(steps.get(i))) {
								filteredSteps.add(steps.get(i));
							}
						}
					}
				} else {
				this.setPosition(steps.get(i));
				pieces.initializeSteps();
				if (pieces.whiteKingIsInCheck()) {
					Coordinate temp = new Coordinate(coord.getHor(), coord.getVert());
					filteredSteps.add(temp);
				}
				coord.setHor(position.getHor());
				coord.setVert(position.getVert());
				pieces.initializeSteps();
				}
			}
		} else {
			for (int i = 0; i < steps.size(); ++i) {
				Coordinate position = new Coordinate(coord.getHor(), coord.getVert());
				if (pieces.hasChessPieceAt(steps.get(i))) {
					if (pieces.getChessPieceAt(steps.get(i)).getSteps().contains(pieces.getBlackKingPosition())) {
						for (int j = 0; j < pieces.size(); ++j) {
							if (pieces.get(j).getColor() == ChessPieceColor.white && pieces.get(j).getSteps().contains(steps.get(i))) {
								filteredSteps.add(steps.get(i));
							}
						}
					}
				} else {
					this.setPosition(steps.get(i));
					pieces.initializeSteps();
					if (pieces.blackKingIsInCheck()) {
						Coordinate temp = new Coordinate(coord.getHor(), coord.getVert());
						filteredSteps.add(temp);
					}
					coord.setHor(position.getHor());
					coord.setVert(position.getVert());
					pieces.initializeSteps();
				}
			}
		}
		ArrayList<Coordinate> newSteps = new ArrayList<Coordinate>();
		for (int i = 0; i < steps.size(); ++i) {
			if (!(filteredSteps.contains(steps.get(i)))) {
				newSteps.add(steps.get(i));
			}
		}
		return newSteps;
	}
	/**
	 * átírja a léphető mezők tömbjét 
	 * @param steps léphető mezők tömbje
	 */
	public void overwriteSteps(ArrayList<Coordinate> steps) {
		this.steps = steps;
	}
	/**
	 * deep copy-hoz lemásolja a bábut és a másolatot visszaadja
	 * @return másolat
	 */
	public ChessPiece copy() {
		try {
			ChessPiece cp = (ChessPiece)this.clone();
			cp.setPosition(this.getPosition().copy());
			ArrayList<Coordinate> c = new ArrayList<Coordinate>();
			for (int i = 0; i < this.getSteps().size(); ++i)  {
				c.add(this.getSteps().get(i).copy());
			}
			cp.steps = c;
			return cp;
		} catch (CloneNotSupportedException cnse) {
			
		}
		return null;
	}
	/**
	 * visszaadja a léphető mezők tömbjét
	 * @return léphető mezők tömbje
	 */
	public ArrayList<Coordinate> getSteps() {
		return steps;
	}
	/**
	 * sakkban van-e a bábi
	 * @param pieces sakkbábuk tömbje
	 * @return igazságérték
	 */
	public boolean itIsInCheck(ChessPieceArray pieces) {
		return false;
	}
	/**
	 * sakkmattban van-e a bábi
	 * @param pieces sakkbábuk tömbje
	 * @return igazságérték
	 */
	public boolean itIsInCheckMate(ChessPieceArray pieces) {
		return false;
	}
	/**
	 * le lett-e ütve
	 * @param pieces sakkbábuk tömbje
	 * @return igazságérték
	 */
	public boolean gotHit(ChessPieceArray pieces) {
		for (int i = 0; i < pieces.size(); ++i) {
			if (pieces.get(i).getPosition().equals(coord)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * visszaadja a színt
	 * @return szín
	 */
	public ChessPieceColor getColor() {
		return col;
	}
	/**
	 * fehér paraszt-e
	 * @return igazságérték
	 */
	public boolean isWhitePawn() {
		return false;
	}
	/**
	 * fehér bástya-e
	 * @return igazságérték
	 */
	public boolean isWhiteRook() {
		return false;
	}
	/**
	 * fehér huszár-e
	 * @return igazságérték
	 */
	public boolean isWhiteKnight() {
		return false;
	}
	/**
	 * fehér futár-e
	 * @return igazságérték
	 */
	public boolean isWhiteBishop() {
		return false;
	}
	/**
	 * fehér királynő-e
	 * @return igazságérték
	 */
	public boolean isWhiteQueen() {
		return false;
	}
	/**
	 * fehér király-e
	 * @return igazságérték
	 */
	public boolean isWhiteKing() {
		return false;
	}
	/**
	 * fekete paraszt-e
	 * @return igazságérték
	 */
	public boolean isBlackPawn() {
		return false;
	}
	/**
	 * fekete bástya-e
	 * @return igazságérték
	 */
	public boolean isBlackRook() {
		return false;
	}
	/**
	 * fekete huszár-e
	 * @return igazságérték
	 */
	public boolean isBlackKnight() {
		return false;
	}
	/**
	 * fekete futár-e
	 * @return igazságérték
	 */
	public boolean isBlackBishop() {
		return false;
	}
	/**
	 * fekete királynő-e
	 * @return igazságérték
	 */
	public boolean isBlackQueen() {
		return false;
	}
	/**
	 * fekete király-e
	 * @return igazságérték
	 */
	public boolean isBlackKing() {
		return false;
	}
	/**
	 * fejlesztéshez segít, konzolra írja a pozíciót
	 */
	public void display() {
		System.out.print("Position: ");
		coord.display();
		System.out.println("Color: " + col.toString());
		System.out.print("Steps: ");
		for (int i = 0; i < steps.size(); ++i) {
			steps.get(i).display();
		}
		System.out.println("");
	}
}