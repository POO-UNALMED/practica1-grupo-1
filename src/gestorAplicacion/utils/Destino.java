package gestorAplicacion.utils;

import java.util.ArrayList;

public class Destino {
	String nombre;
	String pais;
	int distancia;
	ArrayList<Hotel> hoteles = new ArrayList<>();
	static ArrayList<String> paisSinVisa = new ArrayList<>();
	
	
	
	public Destino(String nombre, String pais, int distancia) {
		this.nombre = nombre;
		this.pais = pais;
		this.distancia = distancia;
	}
	
	public static void setDestinoSinVisado(String nacionalidad) {
		paisSinVisa.add(nacionalidad);
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
	
	public ArrayList<Hotel> getHoteles() {
		return hoteles;
	}
	public void setHoteles(ArrayList<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	
	

}
