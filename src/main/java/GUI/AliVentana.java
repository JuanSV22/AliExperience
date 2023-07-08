package GUI;

import Problema.*;
import Utilities.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la ventana principal de la aplicación AliExperience.
 */
public class AliVentana extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
    private JTextField textField; // Campo de texto para ingresar el texto de búsqueda
    private JComboBox<String> combo1; // ComboBox para seleccionar el componente
    private JList<Pedido> marketList; // Lista de pedidos
    private JButton searchButton; // Botón de búsqueda
    private JPanel JMainPanel; // Panel principal
    private JPanel JUpper; // Panel superior
    private JLabel titleLabel; // Etiqueta de título
    private JLabel componentLabel; // Etiqueta de componente
    private JLabel modelLabel; // Etiqueta de modelo
    private JPanel JSecondaryPanel; // Panel secundario
    private JScrollPane JScroller; // Panel de desplazamiento
    private JPanel JLower; // Panel inferior
    private JLabel TableObjects; // Etiqueta de objetos de tabla
    private JButton saveButton; // Botón de guardar
    private DefaultListModel<Pedido> model; // Modelo de lista de pedidos

    /**
     * Constructor de la clase AliVentana.
     * Configura la apariencia y comportamiento de la ventana.
     * Inicializa los componentes y agrega los listeners necesarios.
     */
    public AliVentana() {
        // Configuración de la ventana
        setBounds(100, 200, 350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AliExperience");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(JMainPanel);

        // Configuración de la etiqueta de la tabla de objetos
        TableObjects.setText("<html><tr style='text-align: center;background-color: #f0f0f0;'>" +
                "<th style='width: 92px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Imagen</th>" +
                "<th style='width: 318px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Titulo</th>" +
                "<th style='width: 70px;font-size:x-large;border-right: 3px solid gray; padding: 8px;'>★/5</th>" +
                "<th style='width: 80px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Ventas</th>" +
                "<th style='width: 90px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Envio Gratis</th>" +
                "<th style='width: 90px;font-size:large;border-right: 3px solid gray; padding: 8px;'>Precio</th>" +
                "</tr></html>");

        // Inicialización del modelo de la lista y asignación de listeners
        model = new DefaultListModel<>();
        marketList.addListSelectionListener(this);

        // Configuración de botones, combobox, etiquetas y otros componentes
        searchButton.setIcon(new ImageIcon("imgFolder/Lupa.png"));
        for (String componente : new String[]{"Pantalla","Batería", "Speaker", "Puerto de carga", "Cámara", "Panel trasero", "Placa madre", "Motor de vibración", "Flex de pantalla", "Flex de comunicación"}) {
            combo1.addItem(componente);
        }
        componentLabel.setIcon(new ImageIcon("imgFolder/Pantalla.png"));
        combo1.addItemListener(this);
        titleLabel.setIcon(new ImageIcon("imgFolder/AliExperienceLOGO3.png"));
        setIconImage(new ImageIcon("imgFolder/AliExperienceIcon2x.png").getImage());
        searchButton.addActionListener(this);
        saveButton.setVisible(false);
        saveButton.setIcon(new ImageIcon("imgFolder/Cart.png"));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boleta boleta = Boleta.getInstancia();
                TextFileEditor tf = new TextFileEditor();
                boleta.crearBoleta();
                JOptionPane.showMessageDialog(AliVentana.this, tf.leerArchivo("src/main/java/Datos/Boleta" + boleta.getBoletaActual("src/main/java/Datos/") + ".txt"), "Boleta", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Configuración del comportamiento del mouse en la lista de productos
        marketList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object object;
                Boleta boleta = Boleta.getInstancia();
                int index = marketList.locationToIndex(e.getPoint());
                if (marketList.isSelectedIndex(index)) {
                    object = marketList.getModel().getElementAt(index).getPrecio();
                    boleta.addListaBoletas(object);
                    boleta.addListaBoletas(boleta.calculoManoObra(object));

                }else{
                    object = marketList.getModel().getElementAt(index).getPrecio();
                    boleta.removeListaBoletas(object);
                    boleta.removeListaBoletas(boleta.calculoManoObra(object));
                }
            }
        });

        setVisible(true);
    }

    /**
     * Método que se ejecuta cuando se realiza una acción en algún componente de la interfaz.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            // Eliminar los elementos anteriores del modelo de la lista
            model.removeAllElements();
            // Obtener el texto de búsqueda y el componente seleccionado
            String searchText = textField.getText();
            String selectedComponent = (String) combo1.getSelectedItem();
            // Realizar la búsqueda de productos y obtener la lista de pedidos
            API.buscarProducto(searchText, selectedComponent);
            List<Pedido> pedidosList = GestorJSON.obtenerProductos();
            int pedidoSize = pedidosList.size();
            // Agregar los pedidos al modelo de la lista
            for (int i = 0; i < pedidoSize; i++) {
                System.out.println((i+1)+"/"+pedidoSize);
                model.addElement(pedidosList.get(i));
            }
            marketList.setModel(model);
            marketList.setCellRenderer(new PedidoCellRenderer());
            saveButton.setVisible(true);
        }
    }

    /**
     * Método que se ejecuta cuando se realiza un cambio en el estado de un item seleccionado en un JComboBox.
     *
     * @param e El evento de cambio de estado del item seleccionado.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo1) {
            String seleccionado = (String) combo1.getSelectedItem();
            switch (seleccionado) {
                case "Pantalla" -> componentLabel.setIcon(new ImageIcon("imgFolder/Pantalla.png"));
                case "Batería" -> componentLabel.setIcon(new ImageIcon("imgFolder/Battery.png"));
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

    /**
     * Método que se ejecuta cuando se produce un cambio de selección en la lista de productos.
     *
     * @param e El evento de cambio de selección.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == marketList) {
            // Lógica a realizar cuando se selecciona un elemento de la lista
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AliVentana();
        });
    }
}
