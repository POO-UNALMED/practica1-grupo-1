package gestorAplicacion.persons;
import gestorAplicacion.persons.Persona;
import gestorAplicacion.persons.Viajero;
import java.util.*;
import java.util.Map.Entry;

public class Agente extends Persona{
	
	private String empresa;
	private int comision;
	private String contrasena;
	public ArrayList<Viajero> listaClientes = new ArrayList<>();
	static ArrayList<Agente> listaAgentes = new ArrayList<>();
	public static Scanner intro = new Scanner(System.in);
	private int numeroClientes;
	
	//CONSTRUCTOR
	public Agente(int cedula, String nombre, String nacionalidad, String empresa, int comision, String contrasena) {
		super(cedula, nombre, nacionalidad);
		this.empresa = empresa;
		this.comision = comision;
		listaAgentes.add(this);
	}
	
	public void cambiarNombre(Persona persona,String nuevoNombre) {
		
	}
	
	public void cambiarNacionalidad(Persona persona, String nacionalidad) {
		
	}
	
	public void venderViaje() {
		
	}
	
	public void crearNuevoDestino() {
		
	}
	
	public static List<Entry<String, Integer>> mejoresAgentes() {
		HashMap<String, Integer> agentes = new HashMap<>();
		
		
		for(Agente agente : listaAgentes) {
			
			agentes.put(agente.getNombre(), agente.getNumeroClientes());						
		}
		
		Set<Entry<String, Integer>> entrySet = agentes.entrySet();
		
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		
		Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		return list;
		
		
		
		
		
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

	
	
	
	public static ArrayList<Agente> getListaAgentes() {
		return listaAgentes;
	}


	public void setNumeroClientes() {
		this.numeroClientes +=1;
	}
	
	public int getNumeroClientes() {
		return numeroClientes;
	}
        
	
		
}
