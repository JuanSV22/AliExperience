package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase de utilidades para interactuar con la API de AliExpress.
 */
public class API {
    public API() {
    }

    /**
     * Realiza una búsqueda de productos en la API de AliExpress y guarda los resultados en un archivo JSON.
     *
     * @param textoModelo    El texto del modelo a buscar.
     * @param textoProducto  El texto del producto a buscar.
     */
    public static void buscarProducto(String textoModelo, String textoProducto) {
        String output = textoModelo.replace(" ", "%20");
        String url = "https://aliexpress-datahub.p.rapidapi.com/item_search?q=" + output + "%20" + textoProducto + "&page=1&sort=salesDesc&locale=es_ES&region=CL&currency=CLP";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "27853c9435mshc1d2903e7f58c29p1c6dd8jsn5119df02a414")
                .header("X-RapidAPI-Host", "aliexpress-datahub.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        TextFileEditor.escribirArchivoJSON("src/main/java/Datos/productos.json", response.body());
    }

    /**
     * Obtiene información de envío de un producto de la API de AliExpress.
     */
    public static void infoEnvio() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://aliexpress-datahub.p.rapidapi.com/shipping_detail?itemId=3256804591426248&quantity=1&ext=bVkg9vW8ihgAMt4XYtZhMB3rnoY6MGI8Sk1gfrl4IGWuBdZZb0gRv5vgI1r5DIn8Rj7mxVzOKbKpyHkmBItRm_k2dtJ1j_gHLTu5zNN9jXHeQploYHEajpnygmD_xKGbi9I_HzxO8TtoIpwdvl5ZfH6o_x5qCBy5D1cUo6t7LoDhx7UTHmFDiCHY0PpHokfJ&region=CL&locale=es_ES&currency=CLP"))
                .header("X-RapidAPI-Key", "27853c9435mshc1d2903e7f58c29p1c6dd8jsn5119df02a414")
                .header("X-RapidAPI-Host", "aliexpress-datahub.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
    }
}
