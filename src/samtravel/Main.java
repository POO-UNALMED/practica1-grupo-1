package samtravel;

import utilidad.*;
import java.util.*;

import utilidad.Texto;

public class Main {

	public static Scanner intro = new Scanner(System.in);

	public static void main(String[] args) {

		// Instancias
		boolean sesion = true;
		int eleccion = 0;
		int eleccion2 = 0;

		Agente agenteSupremo = new Agente(1, "SAM", "Colombia", "123", "alma", 0);

		Viajero viajero1 = new Viajero(2, "Carlos", "Colombia", 1000, agenteSupremo);
		Viajero viajero2 = new Viajero(3, "Marcela", "Colombia", 0, agenteSupremo);
		Viajero viajero3 = new Viajero(3, "Alejandra", "Alemania", 0, agenteSupremo);

		Texto.presentacion();
		while (sesion) {
			Texto.menuUsuario();
			eleccion = intro.nextInt();
			switch (eleccion) {

			case 1:
				menuViajero();
				break;
			case 2:
				menuAgente();
				break;
			case 3:
				menuTurismo();
				break;
			case 4:
				menuVenta();
				break;
			case 0:
				System.out.println(" ");
				System.out.println("Vuelva pronto.");
				sesion = false;
				break;
			}
		}

	}

	public static void menuViajero() {
		boolean sesion = true;
		int eleccion = 0;
		while (sesion) {
			Texto.menuViajero();
			eleccion = intro.nextInt();
			switch (eleccion) {
			case 1:
				System.out.println("Ver listado de clientes.");
				break;
			case 2:
				System.out.println("Mejor Viajero.");
				break;
			case 3:
				System.out.println("Clientes con más presupuesto");
				break;
			case 4:
				System.out.println("Agregar nacionalidad a Viajero.");
				break;
			case 5:
				System.out.println("Relacionar viajeros.");
				break;
			case 0:
				sesion = false;
				break;

			}

		}
	}
	
	public static void menuAgente() {
		boolean sesion = true;
		int eleccion = 0;
		while (sesion) {
			Texto.menuAgente();
			eleccion = intro.nextInt();
			switch (eleccion) {
			case 1:
				System.out.println("Ver listado de agentes.");
				break;
			case 2:
				System.out.println("Agente con mejores ventas.");
				break;
			case 3:
				System.out.println("Clientes por agentes.");
				break;
			case 0:
				sesion = false;
				break;

			}

		}
	}
	
	public static void menuTurismo() {
		boolean sesion = true;
		int eleccion = 0;
		while (sesion) {
			Texto.menuTurismo();
			eleccion = intro.nextInt();
			switch (eleccion) {
			case 1:
				System.out.println("Ver listado de Destinos turísticos disponibles.");
				break;
			case 2:
				System.out.println("Ver hoteles por Destino");
				break;
			case 3:
				System.out.println("Ver tiempo de viaje para Destinos.");
				break;
			case 4:
				System.out.println("Cotizar un viaje.");
				break;
			case 0:
				sesion = false;
				break;

			}

		}
	}
	
	public static void menuVenta() {
		boolean sesion = true;
		int eleccion = 0;
		while (sesion) {
			Texto.menuVenta();
			eleccion = intro.nextInt();
			switch (eleccion) {
			case 1:
				System.out.println("Cotizar un viaje.");
				break;
			case 2:
				System.out.println("Vender un viaje (Imprime recibo).");
				break;
			case 3:
				System.out.println("Reembolso de Viajes.");
				break;
			case 0:
				sesion = false;
				break;

			}

		}
	}
}
