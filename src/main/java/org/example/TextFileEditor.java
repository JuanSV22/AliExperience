package org.example;import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileEditor {
    public TextFileEditor() {
        if (!new File("Boletas").exists()) {
            crearCarpeta("Boletas");
        } else {
            System.out.println("La carpeta Boletas/ ha sido creada.");
        }
    }

    public void crearBoleta(String contenido) {
        crearArchivo("Boletas/Boleta" + contarBoletas("Boletas/") + ".txt", contenido);
    }

    public void crearBoleta() {
        crearArchivo("Boletas/Boleta" + contarBoletas("Boletas/") + ".txt", "");
    }

    public String generarRutaArchivo() {
        return "Boletas/Boleta" + contarBoletas("Boletas/") + ".txt";
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

    public void eliminarLineaInventario(String modelo, String pieza) {
        try {
            File archivo = new File("Inventario.txt");
            File archivoTemp = new File("InventarioTemp.txt");

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(archivoTemp));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3 && datos[0].equalsIgnoreCase(modelo) && datos[1].equalsIgnoreCase(pieza)) {
                    // La línea coincide con el modelo y la pieza, no la escribimos en el archivo temporal
                    continue;
                }

                pw.println(linea);
            }

            br.close();
            pw.close();

            // Eliminamos el archivo original y renombramos el archivo temporal
            archivo.delete();
            archivoTemp.renameTo(archivo);

            System.out.println("Línea eliminada del inventario.");
        } catch (IOException e) {
            System.out.println("Error al eliminar la línea del inventario: " + e.getMessage());
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
        File file = new File(ruta);
        return file.toString();
    }

    public void eliminarLinea(String ruta, String contenido) {
        String lineToRemove = "posicion 6";
        File inputFile = new File("C:\\Data\\archivo.txt");
        File outputFile = new File("C:\\Data\\archivo_nuevo.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.trim().equals(lineToRemove)) {
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

    public int contarBoletas(String ruta) {
        int num = 0;
        while (new File(ruta + "Boleta" + num + ".txt").exists()) {
            num++;
        }
        return num;
    }
}