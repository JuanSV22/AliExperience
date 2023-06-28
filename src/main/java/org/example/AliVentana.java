package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AliVentana extends JFrame implements ActionListener, ItemListener {
    private JTextField textField;
    private JComboBox<String> combo1;
    private JList<String> list1;
    private JButton nextButton;
    private JPanel JMainPanel;
    private JPanel JUpper;
    private JLabel titleLabel;
    private JLabel componentLabel;
    private JLabel modelLabel;
    private JPanel JSecondaryPanel;

    public AliVentana() {
        setBounds(100, 200, 350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AliExperience");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setResizable(true);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(JMainPanel);
        nextButton.setIcon(new ImageIcon("imgFolder/Lupa.png"));
        for (String componente:new String[]{"Batería","Pantalla","Speaker","Puerto de carga","Cámara","Panel trasero","Placa madre","Motor de vibración","Flex de pantalla","Flex de comunicación"}) {
            combo1.addItem(componente);
        }
        componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
        combo1.addItemListener(this);
        titleLabel.setIcon(new ImageIcon("imgFolder/AliExperienceLOGO2.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
            switch (seleccionado) {
                case "Batería" -> componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
                case "Pantalla" -> componentLabel.setIcon(new ImageIcon("imgFolder/Pantalla.png"));
                case "Speaker" -> componentLabel.setIcon(new ImageIcon("imgFolder/Speaker.png"));
                case "Puerto de carga" -> componentLabel.setIcon(new ImageIcon("imgFolder/CargaPuerto.png"));
                default -> componentLabel.setIcon(new ImageIcon("imgFolder/NO.png"));
            }
        }
    }
}
