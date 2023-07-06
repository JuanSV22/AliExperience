package Problema;

public class Pedido {
	private String titulo;
	private String estrellas;
	private String ventas;
	private String envioGratis;

	public Pedido() {
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEstrellas() {
		return estrellas;
	}

	public String getVentas() {
		return ventas;
	}

	public String getEnvioGratis() {
		return envioGratis;
	}

	public void setTitulo(Object titulo) {
		if (titulo == null){
			titulo = "";
		}
		else{
			this.titulo = titulo.toString();
		}

	}

	public void setEstrellas(Object estrellas) {
		if (estrellas == null){
			estrellas = "";
		}
		else{
			this.estrellas = estrellas.toString();
		}
	}

	public void setVentas(Object ventas) {
		if (ventas == null){
			ventas = "";
		}
		else{
			this.ventas = ventas.toString();
		}
	}

	public void setEnvioGratis(Object envioGratis) {
		if (envioGratis == null){
			envioGratis = "";
		}
		else{
			this.envioGratis = envioGratis.toString();
		}
	}
	@Override
	public String toString() {
		return "".concat(String.format("%s: %s\n", "Título", titulo))
				.concat(String.format("%s: %s\n", "Estrellas", estrellas))
				.concat(String.format("%s: %s\n", "Ventas", ventas))
				.concat(String.format("%s: %s\n", "Envío Gratis", envioGratis));
	}
}
