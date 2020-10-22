package gestorAplicacion.persons;

import gestorAplicacion.utils.Tiquete;
import uiMain.Texto;

import java.util.*;

public class Viajero extends Persona {

    private int presupuesto;
    private Agente agente;
    private int millas;
    private static ArrayList<Viajero> listaViajeros = new ArrayList<>();
    private ArrayList<Tiquete> viajesRealizados = new ArrayList<>();

    // CONSTRUCTORES
    public Viajero() {

    }

    public Viajero(int cedula, String nombre, boolean visado, int presupuesto) {
        super(cedula, nombre, visado);
        this.presupuesto = presupuesto;
        this.agente = Agente.agenteAleatorio();
        this.millas = 0;   
        listaViajeros.add(this);
        agente.atenderCliente(this);
    }

    //METODOS HEREDADOS ABSTRACT
    
    public void obtenerVisado(){
        this.setVisado(true);
    }
    
    //MÉTODOS NORMALES

    public static boolean verificarCedula(int cedula) {
        int contador = 0;
        boolean respuesta = false;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() != cedula) {
                contador++;
            }
        }
        if (contador == listaViajeros.size()) {
            respuesta = false;
        } else {
            respuesta = true;
        }
        return respuesta;
    }

    
    public static Viajero devolverPorCedula(int cedula) {
        Viajero viajeroActual = null;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedula) {
                viajeroActual = v;
            }
        }
        return viajeroActual;
    }

    // GETTERS AND SETTERS

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
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
