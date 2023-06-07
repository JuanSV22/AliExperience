package org.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TextFileEditor {

    public TextFileEditor() {
        if (!(new File("Boletas\\").exists())) { //Revisa si la carpeta NO existe.
            crearCarpeta("Boletas");
        } else {System.out.println("La carpeta Boletas\\ ha sido creada.");}
    }
    public void crearBoleta(String content) {
        crearArchivo("Boletas\\Boleta" + contarBoletas("Boletas\\") + ".txt", content);
    }
    public void crearBoleta() {
        crearArchivo("Boletas\\Boleta" + contarBoletas("Boletas\\") + ".txt","");
    }
    public String generarRutaArchivo() {
        return "Boletas\\Boleta" + contarBoletas("Boletas\\") + ".txt";
    }

    public static String loadFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void saveFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void crearCarpeta(String ruta){
        Path directorio = Paths.get(ruta);
        if(Files.exists(directorio)){
            System.out.println("El archivo ya existe");
        }else{
            try{
                Files.createDirectories(directorio);
            }catch(Exception e){
                System.out.println("El directorio no pudo ser creado");
            }
        }
    }

    public void crearArchivo(String ruta, String contenido){
        Path archivo = Paths.get(ruta);
        try{
            Files.write(archivo,contenido.getBytes());
        }catch (IOException e){
            System.out.println("El archivo no pudo ser creado");
        }
    }

    public String leerArchivo(String ruta){
        File file = new File(ruta);
        return file.toString();
    }
    public void eliminarLinea(String ruta, String contenido){
        String lineToRemove = "posicion 6";

        File inputFile = new File("C:\\Data\\archivo.txt");
        File outputFile = new File("C:\\Data\\archivo_nuevo.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.trim().equals(lineToRemove)){
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] listaArchivos(String ruta) {
        File f = new File(ruta);
        String[] archivos = f.list();
        return archivos;
    }

    public int contarBoletas(String ruta){
        int num = 0;
        while (new File(ruta+"Boleta"+num+".txt").exists()) {
            num++;
        }
        return num;
    }
}