import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
/**
 * 
 * @author vassp
 *
 */
public class ColorChooser extends JFrame implements ActionListener{
	/**
	 * ablak
	 */
	JFrame f;
	/**
	 * gomb
	 */
	JButton b;
	/**
	 * szöveg mező
	 */
	JTextArea ta;
	/**
	 * konstruktor
	 */
	ColorChooser(){  
	    f=new JFrame("Color Chooser Example.");  
	    b=new JButton("Pad Color");  
	    b.setBounds(200,250,100,30);  
	    ta=new JTextArea();  
	    ta.setBounds(10,10,300,200);  
	    b.addActionListener(this);  
	    f.add(b);f.add(ta);  
	    f.setLayout(null);  
	    f.setSize(400,400);  
	    f.setVisible(true);  
	}  
	/**
	 * esemény kezelése
	 * @param ae esemény
	 */
	public void actionPerformed(ActionEvent ae){  
	    Color c=JColorChooser.showDialog(this,"Choose",Color.CYAN);  
	    ta.setBackground(c);  
	}
}