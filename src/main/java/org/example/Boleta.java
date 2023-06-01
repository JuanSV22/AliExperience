package org.example;

public class Boleta {
	private Pedido datoPedido = new Pedido();

	public String guardarBoleta() {
		TextFileEditor tf = new TextFileEditor();
		tf.crearArchivo("",datoPedido.toString());
		return tf.leerArchivo("");
	}

}