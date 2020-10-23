package gestorAplicacion.utils;

import java.util.ArrayList;

public class Destino {

    private String nombre;
    private int distancia;
    private boolean pideVisa;
    private ArrayList<Hotel> hoteles = new ArrayList<>();
    private static ArrayList<Destino> listaDestinos = new ArrayList<>();

    public Destino(String nombre, int distancia, boolean pideVisa) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.pideVisa = pideVisa;
        listaDestinos.add(this);
    }
    //METODO
    public static boolean existeDestino(String nombreDestino){
        boolean existe = false;
        for(Destino d : listaDestinos){
            if(d.getNombre().equals(nombreDestino)){
                existe = true;
            }
        }
        return existe;
    }
    
    public static Destino devolverDestino(String nombreDestino){
        Destino destino = null;
        for(Destino d : listaDestinos){
            if(d.getNombre().equals(nombreDestino)){
                destino = d;
            }
        }
        return destino;
    }
    
    //GETTERS AND SETTERS

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

    public boolean isPideVisa() {
        return pideVisa;
    }

    public void setPideVisa(boolean pideVisa) {
        this.pideVisa = pideVisa;
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public static ArrayList<Destino> getListaDestinos() {
        return listaDestinos;
    }

    public static void setListaDestinos(ArrayList<Destino> listaDestinos) {
        Destino.listaDestinos = listaDestinos;
    }
    

}
