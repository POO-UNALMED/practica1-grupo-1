package gestorAplicacion.utils;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.persons.Viajero;

public class Tiquete {
	Viajero viajero;
	Agente agente;
	Transporte transporte;
	int tiempoViaje;
	Destino destino;
	double precio;
	

	
	public Tiquete(Viajero viajero, Agente agente, Transporte transporte, int tiempoViaje, Destino destino,
			double precio) {
		this.viajero = viajero;
		this.agente = agente;
		this.transporte = transporte;
		this.tiempoViaje = tiempoViaje;
		this.destino = destino;
		this.precio = precio;
	}

	public Viajero getViajero() {
		return viajero;
	}
	
	public void setViajero(Viajero viajero) {
		this.viajero = viajero;
	}
	
	public Agente getAgente() {
		return agente;
	}
	
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public int getTiempoViaje() {
		return tiempoViaje;
	}
	public void setTiempoViaje(int tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
	
	

}
