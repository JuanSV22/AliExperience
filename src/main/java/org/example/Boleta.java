package org.example;

public class Boleta {
	private Pedido datoPedido;
	public Boleta(Pedido datoPedido) {
		this.datoPedido = datoPedido;
	}

	public String guardarBoleta() { //Crea el archivo .txt en la ruta.
		TextFileEditor tf = new TextFileEditor();
		tf.crearArchivo("",this.toString());
		return tf.leerArchivo("");
	}

	@Override
	public String toString() {
		return "Boleta{" +
				"datoPedido=" + datoPedido +
				'}';
	}
}