package gestorAplicacion.persons;

import gestorAplicacion.utils.Destino;
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
    public void obtenerVisado() {
        this.setVisado(true);
    }

    //MÉTODOS NORMALES
    public static boolean verificarCedula(int cedulaEntrante) {
        boolean existe = false;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedulaEntrante) {
                existe = true;
            }
        }
        return existe;
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

    public void consignarDinero(int consignacion) {
        int presupuesto = this.presupuesto;
        this.setPresupuesto(presupuesto + consignacion);
    }

    public ArrayList<Destino> destinosPosibles() {
        ArrayList<Destino> destinos = Destino.getListaDestinos();
        ArrayList<Destino> destinosPosibles = new ArrayList<>();
        double costoKMAereo = 1;
        double costoKMTerrestre = 0.7;
        double costoKMMaritimo = 0.8;
        int costo;
        for (Destino d : destinos) {
            if (d.isPideVisa() && (this.isVisado())) {
                costo = d.getDistancia();
                if (this.getPresupuesto() >= costo) {
                    destinosPosibles.add(d);
                }
            } else {

            }
        }
        return destinosPosibles;
    }

    public void quePuedeCostear() {

    }

    public boolean haViajado() {
        if (this.getViajesRealizados().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public void pagar(int cobro){
        int actual = this.getPresupuesto();
        setPresupuesto(actual - cobro);
        
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

    public ArrayList<Tiquete> getViajesRealizados() {
        return viajesRealizados;
    }

    public void setViajesRealizados(ArrayList<Tiquete> viajesRealizados) {
        this.viajesRealizados = viajesRealizados;
    }

}
