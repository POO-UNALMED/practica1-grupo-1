package gestorAplicacion.utils;

import java.util.ArrayList;

public class Destino {
	String nombre;
	int distancia;
	ArrayList<Hotel> hoteles = new ArrayList<>();
	ArrayList<String> nacionalidadesAceptadas = new ArrayList<>();
	
	public Destino(String nombre, int distancia, ArrayList<String> nacionalidadesAceptadas) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.nacionalidadesAceptadas = nacionalidadesAceptadas;
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
		return nacionalidadesAceptadas;
	}
	public void setNacionalidades(ArrayList<String> nacionalidades) {
		this.nacionalidadesAceptadas = nacionalidades;
	}
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}
	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	
	

}
