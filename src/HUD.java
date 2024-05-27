import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class HUD extends JFrame {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel hudPanel;
    private JPanel actionsPanel;
    private JPanel pointPanel;
    private JPanel currentPlayerPanel;
    private JLabel pointsDscrLabel;
    private JLabel sabPoints;
    private JLabel mechPoints;
    private JLabel pointsSeparatorLabel;
    private JLabel player;
    private JLabel currentPlayerLabel;
    private JButton PunctureButton;
    private JButton pickUpPumpButton;
    private JButton makeStickyButton;
    private JButton fixPumpButton;
    private JButton fixPipeButton;
    private JButton placePipeButton;
    private JButton placePumpButton;
    private JButton passButton;
    private JPanel infoPanel;
    private JLabel infoLabel;

    public HUD(JPanel gamePanel) {
        super("HUD");
        //$$$setupUI$$$();
        this.gamePanel = gamePanel;
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
    }

    public void setSabPoints(int sabPoints) {
        this.sabPoints.setText(String.valueOf(sabPoints));
    }

    public void setMechPoints(int mechPoints) {
        this.mechPoints.setText(String.valueOf(mechPoints));
    }

    public void setCurrentPlayer(String currentPlayerName) {
        this.player.setText(currentPlayerName);
    }

    public void setInfo(String info) {
        this.infoLabel.setText(info);
    }

    public void setPunctureButtonListener(ActionListener listener) {
        PunctureButton.addActionListener(listener);
    }

    public void setPickUpPumpButtonListener(ActionListener listener) {
        pickUpPumpButton.addActionListener(listener);
    }

    public void setMakeStickyButtonListener(ActionListener listener) {
        makeStickyButton.addActionListener(listener);
    }

    public void setFixPumpButtonListener(ActionListener listener) {
        fixPumpButton.addActionListener(listener);
    }

    public void setFixPipeButtonListener(ActionListener listener) {
        fixPipeButton.addActionListener(listener);
    }

    public void setPlacePipeButtonListener(ActionListener listener) {
        placePipeButton.addActionListener(listener);
    }

    public void setPlacePumpButtonListener(ActionListener listener) {
        placePumpButton.addActionListener(listener);
    }

    public void setPassButtonListener(ActionListener listener) {
        passButton.addActionListener(listener);
    }

}
