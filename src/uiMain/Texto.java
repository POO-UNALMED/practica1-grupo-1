package uiMain;
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
		System.out.println("PROGRAMACION ORIENTADA A OBJETOS 2020");
		System.out.println("Programa disenado para administrar todos los procesos dentro de la agencia de viajes SAM-TRAVEL.");
		System.out.println("Todos los derechos reservados.");
		System.out.println(" ");

	}
	
	public static void menuUsuario() {
		System.out.println(" ");
		System.out.println("                  //-------------------- MENU DE USUARIO --------------------//");
		System.out.println(" ");
		System.out.println("     ¿Que desea hacer en esta sesion?");
		System.out.println(" ");
		System.out.println("          1. Ver informacion de Viajeros"); 
		System.out.println("          2. Ver informacion de Agentes de Viajes"); 
		System.out.println("          3. Ver informacion de Oferta Turistica.");
		System.out.println("          4. Venta de Viajes.");
		System.out.println(" ");
		System.out.println("             0. Salir del sistema.");
		System.out.println(" ");
		System.out.println("     Su eleccion:");
		System.out.println(" ");
	}
	
	public static void menuViajero() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE VIAJEROS --------------------//");
		System.out.println(" ");
		System.out.println("     A continuacion las opciones del Menu:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de Viajeros inscritos."); 
		System.out.println("          2. Inscribir a un viajero."); 
		System.out.println("          3. Otorgar visado a cliente.");
		System.out.println("          4. Ver viajes realizados para un cliente.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menu anterior.");
		System.out.println(" ");
		System.out.println("     Su eleccion:");
		System.out.println(" ");
	}
	
	public static void menuAgente() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE AGENTES --------------------//");
		System.out.println(" ");
		System.out.println("     A continuacion las opciones del Menu:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de agentes."); 
		System.out.println("          2. Agente con mejores ventas."); 
		System.out.println("          3. Clientes por agente.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menu anterior.");
		System.out.println(" ");
		System.out.println("     Su eleccion:");
		System.out.println(" ");
	}
	
	public static void menuTurismo() {
		System.out.println(" ");
		System.out.println("                  //-------------------- INFORMACION DE TURISMO --------------------//");
		System.out.println(" ");
		System.out.println("     A continuacion las opciones del Menu:");
		System.out.println(" ");
		System.out.println("          1. Ver listado de Destinos turisticos disponibles."); 
		System.out.println("          2. Ver hoteles por Destino"); 
		System.out.println("          3. Ver tiempo de viaje para Destinos.");
		System.out.println("          4. Cotizar un viaje.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menu anterior.");
		System.out.println(" ");
		System.out.println("     Su eleccion:");
		System.out.println(" ");
	}
	
	public static void menuVenta() {
		System.out.println(" ");
		System.out.println("                  //-------------------- VENTA DE VIAJES --------------------//");
		System.out.println(" ");
		System.out.println("     A continuacion las opciones del Menu:");
		System.out.println(" ");
		System.out.println("          1. Cotizar un viaje."); 
		System.out.println("          2. Vender un viaje (Imprime recibo)."); 
		System.out.println("          3. Reembolso de Viajes.");
		System.out.println(" ");
		System.out.println("             0. Volver al Menu anterior.");
		System.out.println(" ");
		System.out.println("     Su eleccion:");
		System.out.println(" ");
	}
	
}
