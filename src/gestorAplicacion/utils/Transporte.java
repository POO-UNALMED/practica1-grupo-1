package gestorAplicacion.utils;

public class Transporte {
	String tipo;
	int velocidad;
	int costoKM;
	
	public Transporte(String tipo) {
		this.tipo = tipo;
		if(tipo.equals("terrestre")) {
			this.velocidad = 80;
			this.costoKM = 4;
		}
		else if(tipo.equals("aereo")) {
			this.velocidad = 300;
			this.costoKM = 7;
		}
		else if(tipo.equals("maritimo")) {
			this.velocidad = 50;
			this.costoKM = 5;
		}
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
