package samtravel;
import java.util.*;

public class Persona {
	
	private int cedula;
	private String nombre;
	private String nacionalidad;
	private String contrasena;
	
	
	public Persona(int cedula, String nombre, String nacionalidad,String contrasena) { 
		this.cedula = cedula;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.contrasena = contrasena;
	}

	public Persona() {
		
	}
	
	// MÉTODOS
	public void cambiarNombre(Persona persona,String nuevoNombre) {
		persona.setNombre(nuevoNombre);
	}
		
	public void cambiarNacionalidad(Persona persona, String nacionalidad) {
		persona.setNacionalidad(nacionalidad);
	}
	
	
	// GETTERS AND SETTERS
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
