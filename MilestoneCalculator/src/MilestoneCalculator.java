import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MilestoneCalculator extends JFrame implements ActionListener {
    private JLabel milestone1Label, milestone2Label, terminalLabel, resultLabel;
    private JTextField milestone1Field, milestone2Field, terminalField;
    private JButton calculateButton;

    public MilestoneCalculator() {
        setTitle("Milestone Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        milestone1Label = new JLabel("Milestone 1 Grade:");
        milestone1Field = new JTextField();
        milestone2Label = new JLabel("Milestone 2 Grade:");
        milestone2Field = new JTextField();
        terminalLabel = new JLabel("Terminal Assessment Grade:");
        terminalField = new JTextField();

        panel.add(milestone1Label);
        panel.add(milestone1Field);
        panel.add(milestone2Label);
        panel.add(milestone2Field);
        panel.add(terminalLabel);
        panel.add(terminalField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        resultLabel = new JLabel();

        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double milestone1Grade = Double.parseDouble(milestone1Field.getText());
                double milestone2Grade = Double.parseDouble(milestone2Field.getText());
                double terminalGrade = Double.parseDouble(terminalField.getText());

                if (milestone1Grade < 0 || milestone1Grade > 25 ||
                        milestone2Grade < 0 || milestone2Grade > 40 ||
                        terminalGrade < 0 || terminalGrade > 35) {
                    JOptionPane.showMessageDialog(this, "Grades should be between 0 and the maximum points per milestone.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double totalGrade = milestone1Grade + milestone2Grade + terminalGrade;

                if (totalGrade > 100) {
                    JOptionPane.showMessageDialog(this, "Total grade cannot exceed 100.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                resultLabel.setText("Total grade: " + totalGrade + "%");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid grades.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MilestoneCalculator();
            }
        });
    }
}
