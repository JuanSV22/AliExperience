package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Problema.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para gestionar datos en formato JSON.
 */
public class GestorJSON {
    public GestorJSON() {
    }

    /**
     * Obtiene la lista de productos a partir de un archivo JSON.
     *
     * @return La lista de productos obtenida.
     */
    public static List<Pedido> obtenerProductos() {
        List<Pedido> productos = new ArrayList<>();

        JSONArray productosJSON = TextFileEditor.parsearArchivoJSON("src/main/java/Datos/productos.json");
        JSONObject resultados = (JSONObject) ((JSONObject) productosJSON.get(0)).get("result");
        JSONArray listaResultados = (JSONArray) resultados.get("resultList");

        for (Object jsonProducto : listaResultados) {
            JSONObject jsonSiguiente = (JSONObject) jsonProducto;
            Pedido producto = new Pedido();

            JSONObject item = (JSONObject) (jsonSiguiente.get("item"));
            JSONObject sku = (JSONObject) (item.get("sku"));
            JSONObject def = (JSONObject) (sku.get("def"));
            JSONObject delivery = (JSONObject) (jsonSiguiente.get("delivery"));

            obtenerAtributosProducto(producto, item, def, delivery);
            productos.add(producto);
        }
        return productos;
    }

    /**
     * Obtiene los atributos de un producto a partir de objetos JSON y los establece en un objeto Pedido.
     *
     * @param producto  El objeto Pedido en el que se establecerán los atributos del producto.
     * @param item      El objeto JSON que contiene los datos generales del producto.
     * @param def       El objeto JSON que contiene los datos específicos del producto.
     * @param delivery  El objeto JSON que contiene los datos de envío del producto.
     */
    public static void obtenerAtributosProducto(Pedido producto, JSONObject item, JSONObject def, JSONObject delivery) {
        producto.setTitulo(item.get("title"));
        producto.setEstrellas(item.get("averageStarRate"));
        producto.setVentas(item.get("sales"));
        producto.setEnvioGratis(delivery.get("freeShipping"));
        producto.setImage("https:" + item.get("image"));
        producto.setPrecio(def.get("promotionPrice"));
    }
}
