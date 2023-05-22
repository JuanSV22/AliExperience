package org.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TextFileEditor {

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";

        // Cargar Archivo.
        String fileContent = loadFile(filePath);
        System.out.println("File content:");
        System.out.println(fileContent);

        // Editar Archivo.
        String editedContent = editFileContent(fileContent);

        // Guardar el archivo cambiado.
        saveFile(filePath, editedContent);
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

    public static String editFileContent(String fileContent) {
        // Aplicar el cambio deseado a fileContent
        // Por ejemplo, cambiar el texto entero a mayusculas.
        return fileContent.toUpperCase();
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
        String contenido = "";
        Path archivo = Paths.get(ruta);
        try{
            contenido = new String(Files.readAllBytes(archivo));
        }catch(IOException e){
            System.out.println("El archivo no pudo ser leido");
        }
        return contenido;
    }
    public void nuevaLinea(String ruta, String contenido){
        String oldFile = leerArchivo(ruta);
        String newFile = oldFile+"\n"+contenido;
        crearArchivo(ruta, newFile);
    }
    public String[] listaArchivos(String ruta) {
        File f = new File(ruta);
        String[] archivos = f.list();
        return archivos;
    }
}