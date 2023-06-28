package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public API() {
    }

    public static void buscarProducto(String textoModelo, String textoProducto) {
        String url = "https://aliexpress-datahub.p.rapidapi.com/item_search?q="+ textoModelo + "%20" + textoProducto + "https://aliexpress-datahub.p.rapidapi.com/item_search?q=iphone&page=1&sort=salesDesc&locale=es_ES&region=CL&currency=CLP"+ "&page=1&sort=salesDesc&locale=es_ES&region=CL&currency=CLP";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "27853c9435mshc1d2903e7f58c29p1c6dd8jsn5119df02a414")
                .header("X-RapidAPI-Host", "aliexpress-datahub.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
    }
    public static void infoEnvio(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://aliexpress-datahub.p.rapidapi.com/shipping_detail?itemId=3256804591426248&quantity=1&ext=bVkg9vW8ihgAMt4XYtZhMB3rnoY6MGI8Sk1gfrl4IGWuBdZZb0gRv5vgI1r5DIn8Rj7mxVzOKbKpyHkmBItRm_k2dtJ1j_gHLTu5zNN9jXHeQploYHEajpnygmD_xKGbi9I_HzxO8TtoIpwdvl5ZfH6o_x5qCBy5D1cUo6t7LoDhx7UTHmFDiCHY0PpHokfJ&region=CL&locale=es_ES&currency=CLP"))
                .header("X-RapidAPI-Key", "27853c9435mshc1d2903e7f58c29p1c6dd8jsn5119df02a414")
                .header("X-RapidAPI-Host", "aliexpress-datahub.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
    }

}
