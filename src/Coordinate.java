import java.io.Serializable;
/**
 * 
 * @author vassp
 *
 */
public class Coordinate implements Serializable {
	/**
	 * horizontális koordináta
	 */
	private int hor;
	/**
	 * vertikális koordináta
	 */
	private int vert;
	/**
	 * paraméteres konstruktor
	 * @param hor horizontális koordináta
	 * @param vert vertikális koordináta
	 */
	public Coordinate(int hor, int vert) {
		this.hor = hor;
		this.vert = vert;
	}
	/**
	 * visszaadja a horizontális koordinátát
	 * @return horizontális koordináta
	 */
	public int getHor() {
		return hor;
	}
	/**
	 * beállítja a horizontális koordinátát
	 * @param hor horizontális koordináta
	 */
	public void setHor(int hor) {
		this.hor = hor;
	}
	/**
	 * visszaadja a vertikális koordinátát
	 * @return vertikális koordináta
	 */
	public int getVert() {
		return vert;
	}
	/**
	 * beállítja a vertikális koordinátát
	 * @param vert vertikális koordináta
	 */
	public void setVert(int vert) {
		this.vert = vert;
	}
	/**
	 * megegyezik-e a kér objektum mutatott értéke
	 * @return igazságérték
	 */
	public boolean equals(Object o) {
		Coordinate c = (Coordinate)o;
		return hor == c.getHor() && vert == c.getVert();
	}
	/**
	 * deep copy-hoz másolatot készít
	 * @return pozíció
	 */
	public Coordinate copy() {
		try {
			Coordinate c = (Coordinate)this.clone();
			return c;
		} catch (CloneNotSupportedException cnse) {
			
		}
		return null;
	}
	/**
	 * fejlesztést segíti, konzolra írja a koordinátát
	 */
	public void display() {
		System.out.println("(" + hor + "; " + vert + ")");
	}
}
