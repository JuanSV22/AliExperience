package org.example;

import java.util.Scanner;

public class Pedido {
	private String modelo;
	private String pieza;
	private boolean arreglo;

	public Pedido() {
		generarPedido();
	}

	public String getModelo() {
		return modelo;
	}

	public String getPieza() {
		return pieza;
	}

	public boolean esArreglo() {
		return arreglo;
	}

	public void generarPedido() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el modelo del teléfono: ");
		this.modelo = scanner.next();
		System.out.println("Ingrese la pieza a pedir: ");
		this.pieza = scanner.next();

		boolean validInput = false;
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
		}
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
