package samtravel;

import samtravel.Main;
import utilidad.Texto;

import java.util.*;

public class Viajero extends Persona {

	private int presupuesto;
	private Persona agente;
	private int millas;
	private ArrayList<Viajero> relativos = new ArrayList<>();
	static ArrayList<Viajero> listaViajeros = new ArrayList<>();
	public static Scanner intro = new Scanner(System.in);

	// CONSTRUCTORES

	public Viajero() {

	}

	public Viajero(int cedula, String nombre, String nacionalidad, int presupuesto, Persona agente) {
		super(cedula, nombre, nacionalidad);
		this.presupuesto = presupuesto;
		this.agente = agente;
		listaViajeros.add(this);
	}
	
	//MÉTODOS
	
	public void cambiarNombre(Persona persona,String nuevoNombre) {
		
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
	
}
