import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vassp
 *
 */
public class Queen extends ChessPiece implements Serializable {
	/**
	 * konstruktor
	 * @param coord pozíció
	 * @param col szín
	 * @param pieces sakkbábutömb
	 */
	public Queen(Coordinate coord, ChessPieceColor col, ChessPieceArray pieces) {
		this.coord = coord;
		this.col = col;
		steps = new ArrayList<Coordinate>();
		setSteps(pieces);
	}
	/**
	 * első körben kiszámolja a léphető mezőket
	 * @param pieces sakkbábutömb
	 */
	public void initializeSteps(ChessPieceArray pieces) {
		steps.clear();
		
		if (col == ChessPieceColor.white) {
			
			//horizontalis mezok jobbra
			int right = 8 - coord.getHor();
			boolean blocked = false;
			for (int i = 1; i <= right && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert()))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + i, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert()));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert()));
				}
			}
			
			//horizontalis mezok balra
			int left = coord.getHor() - 1;
			blocked = false;
			for (int i = 1; i <= left && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert()))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - i, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert()));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert()));
				}
			}
			
			//vertikalis mezok le
			int down = 8 - coord.getVert();
			blocked = false;
			for (int i = 1; i <= down && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor(), coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() + i));
				}
			}
			
			//vertikalis mezok fel
			int up = coord.getVert() - 1;
			blocked = false;
			for (int i = 1; i <= up && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasBlackAt(new Coordinate(coord.getHor(), coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() - i));
				}
			}
			
			int rightdown = Integer.min(8 - coord.getHor(), 8 - coord.getVert());
			blocked = false;
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
			
			//horizontalis mezok jobbra
			int right = 8 - coord.getHor();
			boolean blocked = false;
			for (int i = 1; i <= right && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() + i, coord.getVert()))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + i, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() + i, coord.getVert()));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() + i, coord.getVert()));
				}
			}
			
			//horizontalis mezok balra
			int left = coord.getHor() - 1;
			blocked = false;
			for (int i = 1; i <= left && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor() - i, coord.getVert()))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - i, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() - i, coord.getVert()));
					}
				} else {
					steps.add(new Coordinate(coord.getHor() - i, coord.getVert()));
				}
			}
			
			//vertikalis mezok le
			int down = 8 - coord.getVert();
			blocked = false;
			for (int i = 1; i <= down && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() + i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor(), coord.getVert() + i))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() + i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() + i));
				}
			}
			
			//vertikalis mezok fel
			int up = coord.getVert() - 1;
			blocked = false;
			for (int i = 1; i <= up && !blocked; ++i) {
				if (pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() - i))) {
					blocked = true;
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor(), coord.getVert() - i))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() - i));
					}
				} else {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() - i));
				}
			}
			
			int rightdown = Integer.min(8 - coord.getHor(), 8 - coord.getVert());
			blocked = false;
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
	 * fehér királynő-e
	 * @return igazságérték
	 */
	public boolean isWhiteQueen() {
		if (col == ChessPieceColor.white) {
			return true;
		}
		return false;
	}
	/**
	 * fekete királynő-e
	 * @return igazságérték
	 */
	public boolean isBlackQueen() {
		if (col == ChessPieceColor.black) {
			return true;
		}
		return false;
	}
}
