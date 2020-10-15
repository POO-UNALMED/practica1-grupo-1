package samtravel;
import java.util.*;

public class Agente extends Persona{
	
	private String empresa;
	private int comision;
	private String contrasena;
	private ArrayList<Persona> clientes = new ArrayList<>() ;
	static ArrayList<Agente> listaAgentes = new ArrayList<>();
	public static Scanner intro = new Scanner(System.in);
	
	//CONSTRUCTOR
	public Agente(int cedula, String nombre, String nacionalidad, String contrasena, String empresa, int comision) {
		super(cedula, nombre, nacionalidad);
		this.empresa = empresa;
		this.comision = comision;
		listaAgentes.add(this);
	}
	
	public void cambiarNombre(Persona persona,String nuevoNombre) {
		
	}
	
	public void cambiarNacionalidad(Persona persona, String nacionalidad) {
		
	}
	
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
