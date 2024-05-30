import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author vassp
 *
 */
public class King extends ChessPiece implements Serializable {
	/**
	 * konstruktor
	 * @param coord pozíció
	 * @param col szín
	 * @param pieces sakkbábutömb
	 */
	public King(Coordinate coord, ChessPieceColor col, ChessPieceArray pieces) {
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
			
			//fel
			if (coord.getVert() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() - 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor(), coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() - 1));
					}
				}
			}
			
			//feljobb
			if (coord.getVert() != 1 && coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 1));
					}
				}
			}
			
			//jobb
			if (coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert())))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert()));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert()));
					}
				}
			}
			
			//lejobb
			if (coord.getVert() != 8 && coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 1));
					}
				}
			}
			
			//le
			if (coord.getVert() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() + 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor(), coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() + 1));
					}
				}
			}
			
			//lebal
			if (coord.getVert() != 8 && coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 1));
					}
				}
			}
			
			//bal
			if (coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert())))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert()));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert()));
					}
				}
			}
			
			//felbal
			if (coord.getVert() != 1 && coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 1));
				} else {
					if (pieces.hasBlackAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 1));
					}
				}
			}
		} else {
			
			//fel
			if (coord.getVert() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() - 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor(), coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() - 1));
					}
				}
			}
			
			//feljobb
			if (coord.getVert() != 1 && coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() - 1));
					}
				}
			}
			
			//jobb
			if (coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert())))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert()));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert()));
					}
				}
			}
			
			//lejobb
			if (coord.getVert() != 8 && coord.getHor() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() + 1, coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor() + 1, coord.getVert() + 1));
					}
				}
			}
			
			//le
			if (coord.getVert() != 8) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor(), coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor(), coord.getVert() + 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor(), coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor(), coord.getVert() + 1));
					}
				}
			}
			
			//lebal
			if (coord.getVert() != 8 && coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 1)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert() + 1))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() + 1));
					}
				}
			}
			
			//bal
			if (coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert())))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert()));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert()))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert()));
					}
				}
			}
			
			//felbal
			if (coord.getVert() != 1 && coord.getHor() != 1) {
				if (!(pieces.hasChessPieceAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 1)))) {
					steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 1));
				} else {
					if (pieces.hasWhiteAt(new Coordinate(coord.getHor() - 1, coord.getVert() - 1))) {
						steps.add(new Coordinate(coord.getHor() - 1, coord.getVert() - 1));
					}
				}
			}
		}
	}
	/**
	 * sakkban van-e
	 * @param pieces sakkbábutömb
	 * @return igazságérték
	 */
	public boolean itIsInCheck(ChessPieceArray pieces) {
		if (col == ChessPieceColor.white) {
			for (int i = 0; i < pieces.size(); ++i) {
				if (pieces.get(i).getColor() == ChessPieceColor.black) {
					for (int j = 0; j < pieces.get(i).getSteps().size(); ++j) {
						if (pieces.get(i).getSteps().get(j).equals(coord)) {
							return true;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < pieces.size(); ++i) {
				if (pieces.get(i).getColor() == ChessPieceColor.white) {
					for (int j = 0; j < pieces.get(i).getSteps().size(); ++j) {
						if (pieces.get(i).getSteps().get(j).equals(coord)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * sakkmattban van-e
	 * @param pieces sakkbábutömb
	 * @return igazságérték
	 */
	public boolean itIsInCheckMate(ChessPieceArray pieces) {
		if (steps.isEmpty()) {
			if (col == ChessPieceColor.white) {
				for (int i = 0; i < pieces.size(); ++i) {
					if (pieces.get(i).getColor() == ChessPieceColor.black) {
						for (int j = 0; j < pieces.get(i).getSteps().size(); ++j) {
							if (pieces.get(i).getSteps().get(j).equals(coord)) {
								return true;
							}
						}
					}
				}
			} else {
				for (int i = 0; i < pieces.size(); ++i) {
					if (pieces.get(i).getColor() == ChessPieceColor.white) {
						for (int j = 0; j < pieces.get(i).getSteps().size(); ++j) {
							if (pieces.get(i).getSteps().get(j).equals(coord)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * fehér király-e
	 * @return igazságérték
	 */
	public boolean isWhiteKing() {
		if (col == ChessPieceColor.white) {
			return true;
		}
		return false;
	}
	/**
	 * fekete király-e
	 * @return igazságérték
	 */
	public boolean isBlackKing() {
		if (col == ChessPieceColor.black) {
			return true;
		}
		return false;
	}
}
