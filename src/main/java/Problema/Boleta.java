package Problema;

import Utilities.TextFileEditor;

public class Boleta {
	private Pedido[] datosPedido = {};
	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public Boleta() {
		TextFileEditor tf = new TextFileEditor();
		this.ruta = tf.generarRutaArchivo();
	}

	public void addPedido(Pedido datoPedido) {
		Pedido[] newPed = new Pedido[this.datosPedido.length + 1];
		System.arraycopy(this.datosPedido, 0, newPed, 0, this.datosPedido.length);
		newPed[this.datosPedido.length] = datoPedido;
		this.datosPedido = newPed;
	}

	public void guardarBoleta() {
		TextFileEditor tf = new TextFileEditor();
		tf.crearBoleta(this.toString());
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder("{\n");
		for (Pedido pedido : this.datosPedido) {
			strBuilder.append("\t").append(pedido.toString()).append("\n");
		}
		strBuilder.append("}");
		return strBuilder.toString();
	}

	/*public void generarBoleta() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Detalle de la boleta:\n");
		for (Pedido pedido : this.datosPedido) {
			strBuilder.append("Modelo: ").append(pedido.getModelo()).append("\n");
			strBuilder.append("Pieza: ").append(pedido.getPieza()).append("\n");
			if (pedido.esArreglo()) {
				strBuilder.append("Tipo de pedido: Arreglo\n");
			} else {
				strBuilder.append("Tipo de pedido: Cotización\n");
			}
			strBuilder.append("\n");
		}
		TextFileEditor tf = new TextFileEditor();
		tf.crearBoleta(strBuilder.toString());
	}*/
}
