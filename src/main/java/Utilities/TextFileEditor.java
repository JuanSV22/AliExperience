package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Clase de utilidades para editar archivos de texto y manejar datos en formato JSON.
 */
public class TextFileEditor {
    public TextFileEditor() {
        if (!new File("Boletas").exists()) {
            crearCarpeta("Boletas");
        } else {
            System.out.println("La carpeta Boletas/ ha sido creada.");
        }
    }

    /**
     * Escribe el contenido en un archivo JSON.
     *
     * @param ruta      La ruta del archivo a escribir.
     * @param contenido El contenido a escribir en el archivo.
     */
    public static void escribirArchivoJSON(String ruta, String contenido) {
        try {
            FileWriter myWriter = new FileWriter(ruta);
            myWriter.write("[" + contenido + "]");
            myWriter.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo escribir");
        }
    }

    /**
     * Lee un archivo JSON y lo parsea en un objeto JSONArray.
     *
     * @param ruta La ruta del archivo JSON a parsear.
     * @return El JSONArray obtenido a partir del archivo JSON.
     * @throws RuntimeException Si no se pudo parsear el archivo.
     */
    public static JSONArray parsearArchivoJSON(String ruta) throws RuntimeException {
        try {
            String contenidosJSON = leerContenidosJSON(ruta);
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(contenidosJSON);
        } catch (ParseException e) {
            System.out.println("No se pudo parsear el archivo");
            throw new RuntimeException();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            throw new RuntimeException();
        }
    }

    /**
     * Lee los contenidos de un archivo JSON y los devuelve como una cadena de texto.
     *
     * @param ruta La ruta del archivo JSON a leer.
     * @return Los contenidos del archivo JSON como una cadena de texto.
     * @throws FileNotFoundException Si no se pudo encontrar el archivo.
     */
    public static String leerContenidosJSON(String ruta) throws FileNotFoundException {
        StringBuilder st = new StringBuilder();
        File archivoJSON = new File(ruta);
        Scanner scanner = new Scanner(archivoJSON);
        while (scanner.hasNextLine()) {
            st.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return st.toString();
    }

    /**
     * Crea una carpeta en la ruta especificada.
     *
     * @param ruta La ruta de la carpeta a crear.
     */
    public void crearCarpeta(String ruta) {
        File carpeta = new File(ruta);
        try {
            if (!carpeta.exists()) {
                carpeta.mkdirs();
                System.out.println("La carpeta " + ruta + " ha sido creada.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo crear la carpeta " + ruta + ".");
        }
    }

    /**
     * Crea un archivo en la ruta especificada con el contenido especificado.
     *
     * @param ruta      La ruta del archivo a crear.
     * @param contenido El contenido del archivo a crear.
     */
    public void crearArchivo(String ruta, String contenido) {
        Path archivo = Paths.get(ruta);
        try {
            Files.write(archivo, contenido.getBytes());
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser creado");
        }
    }

    /**
     * Lee el contenido de un archivo y lo devuelve como una cadena de texto.
     *
     * @param ruta La ruta del archivo a leer.
     * @return El contenido del archivo como una cadena de texto.
     */
    public String leerArchivo(String ruta) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
