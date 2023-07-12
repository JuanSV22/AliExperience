package Problema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoletaTest {

    @Test
    public void testCrearBoleta() {
        Boleta boleta = Boleta.getInstancia();
        boleta.addListaBoletas("Producto A");
        boleta.addListaBoletas("Producto B");

        int boletasAntes = boleta.contarBoletas("src/main/java/Datos/");

        boleta.crearBoleta();

        int boletasDespues = boleta.contarBoletas("src/main/java/Datos/");

        assertEquals(boletasAntes + 1, boletasDespues);
    }

    @Test
    public void testAddListaBoletas() {
        Boleta boleta = Boleta.getInstancia();
        boleta.addListaBoletas("Producto A");

        String boletaToString = boleta.toString();

        assertTrue(boletaToString.contains("Producto A"));
    }

    @Test
    public void testCalculoManoObra() {
        Boleta boleta = Boleta.getInstancia();
        Object resultado = boleta.calculoManoObra("100");

        assertEquals(30.0, resultado);
    }
}
