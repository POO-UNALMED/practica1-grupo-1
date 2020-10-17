package gestorAplicacion.utils;

public class Transporte {
	String tipo;
	int velocidad;
	int costoKM;
	
	public Transporte(String tipo, int velocidad, int costoKM) {
		this.tipo = tipo;
		this.velocidad = velocidad;
		this.costoKM = costoKM;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getCostoKM() {
		return costoKM;
	}
	public void setCostoKM(int costoKM) {
		this.costoKM = costoKM;
	}
	
	
	
	

}
