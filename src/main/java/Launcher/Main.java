package Launcher;

import GUI.AliVentana;
import Problema.Boleta;
import Problema.Pedido;
import Utilities.GestorJSON;
import Utilities.TextFileEditor;

public class Main {
    public static void main(String[] args) {
        /*for (Pedido ignored: GestorJSON.obtenerProductos()) {
            System.out.println(ignored.toString());
            System.out.println(ignored.getImage());
        }*/
        AliVentana window = new AliVentana();
    }
}