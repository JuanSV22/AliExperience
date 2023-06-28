package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AliVentana extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
    private JTextField textField;
    private JComboBox<String> combo1;
    private JList<String> marketList;
    private JButton searchButton;
    private JPanel JMainPanel;
    private JPanel JUpper;
    private JLabel titleLabel;
    private JLabel componentLabel;
    private JLabel modelLabel;
    private JPanel JSecondaryPanel;
    private JScrollPane JScroller;
    private JPanel JLower;

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
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Hi");
        model.addElement("Hiii");
        marketList.setModel(model);
        marketList.addListSelectionListener(this);
        searchButton.setIcon(new ImageIcon("imgFolder/Lupa.png"));
        for (String componente : new String[]{"Batería", "Pantalla", "Speaker", "Puerto de carga", "Cámara", "Panel trasero", "Placa madre", "Motor de vibración", "Flex de pantalla", "Flex de comunicación"}) {
            combo1.addItem(componente);
        }
        componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
        combo1.addItemListener(this);
        titleLabel.setIcon(new ImageIcon("imgFolder/AliExperienceLOGO2.png"));
        setIconImage(new ImageIcon("imgFolder/AliExperienceIcon2x.png").getImage());
        searchButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            System.out.println("SEARCH BUTTON PRESSED"); //Implementar utilidad
        }
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
                case "Cámara" -> componentLabel.setIcon(new ImageIcon("imgFolder/Camara.png"));
                case "Panel trasero" -> componentLabel.setIcon(new ImageIcon("imgFolder/PanelTrasero.png"));
                case "Placa madre" -> componentLabel.setIcon(new ImageIcon("imgFolder/Motherboard.png"));
                case "Motor de vibración" -> componentLabel.setIcon(new ImageIcon("imgFolder/VibracionMotor.png"));
                case "Flex de pantalla" -> componentLabel.setIcon(new ImageIcon("imgFolder/FlexPantalla.png"));
                case "Flex de comunicación" -> componentLabel.setIcon(new ImageIcon("imgFolder/FlexComun.png"));
                default -> componentLabel.setIcon(new ImageIcon("imgFolder/NO.png"));
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == marketList) {
        }
    }
}
