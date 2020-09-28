package samtravel;
import java.util.*;

public class Agente extends Persona{
	
	String empresa;
	int comision;
	ArrayList<Persona> clientes;
	
	
	//METODOS
	public void venderViaje() {
		
	}
	
	public void crearNuevoDestino() {
		
	}
	
	
	// GETTERS AND SETTERS
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public ArrayList<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Persona> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	
	
}
