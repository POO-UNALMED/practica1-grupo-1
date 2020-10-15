package samtravel;

import java.util.ArrayList;

public class Destino {
	String nombre;
	int distancia;
	ArrayList<Hotel> hoteles = new ArrayList<>();
	ArrayList<String> nacionalidades = new ArrayList<>();
	public Destino(String nombre, int distancia, ArrayList<String> nacionalidades) {
		super();
		this.nombre = nombre;
		this.distancia = distancia;
		this.nacionalidades = nacionalidades;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public ArrayList<String> getNacionalidades() {
		return nacionalidades;
	}
	public void setNacionalidades(ArrayList<String> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}
	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	

}
