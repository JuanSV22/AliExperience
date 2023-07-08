package GUI;

import Problema.Pedido;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que define un renderizador de celdas para mostrar objetos de tipo Pedido en un JList.
 */
public class PedidoCellRenderer extends JLabel implements ListCellRenderer<Pedido> {

    /**
     * Constructor de la clase PedidoCellRenderer.
     * Configura las propiedades del JLabel utilizado como renderizador de celdas.
     */
    public PedidoCellRenderer() {
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    /**
     * Método que es llamado por el JList para obtener la representación visual de un objeto Pedido en una celda.
     *
     * @param list           La lista que contiene la celda.
     * @param value          El objeto Pedido a representar en la celda.
     * @param index          El índice de la celda a representar.
     * @param isSelected    Indica si la celda está seleccionada.
     * @param cellHasFocus   Indica si la celda tiene el foco.
     * @return               El componente visual que representa la celda.
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Pedido> list, Pedido value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        // Configuración de la representación visual de la celda
        setIcon(new ImageIcon(value.getImage()));
        String envioGratisText = value.getEnvioGratis().equals("No") ? "No" : "Sí";
        String tituloText = "<html><div style='width: 300px; text-align: center; word-wrap: break-word;'>"
                + value.getTitulo() + "</div></html>";
        String labelText = "<html><div style='font-size: 14pt;'>" +
                "<table style='width: 100%; border-collapse: collapse;'>" +
                "<tr><td style='border-right: 3px solid gray; padding: 5px;'><center><img src='"
                + value.getImage() + "' width='100' height='100'></center></td>" +
                "<td style='text-align: center;border-right: 3px solid gray; padding: 8px;'>"
                + tituloText + "</td>" +
                "<td style='text-align: center;font-size:x-large;width: 70px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>"
                + (value.getEstrellas() == null ? "N/A" : value.getEstrellas()) + "</td>" +
                "<td style='text-align: center;font-size:large;width: 80px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>"
                + value.getVentas() + "</td>" +
                "<td style='text-align: center;font-size:x-large;width: 90px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>"
                + envioGratisText + "</td>" +
                "<td style='text-align: center;font-size:x-large;width: 100px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>"
                + value.getPrecio() + "</td></tr>" +
                "</table></div></html>";
        setText(labelText);

        // Configuración del aspecto visual de la celda seleccionada o no seleccionada
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
