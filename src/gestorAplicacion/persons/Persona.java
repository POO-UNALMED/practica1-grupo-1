package gestorAplicacion.persons;

import java.util.*;

public abstract class Persona {

    private int cedula;
    private String nombre;
    private boolean visado;
    public static ArrayList<Persona> listadoPersonas = new ArrayList<>();

    public Persona(int cedula, String nombre, boolean visado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.visado = visado;
        listadoPersonas.add(this);
    }

    public Persona() {

    }

    // METODOS ABSTRACT
    public abstract void obtenerVisado();

    //public abstract Persona devolverPorCedula(int cedula);
    
    //MÉTODOS
    public static boolean verificarCedula(int cedulaEntrante){
        boolean disponible = true;
        for (Persona p : listadoPersonas){
            if(p.getCedula() == cedulaEntrante){
                disponible = false;
            }
        }
        return disponible;
    }
    

    // GETTERS AND SETTERS

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisado() {
        return visado;
    }

    public void setVisado(boolean visado) {
        this.visado = visado;
    }

    public static ArrayList<Persona> getListadoPersonas() {
        return listadoPersonas;
    }

    public static void setListadoPersonas(ArrayList<Persona> listadoPersonas) {
        Persona.listadoPersonas = listadoPersonas;
    }
   
    
    
    



}
