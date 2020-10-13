package utilidad;
import java.util.*;

public class Texto {
	
	
	public static void presentacion() {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println(" ");
		System.out.println("                  //-------------------- BIENVENID@S A SAM-TRAVEL --------------------//");
		System.out.println(" ");
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println(" ");
		System.out.println("PROGRAMACIÓN ORIENTADA A OBJETOS 2020");
		System.out.println("Programa diseñado para administrar todos los procesos dentro de la agencia de viajes SAM-TRAVEL.");
		System.out.println("Todos los derechos reservados.");
		System.out.println(" ");

	}
	
	public static void menuUsuario() {
		System.out.println(" ");
		System.out.println("                  //-------------------- MENÚ DE USUARIO --------------------//");
		System.out.println(" ");
		System.out.println("     ¿Que desea hacer en esta sesión?");
		System.out.println(" ");
		System.out.println("          1. Ver información de Viajeros"); 
		System.out.println("          2. Ver información de Agentes de Viajes"); 
		System.out.println("          3. Ver información de Oferta Turística.");
		System.out.println("          4. Venta de Viajes.");
		System.out.println(" ");
		System.out.println("             0. Salir del sistema.");
		System.out.println(" ");
		System.out.println("     A continuación su elección:");
		System.out.println(" ");
	}
	
	public static void menuViajero() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE VIAJEROS --------------------//");
		System.out.println(" ");
		System.out.println("     A continuación las opciones del Menú:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de clientes."); 
		System.out.println("          2. Mejor Viajero."); 
		System.out.println("          3. Clientes con más presupuesto");
		System.out.println("          4. Agregar nacionalidad a Viajero.");
		System.out.println("          5. Relacionar viajeros.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menú anterior.");
		System.out.println(" ");
		System.out.println("     A continuación su elección:");
		System.out.println(" ");
	}
	
	public static void menuAgente() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE AGENTES --------------------//");
		System.out.println(" ");
		System.out.println("     A continuación las opciones del Menú:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de agentes."); 
		System.out.println("          2. Agente con mejores ventas."); 
		System.out.println("          3. Clientes por agentes.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menú anterior.");
		System.out.println(" ");
		System.out.println("     A continuación su elección:");
		System.out.println(" ");
	}
	
	public static void menuTurismo() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE TURISMO --------------------//");
		System.out.println(" ");
		System.out.println("     A continuación las opciones del Menú:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de Destinos turísticos disponibles."); 
		System.out.println("          2. Ver hoteles por Destino"); 
		System.out.println("          3. Ver tiempo de viaje para Destinos.");
		System.out.println("          4. Cotizar un viaje.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menú anterior.");
		System.out.println(" ");
		System.out.println("     A continuación su elección:");
		System.out.println(" ");
	}
	
	public static void menuVenta() {
		System.out.println(" ");
		System.out.println("                  //-------------------- VENTA DE VIAJES --------------------//");
		System.out.println(" ");
		System.out.println("     A continuación las opciones del Menú:");
		System.out.println(" ");
		System.out.println("          1. Cotizar un viaje."); 
		System.out.println("          2. Vender un viaje (Imprime recibo)."); 
		System.out.println("          3. Reembolso de Viajes.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menú anterior.");
		System.out.println(" ");
		System.out.println("     A continuación su elección:");
		System.out.println(" ");
	}
	
}
