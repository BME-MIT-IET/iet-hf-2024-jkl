import javax.swing.*;
import java.awt.*;

public class LoadingScreen {

    LoadingScreen() {
        JFrame f = new JFrame("Starting");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Adding padding

        JLabel sabLabel = new JLabel("How many saboteurs?");
        sabLabel.setFont(sabLabel.getFont().deriveFont(24f)); // Increase label font size

        JSpinner saboteursSpinner = new JSpinner(new SpinnerNumberModel(2, 1, 4, 1));
        Dimension spinnerSize = saboteursSpinner.getPreferredSize();
        spinnerSize = new Dimension(100, spinnerSize.height); // Increase spinner width
        saboteursSpinner.setPreferredSize(spinnerSize);

        JLabel mechLabel = new JLabel("How many mechanics?");
        mechLabel.setFont(mechLabel.getFont().deriveFont(24f)); // Increase label font size

        JSpinner mechanicsSpinner = new JSpinner(new SpinnerNumberModel(2, 1, 4, 1));
        mechanicsSpinner.setPreferredSize(spinnerSize); // Use the same increased spinner width

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            new Controller((int) saboteursSpinner.getValue(), (int) mechanicsSpinner.getValue());
            f.dispose();
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        f.add(sabLabel, constraints);

        constraints.gridx = 1;
        f.add(saboteursSpinner, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        f.add(mechLabel, constraints);

        constraints.gridx = 1;
        f.add(mechanicsSpinner, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        f.add(startButton, constraints);

        f.pack();

    }
}
