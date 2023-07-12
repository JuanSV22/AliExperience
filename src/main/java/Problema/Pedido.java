package Problema;

/**
 * Clase que representa un pedido.
 */
public class Pedido {
	private String titulo;
	private String estrellas;
	private String ventas;
	private String envioGratis;
	private String precio;

	private String image;

	/**
	 * Constructor vacío de la clase Pedido.
	 */
	public Pedido() {
	}

	/**
	 * Constructor de la clase Pedido.
	 *
	 * @param image       La imagen del pedido.
	 * @param titulo      El título del pedido.
	 * @param estrellas   Las estrellas del pedido.
	 * @param ventas      Las ventas del pedido.
	 * @param envioGratis El estado de envío gratis del pedido.
	 */
	public Pedido(String image, String titulo, String estrellas, String ventas, String envioGratis) {
		this.image = image;
		this.titulo = titulo;
		this.estrellas = estrellas;
		this.ventas = ventas;
		this.envioGratis = envioGratis;
	}

	/**
	 * Obtiene el título del pedido.
	 *
	 * @return El título del pedido.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Obtiene las estrellas del pedido.
	 *
	 * @return Las estrellas del pedido.
	 */
	public String getEstrellas() {
		return estrellas;
	}

	/**
	 * Obtiene la imagen del pedido.
	 *
	 * @return La imagen del pedido.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Obtiene las ventas del pedido.
	 *
	 * @return Las ventas del pedido.
	 */
	public String getVentas() {
		return ventas;
	}

	/**
	 * Obtiene el precio del pedido.
	 *
	 * @return El precio del pedido.
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * Obtiene el estado de envío gratis del pedido.
	 *
	 * @return El estado de envío gratis del pedido.
	 */
	public String getEnvioGratis() {
		return envioGratis;
	}

	/**
	 * Verifica si el pedido tiene envío gratis.
	 *
	 * @return true si tiene envío gratis, false en caso contrario.
	 */
	public boolean isEnvioGratis() {
		return (envioGratis == "true");
	}

	/**
	 * Establece el título del pedido.
	 *
	 * @param titulo El título a establecer.
	 */
	public void setTitulo(Object titulo) {
		if (titulo == null) {
			titulo = "";
		} else {
			this.titulo = titulo.toString();
		}
	}

	/**
	 * Establece las estrellas del pedido.
	 *
	 * @param estrellas Las estrellas a establecer.
	 */
	public void setEstrellas(Object estrellas) {
		if (estrellas == null) {
			estrellas = "";
		} else {
			this.estrellas = estrellas.toString();
		}
	}

	/**
	 * Establece las ventas del pedido.
	 *
	 * @param ventas Las ventas a establecer.
	 */
	public void setVentas(Object ventas) {
		if (ventas == null) {
			ventas = "";
		} else {
			this.ventas = ventas.toString();
		}
	}

	/**
	 * Establece el estado de envío gratis del pedido.
	 *
	 * @param envioGratis El estado de envío gratis a establecer.
	 */
	public void setEnvioGratis(Object envioGratis) {
		if (envioGratis == null) {
			envioGratis = "";
		} else {
			this.envioGratis = envioGratis.toString();
		}
	}

	/**
	 * Establece la imagen del pedido.
	 *
	 * @param image La imagen a establecer.
	 */
	public void setImage(Object image) {
		if (image == null) {
			image = "";
		} else {
			this.image = image.toString();
		}
	}

	/**
	 * Establece el precio del pedido.
	 *
	 * @param precio El precio a establecer.
	 */
	public void setPrecio(Object precio) {
		if (precio == null) {
			precio = "";
		} else {
			this.precio = precio.toString();
		}
	}

	@Override
	public String toString() {
		return "".concat(String.format("%s: %s\n", "Título", titulo))
				.concat(String.format("%s: %s\n", "Estrellas", estrellas))
				.concat(String.format("%s: %s\n", "Ventas", ventas))
				.concat(String.format("%s: %s\n", "Envío Gratis", envioGratis))
				.concat(String.format("%s: %s\n", "Precio", precio));
	}
}
