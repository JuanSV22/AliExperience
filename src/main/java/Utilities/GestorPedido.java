package Utilities;

import java.util.Scanner;

public class GestorPedido {
	public void modificarInventario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el modelo del teléfono a eliminar: ");
		String modelo = scanner.next();
		System.out.println("Ingrese la pieza a eliminar: ");
		String pieza = scanner.next();

		TextFileEditor gestorArchivos = new TextFileEditor();
		gestorArchivos.eliminarLineaInventario(modelo, pieza);
	}


	public void consultarDisponibilidad() {
		TextFileEditor textFile = new TextFileEditor();
		textFile.leerArchivo("");
	}
}