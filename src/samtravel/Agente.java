package samtravel;
import java.util.*;

public class Agente extends Persona{
	
	private String empresa;
	private int comision;
	private String contrasena;
	private ArrayList<Persona> clientes = new ArrayList<>() ;
	static ArrayList<Agente> listaAgentes = new ArrayList<>();
	public static Scanner intro = new Scanner(System.in);
	
	//CONSTRUCTOR
	public Agente(int cedula, String nombre, String nacionalidad, String contrasena, String empresa, int comision) {
		super(cedula, nombre, nacionalidad);
		this.empresa = empresa;
		this.comision = comision;
		listaAgentes.add(this);
	}
	
	
	//METODOS
	public static Agente ingresoAgente() {
		
		Agente agente = null;
		boolean existe = false;
		System.out.println(" ");
		System.out.println("Cargando proceso de ingreso ...");
		
		while (existe == false) {
			System.out.println(" ");
			System.out.println("A continuación ingrese su documento de identidad: ");
			int documento = intro.nextInt();
			System.out.println("También es necesaria su contrasena: ");
			String contrasena = intro.next();
			
			//Verificar si existe el Viajero.
			for (int i = 0; i < listaAgentes.size(); i++) {
				if (documento == listaAgentes.get(i).getCedula()
						&& contrasena.equals(listaAgentes.get(i).getContrasena())) {
					agente = listaAgentes.get(i);
					existe = true;
				}
			}
			
			if (existe == true) {
				System.out.println(" ");
				System.out.println("Bienvenid@ nuevamente " + agente.getNombre());
				// Método que llama al Menú de usuarios registrados.
			} else {
				System.out.println(" ");
				System.out.println("Su documento y/o contraseña no son válidos, por favor vuelvalo a intentar. ");
			}

		}
		
		return agente;
	}
	



	public void venderViaje() {
		
	}
	
	public void crearNuevoDestino() {
		
	}
	
	
	// GETTERS AND SETTERS
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public ArrayList<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Persona> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	
	
}
