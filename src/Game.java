import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * 
 * @author vassp
 *
 */
public class Game {
	/**
	 * a program logikáját kezeli
	 */
	private Model m;
	/**
	 * a program megjelenítését kezeli
	 */
	private View v;
	/**
	 * az éppen kiválasztott sakkbábu
	 */
	private ChessPiece selected;
	/**
	 * konstruktor
	 */
	public Game() {
		m = new Model();
		v = new View();
		v.drawMenu(new ButtonActionListener());
	}
	/**
	 * 
	 * @author vassp
	 *
	 */
	public class SelectionMouseListener implements MouseListener {
		/**
		 * kattintás esemény kezelése
		 */
		public void mouseClicked(MouseEvent me) {
			ChessPiece cp = m.getTable().getPieces().getChessPieceAt(((Field)(me.getSource())).getCoordinate());
			v.setViewSelected(m, cp, new SelectionMouseListener(), new StepMouseListener(), new SaveActionListener());
			selected = cp;
		}
		/**
		 * 
		 */
		public void mousePressed(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseEntered(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseExited(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseReleased(MouseEvent me) {
			
		}
	}
	/**
	 * 
	 * @author vassp
	 *
	 */
	public class StepMouseListener implements MouseListener {
		/**
		 * 
		 */
		public void mouseClicked(MouseEvent me) {
			Coordinate coord = ((Field)(me.getSource())).getCoordinate();
			m.getTable().step(selected, coord);
			if (m.getGameMode() == GameMode.multiPlayer) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					if (m.getBlackKingPositions().isEmpty()) {
						v.gameOver(ChessPieceColor.white);
					}
					m.setActivePlayer(ActivePlayer.black);
				} else {
					if (m.getWhiteKingPositions().isEmpty()) {
						v.gameOver(ChessPieceColor.black);
					}
					m.setActivePlayer(ActivePlayer.white);
				}
			} else {
				if (m.getBlackKingPositions().isEmpty()) {
					v.gameOver(ChessPieceColor.white);
				}
				if (m.getWhiteKingPositions().isEmpty()) {
					v.gameOver(ChessPieceColor.black);
				}
				m.AIStep();
				if (m.getBlackKingPositions().isEmpty()) {
					v.gameOver(ChessPieceColor.white);
				}
				if (m.getWhiteKingPositions().isEmpty()) {
					v.gameOver(ChessPieceColor.black);
				}
			}
			v.setViewNotSelected(m, new SelectionMouseListener(), new SaveActionListener());
		}
		/**
		 * 
		 */
		public void mousePressed(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseEntered(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseExited(MouseEvent me) {
			
		}
		/**
		 * 
		 */
		public void mouseReleased(MouseEvent me) {
			
		}
	}
	/**
	 * 
	 * @author vassp
	 *
	 */
	public class SaveActionListener implements ActionListener {
		/**
		 * esemény kezelése
		 */
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("save")) {
				try {
					String wd = System.getProperty("user.dir");
					File f = new File(wd + "\\src\\model.txt");
					if (!f.exists())
						f.createNewFile();
					if(f.exists()) {
						FileOutputStream fs = new FileOutputStream(f);
						ObjectOutputStream out = new ObjectOutputStream(fs);
						out.writeObject(m);
						out.close();
					}
				} catch(IOException ex) {
					
				}
			}
		}
	}
	/**
	 * 
	 * @author vassp
	 *
	 */
	public class ButtonActionListener implements ActionListener {
		/**
		 * esemény kezelése
		 */
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("singleplayer")) {
				m.setGameMode(GameMode.singlePlayer);
				v.setViewNotSelected(m, new SelectionMouseListener(), new SaveActionListener());
			}
			if (ae.getActionCommand().equals("multiplayer")) {
				m.setGameMode(GameMode.multiPlayer);
				v.setViewNotSelected(m, new SelectionMouseListener(), new SaveActionListener());
			}
			if (ae.getActionCommand().equals("continueGame")) {
				try {
					String wd = System.getProperty("user.dir");
					File file = new File(wd + "\\src\\model.txt");
					if (file.exists()) {
						FileInputStream f =
						new FileInputStream(file);
						ObjectInputStream in =
						new ObjectInputStream(f);
						Model m1 = (Model)in.readObject();
						m = m1;
						in.close();
					}
				} catch(IOException ex) {
					
				} catch(ClassNotFoundException ex) {
					
				}
				v.setViewNotSelected(m, new SelectionMouseListener(), new SaveActionListener());
			}
			if (ae.getActionCommand().equals("exit")) {
				v.end();
			}
		}
	}
}
