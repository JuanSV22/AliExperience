package GUI;

import Problema.Pedido;

import javax.swing.*;
import java.awt.*;

public class PedidoCellRenderer extends JLabel implements ListCellRenderer<Pedido> {

    public PedidoCellRenderer() {
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Pedido> list, Pedido value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setIcon(new ImageIcon(value.getImage()));
        String envioGratisText = value.getEnvioGratis().equals("No") ? "No" : "Sí";
        String tituloText = "<html><div style='width: 300px; text-align: center; word-wrap: break-word;'>" + value.getTitulo() + "</div></html>";
        String labelText = "<html><div style='font-size: 14pt;'>" +
                "<table style='width: 100%; border-collapse: collapse;'>" +
                "<tr><td style='border-right: 3px solid gray; padding: 5px;'><center><img src='" + value.getImage() + "' width='100' height='100'></center></td>" +
                "<td style='text-align: center;border-right: 3px solid gray; padding: 8px;'>" + tituloText + "</td>" +
                "<td style='text-align: center;font-size:x-large;width: 70px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>" + (value.getEstrellas() == null ? "N/A" : value.getEstrellas()) + "</td>" +
                "<td style='text-align: center;font-size:large;width: 80px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>" + value.getVentas() + "</td>" +
                "<td style='text-align: center;font-size:x-large;width: 90px;border-right: 3px solid gray; padding: 8px; word-wrap: break-word'>" + envioGratisText + "</td></tr>" +
                "</table></div></html>";
        setText(labelText);

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
