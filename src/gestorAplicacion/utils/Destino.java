package gestorAplicacion.utils;

import java.util.*;

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
		Scanner entrada = new Scanner(System.in);
		System.out.println("Cuantos hoteles deseas agregar para este destino turistico");
		int nHoteles = entrada.nextInt();		
		for (int i = 0; i < nHoteles; i++) {
			hoteles.add(new Hotel());
			System.out.println("Agrega la informacion del hotel " + i);
			System.out.println("Agrega el nombre");			
			String nombreH = entrada.next();
			hoteles.get(i).setNombre(nombreH);
			
			System.out.println("Agrega el precio");	
			int costoH = entrada.nextInt();			
			hoteles.get(i).setCosto(costoH);
			
			
			hoteles.get(i).setDestino(this);
			
			
			System.out.println("Agrega la capacidad del hotel");	
			int capacidadH = entrada.nextInt();			
			hoteles.get(i).setCosto(capacidadH);
			
			Hotel.hoteles.add(hoteles.get(i));
		}
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
	
	public void setHotel(Hotel hotel) {
		hoteles.add(hotel);
	}
	
	
	

}
