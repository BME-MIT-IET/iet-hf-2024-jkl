import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.event.*;

/**
 * 
 * @author vassp
 *
 */
public class View {
	/**
	 * ablak, ami az interakciót biztosítja
	 */
	private JFrame f;
	/**
	 * kép a fehér paraszthoz
	 */
	private ImageIcon whitepawnImage;
	/**
	 * kép a fehér bástyához
	 */
	private ImageIcon whiterookImage;
	/**
	 * kép a fehér huszárhoz
	 */
	private ImageIcon whiteknightImage;
	/**
	 * kép a fehér futárhoz
	 */
	private ImageIcon whitebishopImage;
	/**
	 * kép a fehér királynőhöz
	 */
	private ImageIcon whitequeenImage;
	/**
	 * kép a fehér királyhoz
	 */
	private ImageIcon whitekingImage;
	/**
	 * kép a fekete paraszthoz
	 */
	private ImageIcon blackpawnImage;
	/**
	 * kép a fekete bástyához
	 */
	private ImageIcon blackrookImage;
	/**
	 * kép a fekete huszárhoz
	 */
	private ImageIcon blackknightImage;
	/**
	 * kép a fekete futárhoz
	 */
	private ImageIcon blackbishopImage;
	/**
	 * kép a fekete királynőhöz
	 */
	private ImageIcon blackqueenImage;
	/**
	 * kép a fekete királyhoz
	 */
	private ImageIcon blackkingImage;
	/**
	 * a tábla színe
	 */
	private Color boardColor;
	/**
	 * konstruktor
	 */
	public View() {
		f = new JFrame("Chess");
		f.setSize(800, 800);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		try {
			String path = System.getProperty("user.dir");
			BufferedImage whitepawnPicture = ImageIO.read(new File(path + "\\src\\white_pawn.png"));
			whitepawnImage = new ImageIcon(whitepawnPicture);
			
			BufferedImage whiterookPicture = ImageIO.read(new File(path + "\\src\\white_rook.png"));
			whiterookImage = new ImageIcon(whiterookPicture);
			
			BufferedImage whiteknightPicture = ImageIO.read(new File(path + "\\src\\white_knight.png"));
			whiteknightImage = new ImageIcon(whiteknightPicture);
			
			BufferedImage whitebishopPicture = ImageIO.read(new File(path + "\\src\\white_bishop.png"));
			whitebishopImage = new ImageIcon(whitebishopPicture);
			
			BufferedImage whitequeenPicture = ImageIO.read(new File(path + "\\src\\white_queen.png"));
			whitequeenImage = new ImageIcon(whitequeenPicture);
			
			BufferedImage whitekingPicture = ImageIO.read(new File(path + "\\src\\white_king.png"));
			whitekingImage = new ImageIcon(whitekingPicture);
			
			BufferedImage blackpawnPicture = ImageIO.read(new File(path + "\\src\\black_pawn.png"));
			blackpawnImage = new ImageIcon(blackpawnPicture);
			
			BufferedImage blackrookPicture = ImageIO.read(new File(path + "\\src\\black_rook.png"));
			blackrookImage = new ImageIcon(blackrookPicture);
			
			BufferedImage blackknightPicture = ImageIO.read(new File(path + "\\src\\black_knight.png"));
			blackknightImage = new ImageIcon(blackknightPicture);
			
			BufferedImage blackbishopPicture = ImageIO.read(new File(path + "\\src\\black_bishop.png"));
			blackbishopImage = new ImageIcon(blackbishopPicture);
			
			BufferedImage blackqueenPicture = ImageIO.read(new File(path + "\\src\\black_queen.png"));
			blackqueenImage = new ImageIcon(blackqueenPicture);
			
			BufferedImage blackkingPicture = ImageIO.read(new File(path + "\\src\\black_king.png"));
			blackkingImage = new ImageIcon(blackkingPicture);
		} catch (IOException ioe) {
			
		}
		boardColor = new Color(0x544332);
	}
	/**
	 * kirajzolja a menüt
	 * @param bal gomb esemény listener
	 */
	public void drawMenu(ActionListener bal) {
		JPanel menu = new JPanel();
		menu.setBackground(new Color(0xffffff));
		menu.setLayout(new GridLayout(6, 1));
		JLabel l = new JLabel("Chess", SwingConstants.CENTER);
		l.setFont(new Font("Serif", Font.PLAIN, 85));
		menu.add(l);
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0xffffff));
		JButton singlePlayerButton = new JButton("Singleplayer");
		singlePlayerButton.setPreferredSize(new Dimension(400, 100));
		singlePlayerButton.setActionCommand("singleplayer");
		singlePlayerButton.addActionListener(bal);
		p1.add(singlePlayerButton);
		menu.add(p1);
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(0xffffff));
		JButton multiPlayerButton = new JButton("Multiplayer");
		multiPlayerButton.setPreferredSize(new Dimension(400, 100));
		multiPlayerButton.setActionCommand("multiplayer");
		multiPlayerButton.addActionListener(bal);
		p2.add(multiPlayerButton);
		menu.add(p2);
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(0xffffff));
		JButton continueGameButton = new JButton("Continue Game");
		continueGameButton.setPreferredSize(new Dimension(400, 100));
		continueGameButton.setActionCommand("continueGame");
		continueGameButton.addActionListener(bal);
		p3.add(continueGameButton);
		menu.add(p3);
		
		BoardColorChooser bcc = new BoardColorChooser();
		menu.add(bcc);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color(0xffffff));
		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(400, 100));
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(bal);
		p4.add(exitButton);
		menu.add(p4);
		f.setContentPane(menu);
		f.validate();
	}
	/**
	 * bezárja a játékot
	 */
	public void end() {
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
	/**
	 * kirajzolja a pályát, amikor éppen nincs egy bábu se kiválasztva
	 * @param m modell
	 * @param sml mező kiválasztó egér listener
	 * @param sal mentést végző esemény listener
	 */
	public void setViewNotSelected(Model m, MouseListener sml, ActionListener sal) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				Field field = new Field(new Coordinate(j + 1, i + 1));
				if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
					field.setBackground(new Color(0xffffff));
				} else {
					field.setBackground(boardColor);
				}
				panel.add(field);
			}
		}
		
		if (m.getTable().kingIsInCheckMate()) {
			System.out.println("checkmate");
		} else {
			if (m.getTable().kingIsInCheck()) {
				System.out.println("check");
			} 
			for (int i = 0; i < m.getWhitePawnPositions().size(); ++i) {
				JLabel temp = new JLabel(whitepawnImage);
				((Field)panel.getComponent(m.getWhitePawnPositions().get(i).getHor() - 1 + (m.getWhitePawnPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhitePawnPositions().get(i).getHor() - 1 + (m.getWhitePawnPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getWhiteRookPositions().size(); ++i) {
				JLabel temp = new JLabel(whiterookImage);
				((Field)panel.getComponent(m.getWhiteRookPositions().get(i).getHor() - 1 + (m.getWhiteRookPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteRookPositions().get(i).getHor() - 1 + (m.getWhiteRookPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getWhiteKnightPositions().size(); ++i) {
				JLabel temp = new JLabel(whiteknightImage);
				((Field)panel.getComponent(m.getWhiteKnightPositions().get(i).getHor() - 1 + (m.getWhiteKnightPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteKnightPositions().get(i).getHor() - 1 + (m.getWhiteKnightPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getWhiteBishopPositions().size(); ++i) {
				JLabel temp = new JLabel(whitebishopImage);
				((Field)panel.getComponent(m.getWhiteBishopPositions().get(i).getHor() - 1 + (m.getWhiteBishopPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteBishopPositions().get(i).getHor() - 1 + (m.getWhiteBishopPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getWhiteQueenPositions().size(); ++i) {
				JLabel temp = new JLabel(whitequeenImage);
				((Field)panel.getComponent(m.getWhiteQueenPositions().get(i).getHor() - 1 + (m.getWhiteQueenPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteQueenPositions().get(i).getHor() - 1 + (m.getWhiteQueenPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getWhiteKingPositions().size(); ++i) {
				JLabel temp = new JLabel(whitekingImage);
				((Field)panel.getComponent(m.getWhiteKingPositions().get(i).getHor() - 1 + (m.getWhiteKingPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteKingPositions().get(i).getHor() - 1 + (m.getWhiteKingPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackPawnPositions().size(); ++i) {
				JLabel temp = new JLabel(blackpawnImage);
				((Field)panel.getComponent(m.getBlackPawnPositions().get(i).getHor() - 1 + (m.getBlackPawnPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackPawnPositions().get(i).getHor() - 1 + (m.getBlackPawnPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackRookPositions().size(); ++i) {
				JLabel temp = new JLabel(blackrookImage);
				((Field)panel.getComponent(m.getBlackRookPositions().get(i).getHor() - 1 + (m.getBlackRookPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackRookPositions().get(i).getHor() - 1 + (m.getBlackRookPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackKnightPositions().size(); ++i) {
				JLabel temp = new JLabel(blackknightImage);
				((Field)panel.getComponent(m.getBlackKnightPositions().get(i).getHor() - 1 + (m.getBlackKnightPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackKnightPositions().get(i).getHor() - 1 + (m.getBlackKnightPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackBishopPositions().size(); ++i) {
				JLabel temp = new JLabel(blackbishopImage);
				((Field)panel.getComponent(m.getBlackBishopPositions().get(i).getHor() - 1 + (m.getBlackBishopPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackBishopPositions().get(i).getHor() - 1 + (m.getBlackBishopPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackQueenPositions().size(); ++i) {
				JLabel temp = new JLabel(blackqueenImage);
				((Field)panel.getComponent(m.getBlackQueenPositions().get(i).getHor() - 1 + (m.getBlackQueenPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackQueenPositions().get(i).getHor() - 1 + (m.getBlackQueenPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
			for (int i = 0; i < m.getBlackKingPositions().size(); ++i) {
				JLabel temp = new JLabel(blackkingImage);
				((Field)panel.getComponent(m.getBlackKingPositions().get(i).getHor() - 1 + (m.getBlackKingPositions().get(i).getVert() - 1) * 8)).add(temp);
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackKingPositions().get(i).getHor() - 1 + (m.getBlackKingPositions().get(i).getVert() - 1) * 8)).addMouseListener(sml);
				}
			}
		}
		
		JMenuItem mi1 = new JMenuItem("Save");
		mi1.setActionCommand("save");
		mi1.addActionListener(sal);
		JMenu m1 = new JMenu("Save Board");
		m1.add(mi1);
		JMenuBar bar = new JMenuBar();
		bar.add(m1);
		f.setJMenuBar(bar);
		
		f.setContentPane(panel);
		f.validate();
	}
	/**
	 * kirajzolja a pályát, amikor ki van választva egy bábu
	 * @param m modell
	 * @param cp sakkbábu
	 * @param selml kiválasztást kezelő egér listener
	 * @param stepml lépést kezelő egér listener
	 * @param sal mentést végző esemény listener
	 */
	public void setViewSelected(Model m, ChessPiece cp, MouseListener selml, MouseListener stepml, ActionListener sal) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				Field field = new Field(new Coordinate(j + 1, i + 1));
				if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
					field.setBackground(new Color(0xffffff));
				} else {
					field.setBackground(boardColor);
				}
				panel.add(field);
			}
		}
		
		
		
		for (int i = 0; i < m.getWhitePawnPositions().size(); ++i) {
			JLabel temp = new JLabel(whitepawnImage);
			((Field)panel.getComponent(m.getWhitePawnPositions().get(i).getHor() - 1 + (m.getWhitePawnPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhitePawnPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhitePawnPositions().get(i).getHor() - 1 + (m.getWhitePawnPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getWhiteRookPositions().size(); ++i) {
			JLabel temp = new JLabel(whiterookImage);
			((Field)panel.getComponent(m.getWhiteRookPositions().get(i).getHor() - 1 + (m.getWhiteRookPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhiteRookPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteRookPositions().get(i).getHor() - 1 + (m.getWhiteRookPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getWhiteKnightPositions().size(); ++i) {
			JLabel temp = new JLabel(whiteknightImage);
			((Field)panel.getComponent(m.getWhiteKnightPositions().get(i).getHor() - 1 + (m.getWhiteKnightPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhiteKnightPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteKnightPositions().get(i).getHor() - 1 + (m.getWhiteKnightPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getWhiteBishopPositions().size(); ++i) {
			JLabel temp = new JLabel(whitebishopImage);
			((Field)panel.getComponent(m.getWhiteBishopPositions().get(i).getHor() - 1 + (m.getWhiteBishopPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhiteBishopPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteBishopPositions().get(i).getHor() - 1 + (m.getWhiteBishopPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getWhiteQueenPositions().size(); ++i) {
			JLabel temp = new JLabel(whitequeenImage);
			((Field)panel.getComponent(m.getWhiteQueenPositions().get(i).getHor() - 1 + (m.getWhiteQueenPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhiteQueenPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteQueenPositions().get(i).getHor() - 1 + (m.getWhiteQueenPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getWhiteKingPositions().size(); ++i) {
			JLabel temp = new JLabel(whitekingImage);
			((Field)panel.getComponent(m.getWhiteKingPositions().get(i).getHor() - 1 + (m.getWhiteKingPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getWhiteKingPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.white) {
					((Field)panel.getComponent(m.getWhiteKingPositions().get(i).getHor() - 1 + (m.getWhiteKingPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackPawnPositions().size(); ++i) {
			JLabel temp = new JLabel(blackpawnImage);
			((Field)panel.getComponent(m.getBlackPawnPositions().get(i).getHor() - 1 + (m.getBlackPawnPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackPawnPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackPawnPositions().get(i).getHor() - 1 + (m.getBlackPawnPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackRookPositions().size(); ++i) {
			JLabel temp = new JLabel(blackrookImage);
			((Field)panel.getComponent(m.getBlackRookPositions().get(i).getHor() - 1 + (m.getBlackRookPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackRookPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackRookPositions().get(i).getHor() - 1 + (m.getBlackRookPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackKnightPositions().size(); ++i) {
			JLabel temp = new JLabel(blackknightImage);
			((Field)panel.getComponent(m.getBlackKnightPositions().get(i).getHor() - 1 + (m.getBlackKnightPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackKnightPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackKnightPositions().get(i).getHor() - 1 + (m.getBlackKnightPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackBishopPositions().size(); ++i) {
			JLabel temp = new JLabel(blackbishopImage);
			((Field)panel.getComponent(m.getBlackBishopPositions().get(i).getHor() - 1 + (m.getBlackBishopPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackBishopPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackBishopPositions().get(i).getHor() - 1 + (m.getBlackBishopPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackQueenPositions().size(); ++i) {
			JLabel temp = new JLabel(blackqueenImage);
			((Field)panel.getComponent(m.getBlackQueenPositions().get(i).getHor() - 1 + (m.getBlackQueenPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackQueenPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackQueenPositions().get(i).getHor() - 1 + (m.getBlackQueenPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		for (int i = 0; i < m.getBlackKingPositions().size(); ++i) {
			JLabel temp = new JLabel(blackkingImage);
			((Field)panel.getComponent(m.getBlackKingPositions().get(i).getHor() - 1 + (m.getBlackKingPositions().get(i).getVert() - 1) * 8)).add(temp);
			if (!(cp.getSteps().contains(m.getBlackKingPositions().get(i)))) {
				if (m.getActivePlayer() == ActivePlayer.black) {
					((Field)panel.getComponent(m.getBlackKingPositions().get(i).getHor() - 1 + (m.getBlackKingPositions().get(i).getVert() - 1) * 8)).addMouseListener(selml);
				}
			}
		}
		
		for (int i = 0; i < cp.getSteps().size(); ++i) {
			panel.getComponent(cp.getSteps().get(i).getHor() - 1 + (cp.getSteps().get(i).getVert() - 1) * 8).setBackground(new Color(0x277433));
			panel.getComponent(cp.getSteps().get(i).getHor() - 1 + (cp.getSteps().get(i).getVert() - 1) * 8).addMouseListener(stepml);
		}
		
		JMenuItem mi1 = new JMenuItem("Save");
		mi1.setActionCommand("save");
		mi1.addActionListener(sal);
		JMenu m1 = new JMenu("Save Board");
		m1.add(mi1);
		JMenuBar bar = new JMenuBar();
		bar.add(m1);
		f.setJMenuBar(bar);
		
		f.setContentPane(panel);
		f.validate();
	}
	/**
	 * játék végén kirajzolja a megfelelő mezőket
	 * @param cpc sakkbábu szín
	 */
	public void gameOver(ChessPieceColor cpc) {
		JFrame popUp = new JFrame();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		/**
		 * 
		 * @author vassp
		 *
		 */
		class OkButtonActionListener implements ActionListener {
			/**
			 * eseményt kezel
			 */
			public void actionPerformed(ActionEvent ae) {
				if (ae.getActionCommand().equals("ok")) {
					f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
				}
			}
		}
		
		String s;
		if (cpc == ChessPieceColor.white) {
			s = "White won!";
		} else {
			s = "Black won!";
		}
		JLabel l = new JLabel(s, SwingConstants.CENTER);
		l.setFont(new Font("Serif", Font.PLAIN, 20));
		JButton b = new JButton("Ok");
	    b.setPreferredSize(new Dimension(10, 10));
	    b.setActionCommand("ok");
	    b.addActionListener(new OkButtonActionListener());
	    p.add(l);
	    p.add(b);
		popUp.add(p);
		popUp.setSize(200, 200);
		popUp.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		popUp.setVisible(true);
		
	}
	/**
	 * 
	 * @author vassp
	 *
	 */
	public class BoardColorChooser extends JPanel implements ActionListener {
		/**
		 * gomb a jóváhagyáshoz
		 */
		JButton b;
		/**
		 * konstruktor
		 */
		BoardColorChooser(){  
			this.setBackground(new Color(0xffffff));
		    b = new JButton("Choose Board Color");
		    b.setPreferredSize(new Dimension(400, 100));
		    b.addActionListener(this);  
		    this.add(b);  
		}
		/**
		 * eseményt kezel
		 */
		public void actionPerformed(ActionEvent e){  
		    Color c = JColorChooser.showDialog(this,"Choose",Color.CYAN);  
		    boardColor = c;
		}
	}
}
