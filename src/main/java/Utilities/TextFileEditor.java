package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileEditor {
    public TextFileEditor() {
        if (!new File("Boletas").exists()) {
            crearCarpeta("Boletas");
        } else {
            System.out.println("La carpeta Boletas/ ha sido creada.");
        }
    }

    public static void escribirArchivoJSON(String ruta, String contenido) {
        try {
            FileWriter myWriter = new FileWriter(ruta);
            myWriter.write("["+contenido+"]");
            myWriter.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("No se pudo escribir");
        }
    }

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

    public void crearArchivo(String ruta, String contenido) {
        Path archivo = Paths.get(ruta);
        try {
            Files.write(archivo, contenido.getBytes());
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser creado");
        }
    }
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