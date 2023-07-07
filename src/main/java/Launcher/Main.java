package Launcher;

import GUI.AliVentana;
import Problema.Pedido;
import Utilities.GestorJSON;

public class Main {
    public static void main(String[] args) {
        /*for (Pedido ignored: GestorJSON.obtenerProductos()) {
            System.out.println(ignored.toString());
            System.out.println(ignored.getImage());
        }*/
        AliVentana window = new AliVentana();
    }
}