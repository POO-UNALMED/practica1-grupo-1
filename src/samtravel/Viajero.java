package samtravel;

import samtravel.Main;
import utilidad.Texto;

import java.util.*;

public class Viajero extends Persona {

	private int presupuesto;
	private Persona agente;
	private ArrayList<Persona> relativos = new ArrayList<>();
	static ArrayList<Viajero> listaViajeros = new ArrayList<>();
	public static Scanner intro = new Scanner(System.in);

	// CONSTRUCTORES

	public Viajero() {

	}

	public Viajero(int cedula, String nombre, String nacionalidad, String contrasena, int presupuesto, Persona agente) {
		super(cedula, nombre, nacionalidad, contrasena);
		this.presupuesto = presupuesto;
		this.agente = agente;
		listaViajeros.add(this);
	}

	// METODOS
	public static Viajero ingresoUsuarioRegistrado() {
		
		Viajero viajero = null;
		boolean existe = false;
		System.out.println(" ");
		System.out.println("Cargando proceso de ingreso ...");
		
		while (existe == false) {
			System.out.println(" ");
			System.out.println("A continuaci�n ingrese su documento de identidad: ");
			int documento = intro.nextInt();
			System.out.println(" ");
			System.out.println("Tambi�n es necesaria su contrasena: ");
			String contrasena = intro.next();
			
			//Verificar si existe el Viajero.
			for (int i = 0; i < listaViajeros.size(); i++) {
				if (documento == listaViajeros.get(i).getCedula()
						&& contrasena.equals(listaViajeros.get(i).getContrasena())) {
					viajero = listaViajeros.get(i);
					existe = true;
				}
			}
			
			//Confirmaci�n de si las credenciales son correctas.
			if (existe == true) {
				System.out.println(" ");
				System.out.println("Bienvenid@ nuevamente " + viajero.getNombre());
				// M�todo que llama al Men� de usuarios registrados.
			} else {
				System.out.println(" ");
				System.out.println("Su documento y/o contrase�a no son v�lidos, por favor vuelvalo a intentar. ");
			}

		}
		
		return viajero;
	}
	
	public static Viajero registrarNuevoUsuario() {

		boolean a = true;
		String nombreNuevoUsuario;
		String contrasenaNuevoUsuario;
		String confirmarContrasena;

		System.out.println(" ");
		System.out.println("Comenzando su proceso de registro...");
		System.out.println(" ");
		System.out.println("Por favor ingrese su nombre de usuario.");
		nombreNuevoUsuario = intro.next();
		System.out.println(" ");
		System.out.println("Su n�mero documento de identidad:");
		int documento = intro.nextInt();

		// Ingresar Contrase�a
		do {
			System.out.println(" ");
			System.out.println("A continuaci�n su contrase�a:");
			contrasenaNuevoUsuario = intro.next();
			System.out.println(" ");
			System.out.println("Confirme su contrase�a: ");
			confirmarContrasena = intro.next();
			System.out.println(" ");

			if (contrasenaNuevoUsuario.equals(confirmarContrasena)) {
				a = false;
				System.out.println("Sus contrase�as coinciden.");
			} else {
				a = true;
				System.out.println("Sus contrase�as no coinciden, por favor vuelvalo a intentar.");
				System.out.println(" ");
			}

		} while (a == true);

		System.out.println(" ");
		System.out.println(" Por ultimo el pa�s del cu�l usted es nacional.");
		String nacional = intro.next();
		
		System.out.println(" ");
		System.out.println("Usted ha sido registrado exitosamente.");
		
		return new Viajero(documento, nombreNuevoUsuario, nacional, contrasenaNuevoUsuario, 0, null);
		

	}
	
	
	public void menuUsuario() {
		Texto.menuUsuario();
	}

	public void comprarViaje() {

	}

	public int cotizarViaje() {
		return 0;
	}

	public void reservarHotel() {

	}

	public void contarMillas() {

	}

	// GETTERS AND SETTERS

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Persona getAgente() {
		return agente;
	}

	public void setAgente(Persona agente) {
		this.agente = agente;
	}

	public ArrayList<Persona> getRelativos() {
		return relativos;
	}

	public void setRelativos(ArrayList<Persona> relativos) {
		this.relativos = relativos;
	}

}
