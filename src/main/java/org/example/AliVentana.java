package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AliVentana extends JFrame implements ActionListener {
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JList<String> list1;
    private JButton nextButton;
    private JPanel JMainPanel;

    public AliVentana() {
        setTitle("AliExperience");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setResizable(true);
        setContentPane(JMainPanel);
        setVisible(true);
        nextButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AliVentana window = new AliVentana();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
