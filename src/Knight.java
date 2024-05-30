import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vassp
 *
 */
public class Knight extends ChessPiece implements Serializable {
	/**
	 * konstruktor
	 * @param coord pozíció
	 * @param col szín
	 * @param pieces sakkbábutömb
	 */
	public Knight(Coordinate coord, ChessPieceColor col, ChessPieceArray pieces) {
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
			//fel 2, jobbra 1
			if (coord.getHor() != 8 && coord.getVert() >= 3) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 2)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 2));
				}
			}
			//fel 1, jobbra 2
			if (coord.getHor() <= 6 && coord.getVert() != 1) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() + 2, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() + 2, coord.getVert() - 1));
				}
			}
			//le 2, jobbra 1
			if (coord.getHor() != 8 && coord.getVert() <= 6) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 2)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 2));
				}
			}
			//le 1, jobbra 2
			if (coord.getHor() <= 6 && coord.getVert() != 8) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() + 2, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() + 2, coord.getVert() + 1));
				}
			}
			//le 2, balra 1
			if (coord.getHor() != 1 && coord.getVert() <= 6) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 2)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 2));
				}
			}
			//le 1, balra 2
			if (coord.getHor() >= 3 && coord.getVert() != 8) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() - 2, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() - 2, coord.getVert() + 1));
				}
			}
			//fel 2, balra 1
			if (coord.getHor() != 1 && coord.getVert() >= 3) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 2)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 2));
				}
			}
			//fel 1, balra 2
			if (coord.getHor() >= 3 && coord.getVert() != 1) {
				if (!(pieces.hasWhiteAt(new Coordinate(coord.getHor() - 2, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() - 2, coord.getVert() - 1));
				}
			}
		} else {
			//fel 2, jobbra 1
			if (coord.getHor() != 8 && coord.getVert() >= 3) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 2)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 2));
				}
			}
			//fel 1, jobbra 2
			if (coord.getHor() <= 6 && coord.getVert() != 1) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() + 2, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() + 2, coord.getVert() - 1));
				}
			}
			//le 2, jobbra 1
			if (coord.getHor() != 8 && coord.getVert() <= 6) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 2)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 2));
				}
			}
			//le 1, jobbra 2
			if (coord.getHor() <= 6 && coord.getVert() != 8) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() + 2, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() + 2, coord.getVert() + 1));
				}
			}
			//le 2, balra 1
			if (coord.getHor() != 1 && coord.getVert() <= 6) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 2)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 2));
				}
			}
			//le 1, balra 2
			if (coord.getHor() >= 3 && coord.getVert() != 8) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() - 2, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() - 2, coord.getVert() + 1));
				}
			}
			//fel 2, balra 1
			if (coord.getHor() != 1 && coord.getVert() >= 3) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 2)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 2));
				}
			}
			//fel 1, balra 2
			if (coord.getHor() >= 3 && coord.getVert() != 1) {
				if (!(pieces.hasBlackAt(new Coordinate(coord.getHor() - 2, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() - 2, coord.getVert() - 1));
				}
			}
		}
	}
	/**
	 * fehér huszár-e
	 * @return igazságérték
	 */
	public boolean isWhiteKnight() {
		if (col == ChessPieceColor.white) {
			return true;
		}
		return false;
	}
	/**
	 * fekete huszár-e
	 * @return igazságérték
	 */
	public boolean isBlackKnight() {
		if (col == ChessPieceColor.black) {
			return true;
		}
		return false;
	}
}
