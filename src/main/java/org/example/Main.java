package org.example;

public class Main {
    public static void main(String[] args) {
        AliVentana window = new AliVentana();
        /*
        Pedido cotizacion = new Pedido();
        Boleta bol = new Boleta();
        bol.addPedido(cotizacion);
        bol.guardarBoleta();*/
    }

    private static void editarBoleta(Boleta nuevaBoleta) {
        TextFileEditor.saveFile(nuevaBoleta.getRuta(), nuevaBoleta.toString() + "EDSDSDSSD");
    }
}