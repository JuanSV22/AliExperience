package org.example;

import java.util.Scanner;

public class Pedido {

	private String modelo;
	private String pieza;

	public Pedido() {
		generarPedido();
	}
	public String getModelo() {
		return this.modelo;
	}
	public String getPieza() {
		return this.pieza;
	}

	public void generarPedido() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el modelo del teléfono: ");
		this.modelo = scanner.next();
		System.out.println("Ingrese la pieza a pedir: ");
		this.pieza = scanner.next();
	}
	public boolean comparadorConArchivo(){
		TextFileEditor tf = new TextFileEditor();
		tf.leerArchivo("");
		return true;
	}

	@Override
	public String toString() {
		return "Modelo: "+ this.modelo + ", Pieza: " + this.pieza;
	}
}