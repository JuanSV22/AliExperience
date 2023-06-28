package org.example;

import Utilities.API;

import java.util.Scanner;

public class Pedido {
	private String modelo;
	private String pieza;
	private boolean arreglo;

	public Pedido() {
		generarPedido();
	}

	public boolean esArreglo() {
		return arreglo;
	}

	public void generarPedido() {
		Scanner scanner = new Scanner(System.in);
		API.buscarProducto(this.modelo, this.pieza);

		/* boolean validInput = false;
		while (!validInput) {
			System.out.println("¿Es un pedido para un arreglo? (true/false): ");
			String input = scanner.next();
			if (input.equalsIgnoreCase("true")) {
				this.arreglo = true;
				validInput = true;
			} else if (input.equalsIgnoreCase("false")) {
				this.arreglo = false;
				validInput = true;
			} else {
				System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
			}
		}*/
	}

	public boolean comparadorConArchivo() {
		TextFileEditor tf = new TextFileEditor();
		tf.leerArchivo("");
		return true;
	}

	@Override
	public String toString() {
		return "Modelo: " + this.modelo + ", Pieza: " + this.pieza + ", Arreglo: " + this.arreglo;
	}
}
