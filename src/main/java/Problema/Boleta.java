package Problema;

import Utilities.TextFileEditor;

import java.io.File;
import java.util.ArrayList;

public class Boleta {
	private ArrayList<String> listaBoleta = new ArrayList<String>();
	private String ruta;
	public String getRuta() {
		return ruta;
	}

	public Boleta() {
		this.ruta = generarRutaArchivo();
	}

	public void crearBoleta() {
		TextFileEditor tf = new TextFileEditor();
		tf.crearArchivo("Boletas/Boleta" + contarBoletas("Boletas/") + ".txt", this.toString());
	}
	public String generarRutaArchivo() {
		return "Boletas/Boleta" + contarBoletas("Boletas/") + ".txt";
	}
	public int contarBoletas(String ruta) {
		int num = 0;
		while (new File(ruta + "Boleta" + num + ".txt").exists()) {
			num++;
		}
		return num;
	}
	public void addListaBoletas(Object datos){
		listaBoleta.add(String.valueOf(datos));
	}
}
