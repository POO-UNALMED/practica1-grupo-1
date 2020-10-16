package samtravel;

import utilidad.Texto;
import samtravel.*;

import java.util.*;

public class Viajero extends Persona {

    private int presupuesto;
    private Persona agente;
    private int millas;
    static ArrayList<Viajero> listaViajeros = new ArrayList<>();
    public static Scanner intro = new Scanner(System.in);

    // CONSTRUCTORES
    public Viajero() {

    }

    public Viajero(int cedula, String nombre, String nacionalidad, int presupuesto, Agente agente) {
        super(cedula, nombre, nacionalidad);
        this.presupuesto = presupuesto;
        this.agente = agente;
        agente.listaClientes.add(this);
        listaViajeros.add(this);
        agente.setNumeroClientes();
    }

    //M�TODOS
    public void cambiarNombre(Persona persona, String nuevoNombre) {

    }

    public void cambiarNacionalidad(Persona persona, String nacionalidad) {

    }

    public static ArrayList<Viajero> listadoClientes() {
        return listaViajeros;
    }

    // GETTERS AND SETTERS
    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public int getMillas() {
        return millas;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }

    public static ArrayList<Viajero> getListaViajeros() {
        return listaViajeros;
    }

    public static void setListaViajeros(ArrayList<Viajero> listaViajeros) {
        Viajero.listaViajeros = listaViajeros;
    }

}
