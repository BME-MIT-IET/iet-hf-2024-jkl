import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author vassp
 *
 */
public class ChessPieceArray extends ArrayList<ChessPiece> implements Serializable {
	/**
	 * visszaadja az adott sorszámú sakkbábut
	 * @param idx index
	 */
	public ChessPiece get(int idx) {
		return super.get(idx);
	}
	/**
	 * hozzáad egy sakkbábut
	 * @param cp bábu
	 * @return igazságérték
	 */
	public boolean add(ChessPiece cp) {
		return super.add(cp);
	}
	/**
	 * eltávolít egy sakkbábut
	 * @param cp bábu
	 * @return igazságérték
	 */
	public boolean remove(ChessPiece cp) {
		return super.remove(cp);
	}
	/**
	 * tartalmaz-e egy sakkbábut
	 * @param cp bábu
	 * @return igazságérték
	 */
	public boolean contains(ChessPiece cp) {
		return super.contains(cp);
	}
	/**
	 * van-e sakkbábu a megadott pozíción
	 * @param coord pozíció
	 * @return igazságérték
	 */
	public boolean hasChessPieceAt(Coordinate coord) {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).getPosition().equals(coord)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * van-e fehér sakkbábu a megadott pozíción
	 * @param coord pozíció
	 * @return igazságérték
	 */
	public boolean hasWhiteAt(Coordinate coord) {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).getPosition().equals(coord) && this.get(i).getColor() == ChessPieceColor.white) {
				return true;
			}
		}
		return false;
	}
	/**
	 * van-e fekete sakkbábu a megadott pozíción
	 * @param coord pozíció
	 * @return igazságérték
	 */
	public boolean hasBlackAt(Coordinate coord) {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).getPosition().equals(coord) && this.get(i).getColor() == ChessPieceColor.black) {
				return true;
			}
		}
		return false;
	}
	/**
	 * a sakkbábukon beállítja a léphető mezőket
	 * @return sakkbábuk tömbje
	 */
	public ChessPieceArray setSteps() {
		ArrayList<ArrayList<Coordinate>> newSteps = new ArrayList<ArrayList<Coordinate>>();
		for (int i = 0; i < this.size(); ++i) {
			newSteps.add(this.get(i).setSteps(this));
		}
		for (int i = 0; i < this.size(); ++i) {
			this.get(i).overwriteSteps(newSteps.get(i));
		}
		return this;
	}
	/**
	 * első körben kiszámolja a léphető mezőket a bábukon
	 */
	public void initializeSteps() {
		for (int i = 0; i < this.size(); ++i) {
			this.get(i).initializeSteps(this);
		}
	}
	/**
	 * van-e sakkmatt
	 * @return igazságérték
	 */
	public boolean checkCheckMate() {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).itIsInCheckMate(this)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * van-e sakk
	 * @return igazságérték
	 */
	public boolean kingIsInCheck() {
		return this.whiteKingIsInCheck() || this.blackKingIsInCheck();
	}
	/**
	 * fehér király sakkban van-e
	 * @return igazságérték
	 */
	public boolean whiteKingIsInCheck() {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).isWhiteKing()) {
				ChessPiece whiteking = this.get(i);
				for (int j = 0; j < this.size(); ++j) {
					if (this.get(j).getSteps().contains(whiteking.getPosition())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * fekete király sakkban van-e
	 * @return igazságérték
	 */
	public boolean blackKingIsInCheck() {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).isBlackKing()) {
				ChessPiece blackking = this.get(i);
				for (int j = 0; j < this.size(); ++j) {
					if (this.get(j).getSteps().contains(blackking.getPosition())) {
						System.out.println("blackking in check");
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * van-e sakkmatt
	 * @return igazságérték
	 */
	public boolean kingIsInCheckMate() {
		if(!(this.kingIsInCheck())) {
			return false;
		}
		if (this.whiteKingIsInCheck()) {
			for (int i = 0; i < this.size(); ++i) {
				if (this.get(i).getColor() == ChessPieceColor.white && !(this.get(i).getSteps().isEmpty())) {
					return false;
				}
			}
		}
		if (this.blackKingIsInCheck()) {
			for (int i = 0; i < this.size(); ++i) {
				if (this.get(i).getColor() == ChessPieceColor.black && !(this.get(i).getSteps().isEmpty())) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * deep copy-hoz lemásolja az objektumot és visszaadja
	 * @return másolt sakkbábutömb
	 */
	public ChessPieceArray copy() {
		ChessPieceArray pieces = (ChessPieceArray)this.clone();
		for (int i = 0; i < this.size(); ++i) {
			ChessPiece cp = this.get(i).copy();
			pieces.remove(this.get(i));
			pieces.add(cp);
		}
		return pieces;
	}
	
	/**
	 * visszaadja a bábut a megadott mezőn
	 * @param coord pozíció
	 * @return sakkbábu
	 */
	public ChessPiece getChessPieceAt(Coordinate coord) {
		for (int i = 0; i < this.size(); ++i) {
			if (get(i).getPosition().equals(coord)) {
				return get(i);
			}
		}
		return null;
	}
	/**
	 * visszadaja a fehér király pozícióját
	 * @return pozíció
	 */
	public Coordinate getWhiteKingPosition() {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).isWhiteKing()) {
				return this.get(i).getPosition();
			}
		}
		return null;
	}
	/**
	 * visszadaja a fekete király pozícióját
	 * @return pozíció
	 */
	public Coordinate getBlackKingPosition() {
		for (int i = 0; i < this.size(); ++i) {
			if (this.get(i).isBlackKing()) {
				return this.get(i).getPosition();
			}
		}
		return null;
	}
}
