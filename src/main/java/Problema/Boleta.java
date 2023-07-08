package Problema;

import Utilities.TextFileEditor;

import java.io.File;
import java.util.ArrayList;

public class Boleta {
	private static Boleta instancia;
	private ArrayList<String> listaBoleta = new ArrayList<String>();
	public Boleta() {
	}

	public void crearBoleta() {
		TextFileEditor tf = new TextFileEditor();
		tf.crearArchivo("src/main/java/Datos/Boleta" + contarBoletas("src/main/java/Datos/") + ".txt", "Su boleta: "+ listaBoleta.toString());
	}

	public int contarBoletas(String ruta) {
		int num = 0;
		while (new File(ruta + "Boleta" + num + ".txt").exists()) {
			num++;
		}
		return num;
	}
	public int getBoletaActual(String ruta) {
		int num = 0;
		while (new File(ruta + "Boleta" + num + ".txt").exists()) {
			num++;
		}
		return num-1;
	}
	public void addListaBoletas(Object datos){
		listaBoleta.add(String.valueOf(datos));
	}
	public Object calculoManoObra(Object obj){
		int numeroAuxiliar = Integer.parseInt((String) obj);
		return 0.3 * numeroAuxiliar;
	}
	public void removeListaBoletas(Object datos){
		listaBoleta.remove(String.valueOf(datos));
	}
	public static Boleta getInstancia() {
		if (instancia == null) {
			instancia = new Boleta();
		}
		return instancia;
	}
	@Override
	public String toString() {
		return "Boleta{" + "listaBoleta=" + listaBoleta + '}';
	}
}
