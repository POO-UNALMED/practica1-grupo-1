package gestorAplicacion.persons;

import uiMain.Texto;

import java.util.*;

public class Viajero extends Persona {

    private int presupuesto;
    private Agente agente;
    private int millas;
    private boolean visado;
    public static ArrayList<Viajero> listaViajeros = new ArrayList<>();

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

    //METODOS HEREDADOS ABSTRACT
    @Override
    public boolean verificarCedula(int cedula) {
        int contador = 0;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedula) {
                continue;
            } else {
                contador++;
            }
        }
        if (contador == listaViajeros.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Persona devolverPorCedula(int cedula) {
        Viajero viajeroActual = null;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedula) {
                viajeroActual = v;
            }
        }
        return viajeroActual;
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
