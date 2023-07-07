package GUI;

import Problema.*;
import Utilities.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class AliVentana extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
    private JTextField textField;
    private JComboBox<String> combo1;
    private JList<Pedido> marketList;
    private JButton searchButton;
    private JPanel JMainPanel;
    private JPanel JUpper;
    private JLabel titleLabel;
    private JLabel componentLabel;
    private JLabel modelLabel;
    private JPanel JSecondaryPanel;
    private JScrollPane JScroller;
    private JPanel JLower;
    private JLabel TableObjects;
    private DefaultListModel<Pedido> model;


    public AliVentana() {
        setBounds(100, 200, 350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AliExperience");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(JMainPanel);
        System.out.println("Cargando: 1/3");
        TableObjects.setText("<html><tr style='text-align: center;background-color: #f0f0f0;'>" +
                "<th style='width: 92px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Imagen</th>" +
                "<th style='width: 318px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Titulo</th>" +
                "<th style='width: 70px;font-size:x-large;border-right: 3px solid gray; padding: 8px;'>★/5</th>" +
                "<th style='width: 80px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Ventas</th>" +
                "<th style='width: 90px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Envio Gratis</th>" +
                "<th style='width: 90px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Precio</th>" +
                "</tr></html>");

        model = new DefaultListModel<>();
        marketList.addListSelectionListener(this);
        System.out.println("Cargando: 2/3");

        searchButton.setIcon(new ImageIcon("imgFolder/Lupa.png"));
        for (String componente : new String[]{"Batería", "Pantalla", "Speaker", "Puerto de carga", "Cámara", "Panel trasero", "Placa madre", "Motor de vibración", "Flex de pantalla", "Flex de comunicación"}) {
            combo1.addItem(componente);
        }
        componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
        combo1.addItemListener(this);
        titleLabel.setIcon(new ImageIcon("imgFolder/AliExperienceLOGO3.png"));
        setIconImage(new ImageIcon("imgFolder/AliExperienceIcon2x.png").getImage());
        searchButton.addActionListener(this);
        System.out.println("Cargando: 3/3");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            model.removeAllElements();
            String searchText = textField.getText();
            String selectedComponent = (String) combo1.getSelectedItem();
            API.buscarProducto(searchText, selectedComponent);
            List<Pedido> pedidosList = GestorJSON.obtenerProductos();
            int pedidoSize = pedidosList.size();
            for (int i = 0; i < pedidoSize; i++) {
                System.out.println((i+1)+"/"+pedidoSize);
                model.addElement(pedidosList.get(i));
            }
            marketList.setModel(model);
            marketList.setCellRenderer(new PedidoCellRenderer());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
            switch (seleccionado) {
                case "Batería" -> componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
                case "Display" -> componentLabel.setIcon(new ImageIcon("imgFolder/Pantalla.png"));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AliVentana();
        });
    }
}
