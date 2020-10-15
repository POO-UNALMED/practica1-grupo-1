package samtravel;

import utilidad.*;
import java.util.*;

import utilidad.Texto;
import samtravel.*;

public class Main {

	public static Scanner intro = new Scanner(System.in);
	
	public static void main(String[] args) {
            //Prueba1

		// Instancias
		boolean sesion = true;
		int eleccion = 0;
		int eleccion2 = 0;
		//Linea que el otro codigo no tiene.
		Agente agenteSupremo = new Agente(1, "SAM", "Colombia", "123", "alma", 0);

		Viajero viajero1 = new Viajero(1, "Carlos", "Colombia", 1000, agenteSupremo);
		Viajero viajero2 = new Viajero(3, "Marcela", "Colombia", 0, agenteSupremo);
		Viajero viajero3 = new Viajero(3, "Alejandra", "Alemania", 0, agenteSupremo);
		
		ArrayList<String> nacionalidades1;
                nacionalidades1 = new ArrayList<>();

		nacionalidades1.add("Colombia");
		Destino destino1 = new Destino("San �ndres", 973, nacionalidades1);
		
		Hotel hotel1 = new Hotel("Hotelucho", 190, destino1, 100);
		
		Transporte transporte1 = new Transporte("avion",10,10);
		
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
		ArrayList<Viajero> listaViajero;
		while (sesion) {
			Texto.menuViajero();
			eleccion = intro.nextInt();
			switch (eleccion) {
			case 1:
				System.out.println("Aqu� se van a imprimir clientes");
				listaViajero = Viajero.listadoClientes();
				for(int i = 0; i < listaViajero.size();i++) {
					System.out.println(listaViajero.get(i).getNombre());
				}
				break;
			case 2:
				System.out.println("Mejor Viajero.");
				break;
			case 3:
				System.out.println("Clientes con m�s presupuesto");
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
				System.out.println("Ver listado de Destinos tur�sticos disponibles.");
				break;
			case 2:
				System.out.println("Ver hoteles por Destino");
				break;
			case 3:
				System.out.println("Ver tiempo de viaje para Destinos.");
				break;
			case 4:
				System.out.println(" ");
				System.out.println("Se va a vender un viaje...");
				System.out.println(" ");
				System.out.println("Deme el documento de la persona que va a viajar:");
				int cedulaViajero = intro.nextInt();
				Viajero viajeroActual = null;
				for (int i = 0; i < Viajero.listaViajeros.size();i++) {
					if(Viajero.listaViajeros.get(i).getCedula()==cedulaViajero) {
						viajeroActual = Viajero.listaViajeros.get(i);
					}
				}
				System.out.println("Deme el documento del agente:");
				int cedulaAgente = intro.nextInt();
				Agente agenteActual = null;
				for (int i = 0; i < Viajero.listaViajeros.size();i++) {
					if(Viajero.listaViajeros.get(i).getCedula()==cedulaViajero) {
						viajeroActual = Viajero.listaViajeros.get(i);
					}
				}
				Transporte transporte1 = new Transporte("avion",10,10);
				ArrayList<String> nacionalidades2 = new ArrayList<>();

				nacionalidades2.add("Colombia");
				Destino destino1 = new Destino("San �ndres", 973, nacionalidades2);
				Tiquete tiquete1 = new Tiquete(viajeroActual, agenteActual,transporte1, 10, destino1,100);
				System.out.println(tiquete1.getPrecio());
				System.out.println(tiquete1.getViajero().getNombre());
				
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
