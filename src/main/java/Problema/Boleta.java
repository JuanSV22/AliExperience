package Problema;

import Utilities.TextFileEditor;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que representa una boleta de compra.
 */
public class Boleta {
	private static Boleta instancia;
	private ArrayList<String> listaBoleta = new ArrayList<String>();

	private Boleta() {
	}

	/**
	 * Crea una nueva boleta y guarda los datos en un archivo de texto.
	 */
	public void crearBoleta() {
		TextFileEditor tf = new TextFileEditor();
		tf.crearArchivo("src/main/java/Datos/Boleta" + contarBoletas("src/main/java/Datos/") + ".txt", "Su boleta: " + listaBoleta.toString());
	}

	/**
	 * Cuenta el número de boletas existentes en la ruta especificada.
	 *
	 * @param ruta La ruta donde se encuentran las boletas.
	 * @return El número de boletas existentes.
	 */
	public int contarBoletas(String ruta) {
		int num = 0;
		while (new File(ruta + "Boleta" + num + ".txt").exists()) {
			num++;
		}
		return num;
	}

	/**
	 * Obtiene el número de la boleta actual.
	 *
	 * @param ruta La ruta donde se encuentran las boletas.
	 * @return El número de la boleta actual.
	 */
	public int getBoletaActual(String ruta) {
		int num = 0;
		while (new File(ruta + "Boleta" + num + ".txt").exists()) {
			num++;
		}
		return num - 1;
	}

	/**
	 * Agrega datos a la lista de la boleta.
	 *
	 * @param datos Los datos a agregar.
	 */
	public void addListaBoletas(Object datos) {
		listaBoleta.add(String.valueOf(datos));
	}

	/**
	 * Calcula el costo de mano de obra basado en el objeto especificado.
	 *
	 * @param obj El objeto para el cálculo de mano de obra.
	 * @return El costo de mano de obra calculado.
	 */
	public Object calculoManoObra(Object obj) {
		int numeroAuxiliar = Integer.parseInt((String) obj);
		return 0.3 * numeroAuxiliar;
	}

	/**
	 * Elimina datos de la lista de la boleta.
	 *
	 * @param datos Los datos a eliminar.
	 */
	public void removeListaBoletas(Object datos) {
		listaBoleta.remove(String.valueOf(datos));
	}

	/**
	 * Obtiene la instancia única de la clase Boleta utilizando el patrón Singleton.
	 *
	 * @return La instancia única de Boleta.
	 */
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
