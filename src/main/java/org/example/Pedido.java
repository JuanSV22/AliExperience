package org.example;

public class Pedido {
    private String modelo;
    private String pieza;

    public Pedido() {
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPieza() {
        return pieza;
    }
}
