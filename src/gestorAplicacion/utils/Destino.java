package gestorAplicacion.utils;

import java.util.ArrayList;

public class Destino {

    private String ciudad;
    private String pais;
    private int distancia;
    private boolean solicitaVisa;
    private int visitantes;
    private ArrayList<Hotel> hoteles = new ArrayList<>();
    public static ArrayList<Destino> destinos = new ArrayList<>();

    public Destino(String ciudad, String pais, int distancia) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.distancia = distancia;
        destinos.add(this);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNombre(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
