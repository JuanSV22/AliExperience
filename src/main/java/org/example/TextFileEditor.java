package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
}