import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author vassp
 *
 */
public class Bishop extends ChessPiece implements Serializable {
	/**
	 * konstruktor parasztokhoz
	 * @param coord sakkbábu pozíciója
	 * @param col sakkbábu színe
	 * @param pieces sakkbábuk töbje
	 */
	public Bishop(Coordinate coord, ChessPieceColor col, ChessPieceArray pieces) {
		this.coord = coord;
		this.col = col;
		steps = new ArrayList<Coordinate>();
		setSteps(pieces);
	}
	/**
	 * előskörben összegyűjti a mezőket, amelyekre léphetünk
	 * @param pieces sakkbábuk töbje
	 */
	public void initializeSteps(ChessPieceArray pieces) {
		steps.clear();
		
		if (col == ChessPieceColor.white) {
			int rightdown = Integer.min(8 - coord.getHor(), 8 - coord.getVert());
			boolean blocked = false;
			for (int i = 1; i <= rightdown && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + i, coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert() + i));
				}
			}
			
			int leftdown = Integer.min(coord.getHor() - 1, 8 - coord.getVert());
			blocked = false;
			for (int i = 1; i <= leftdown && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - i, coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert() + i));
				}
			}
			
			int leftup = Integer.min(coord.getHor() - 1, coord.getVert() - 1);
			blocked = false;
			for (int i = 1; i <= leftup && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - i, coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert() - i));
				}
			}
			
			int rightup = Integer.min(8 - coord.getHor(), coord.getVert() - 1);
			blocked = false;
			for (int i = 1; i <= rightup && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + i, coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert() - i));
				}
			}
			
		} else {
			
			int rightdown = Integer.min(8 - coord.getHor(), 8 - coord.getVert());
			boolean blocked = false;
			for (int i = 1; i <= rightdown && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + i, coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert() + i));
				}
			}
			
			int leftdown = Integer.min(coord.getHor() - 1, 8 - coord.getVert());
			blocked = false;
			for (int i = 1; i <= leftdown && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - i, coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert() + i));
				}
			}
			
			int leftup = Integer.min(coord.getHor() - 1, coord.getVert() - 1);
			blocked = false;
			for (int i = 1; i <= leftup && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - i, coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert() - i));
				}
			}
			
			int rightup = Integer.min(8 - coord.getHor(), coord.getVert() - 1);
			blocked = false;
			for (int i = 1; i <= rightup && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + i, coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert() - i));
				}
			}
			
		}
	}
	/**
	 * visszaadja, hogy fehér paraszt-e
	 * @return igazságérték
	 */
	public boolean isWhiteBishop() {
		if (col == ChessPieceColor.white) {
			return true;
		}
		return false;
	}
	/**
	 * visszaadja, hogy fekete paraszt-e
	 * @return igazságérték
	 */
	public boolean isBlackBishop() {
		if (col == ChessPieceColor.black) {
			return true;
		}
		return false;
	}
}
