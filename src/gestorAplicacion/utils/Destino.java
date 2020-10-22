package gestorAplicacion.utils;

import java.util.ArrayList;

public class Destino {

    private String nombre;
    private int distancia;
    private boolean pideVisa;
    private int visitantes;
    private ArrayList<Hotel> hoteles = new ArrayList<>();
    public static ArrayList<Destino> destinos = new ArrayList<>();

    public Destino(String nombre, int distancia, boolean pideVisa) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.pideVisa = pideVisa;
        destinos.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

}
