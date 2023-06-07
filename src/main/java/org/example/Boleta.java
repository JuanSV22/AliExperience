package org.example;

public class Boleta {
	private Pedido[] datosPedido={};
	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public Boleta() {
		TextFileEditor tf = new TextFileEditor();
		this.ruta = tf.generarRutaArchivo();
	}
	public void añadirPedido(Pedido datoPedido) {
		Pedido[] newPed = new Pedido[this.datosPedido.length+1];
		for (int i = 0; i < this.datosPedido.length; i++) {
			newPed[i] = this.datosPedido[i];
		}
		newPed[this.datosPedido.length] = datoPedido;
		this.datosPedido = newPed;
	}
	public void guardarBoleta() { //Crea el archivo .txt en la ruta.
		TextFileEditor tf = new TextFileEditor();
		tf.crearBoleta(this.toString());
	}

	@Override
	public String toString() {
		String str = new String();
		str += "{\n";
		StringBuilder strBuilder = new StringBuilder(str);
		for (Pedido pedido: this.datosPedido) {
			strBuilder.append("\t").append(pedido.toString()).append("\n");
		}
		str = strBuilder.toString();
		str += ("}");
		return str;
	}
}