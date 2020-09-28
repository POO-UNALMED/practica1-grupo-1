package samtravel;
import java.util.*;

public class Viajero extends Persona{
	
	int presupuesto;
	Persona agente;
	ArrayList<Persona> relativos;
	
	//METODOS
	
	public void comprarViaje() {
		
	}
	
	public int cotizarViaje() {
		return 0;
	}
	
	public void reservarHotel() {
		
	}
	
	public void contarMillas() {
		
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
	public ArrayList<Persona> getRelativos() {
		return relativos;
	}
	public void setRelativos(ArrayList<Persona> relativos) {
		this.relativos = relativos;
	}
	
	
	
}
