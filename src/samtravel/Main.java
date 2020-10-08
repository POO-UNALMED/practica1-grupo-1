package samtravel;

import utilidad.*;
import java.util.*;

import utilidad.Texto;

public class Main {

	public static Scanner intro = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Instancias precargadas
		boolean sesion = true;
		Agente agente1 = new Agente(1,"Lina","colombia","123","alma",0);
		Viajero viajero1 = new Viajero(2,"Sammir","colombia","123",1000,agente1);
		Viajero viajero2 = new Viajero(3,"Marcela","colombia","palo",0,agente1);

		// Declaracion de variables
		Texto.presentacion();
		while(sesion) {
			menuInicio();
			sesion = false;
		}

	}
	
	public static void menuInicio() {
		
		int eleccion1 = intro.nextInt();
		Viajero usuarioActivo;
		Agente agenteActivo;
		switch (eleccion1) {

		case 1: // Usuario registrado. 
			usuarioActivo = Viajero.ingresoUsuarioRegistrado();
			usuarioActivo.menuUsuario();
			System.out.println("Ojalá vuelvas pronto.");
			break;
		case 2: // Nuevo usuario.
			usuarioActivo = Viajero.registrarNuevoUsuario();
			usuarioActivo.menuUsuario();
			break;
		case 3: // Agente.
			agenteActivo = Agente.ingresoAgente();
			break;
		case 4: // Salir del sistema.
			System.out.println("Ojalá vuelvas pronto.");
			break;
		}
	}



	

}
