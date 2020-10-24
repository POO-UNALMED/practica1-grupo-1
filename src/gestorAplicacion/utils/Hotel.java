package gestorAplicacion.utils;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.persons.Viajero;
import java.util.*;
public class Hotel {
	String nombre;
	int costo;
	Destino destino;
	int capacidad;
	ArrayList<Viajero> visitantes = new ArrayList<>();
	static ArrayList<Hotel> hoteles = new ArrayList<>();
	
	public Hotel(String nombre, int costo, Destino destino, int capacidad) {
		this.nombre = nombre;
		this.costo = costo;
		this.destino = destino;
		this.capacidad = capacidad;
		hoteles.add(this);
		destino.hoteles.add(this);
	}
	
	public Hotel() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public ArrayList<Viajero> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(ArrayList<Viajero> visitantes) {
		this.visitantes = visitantes;
	}

	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	
	
	
	

}
