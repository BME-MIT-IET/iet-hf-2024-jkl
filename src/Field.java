import javax.swing.JPanel;

/**
 * 
 * @author vassp
 *
 */
public class Field extends JPanel {
	/**
	 * mező pozíciója
	 */
	private Coordinate coord;
	/**
	 * paraméteres konstruktor
	 * @param coord pozíció
	 */
	public Field(Coordinate coord) {
		this.coord = coord;
	}
	/**
	 * visszaadja a pozíciót
	 * @return pozíció
	 */
	public Coordinate getCoordinate() {
		return coord;
	}
}
