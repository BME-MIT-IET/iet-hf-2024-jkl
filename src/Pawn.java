import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * 
 * @author vassp
 *
 */
public class Pawn extends ChessPiece implements Serializable {
	/**
	 * konstruktor
	 * @param coord pozíció
	 * @param col szín
	 * @param pieces sakkbábutömb
	 */
	public Pawn(Coordinate coord, ChessPieceColor col, ChessPieceArray pieces) {
		this.coord = coord;
		this.col = col;
		steps = new ArrayList<Coordinate>();
		setSteps(pieces);
	}
	/**
	 * elsőkörben kiszámolja a léphető mezőket
	 * @param pieces sakkbábutömb
	 */
	public void initializeSteps(ChessPieceArray pieces) {
		steps.clear();
		
		if (col == ChessPieceColor.white) {
			if (coord.getVert() == 7) {
				steps.add(new Coordinate(coord.getHor(), coord.getVert() - 2));
			}
			if (coord.getVert() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() - 1));
				}
				if (pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 1))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 1));
				}
				if (pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 1))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 1));
				}
			}
		} else {
			if (coord.getVert() == 2) {
				steps.add(new Coordinate(coord.getHor(), coord.getVert() + 2));
			}
			if (coord.getVert() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() + 1));
				}
				if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 1))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 1));
				}
				if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 1))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 1));
				}
			}
		}
	}
	/**
	 * fehér paraszt-e
	 * @return igazságérték
	 */
	public boolean isWhitePawn() {
		if (col == ChessPieceColor.white) {
			return true;
		}
		return false;
	}
	/**
	 * fekete paraszt-e
	 * @return igazságérték
	 */
	public boolean isBlackPawn() {
		if (col == ChessPieceColor.black) {
			return true;
		}
		return false;
	}
}