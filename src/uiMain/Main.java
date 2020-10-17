package uiMain;
import gestorAplicacion.persons.Agente;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import gestorAplicacion.utils.Transporte;
import gestorAplicacion.persons.Viajero;
import java.util.Map.Entry;
import java.util.*;

import uiMain.Texto;

public class Main {

    public static Scanner intro = new Scanner(System.in);

    public static void main(String[] args) {

    	boolean sesion = true;
        int eleccion = 0;
        int eleccion2 = 0;
        
        // Super usuario que tiene acceso a todo
        Agente agenteSupremo = new Agente(10, "SAM", "Colombia", "alma", 0, "1234");

        
        //Primero creamos los agentes ya que cuando se cree un viajero se le debe de asignar el agente 
        Agente agente1 = new Agente(1087904564, "Carlos Bustamente", "Colombia", "Viaja facil", 10, "1234");
        Agente agente2 = new Agente(1094520234, "Juan Ramirez", "Colombia", "Despegar", 15, "1234");
        Agente agente3 = new Agente(1087904564, "Lucas Bastidas", "Colombia", "Despegar", 15, "1234");
        
        
        
        //Creamos 3 viajeros
        Viajero viajero1 = new Viajero(1, "Carlos", "Colombia", 1000, agente2);
        Viajero viajero2 = new Viajero(2, "Marcela", "Colombia", 2000, agente2);
        Viajero viajero3 = new Viajero(3, "Luisa", "Alemania", 0, agente1);
        Viajero viajero4 = new Viajero(3, "Andrea", "Alemania", 0, agente1);
        Viajero viajero5 = new Viajero(3, "Estefania", "Rusia", 0, agente1);
        Viajero viajero6 = new Viajero(3, "Diana", "Inglaterra", 0, agente3);

        
        
        ArrayList<String> nacionalidades1 = new ArrayList<>();

        nacionalidades1.add("Colombia");
        Destino destino1 = new Destino("San Andres", 973, nacionalidades1);

        Hotel hotel1 = new Hotel("Hotelucho", 190, destino1, 100);

        Transporte transporte1 = new Transporte("avion", 10, 10);

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
//            if (eleccion == 1) {
//            	menuViajero();
//            }
//            else if (eleccion == 2) {
//            	menuAgente();
//            }
//            else if (eleccion == 3) {
//            	menuTurismo();
//            }
//            else if (eleccion == 4) {
//            	menuVenta();
//            }
//            else {
//            	System.out.println("Has escrito una opcion invalida intentalo nuevamente escogiendo entre 1 de las 4 opciones");
//            }
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
                    imprimirClientes();
                    break;
                case 2:
                    mejorViajero();
                    break;
                case 3:
                    clientesMasPresupuesto();
                    break;
                case 4:
                    cambiarNacionalidad();
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
        Texto.menuAgente();
        while (sesion) {            
            eleccion = intro.nextInt();            
            if(eleccion == 1) {
            	System.out.println("Listado de agentes:");
            	ArrayList<Agente> agentes = Agente.getListaAgentes();
            	for(Agente agente : agentes) {
        			System.out.println(agente.getNombre());
        		}
            	break;
            }
            if(eleccion == 2) {
            	System.out.println("Agentes con mas clientes");
            	Agente.mejoresAgentes();
            	List<Entry<String, Integer>> list = Agente.mejoresAgentes();
            	for(int i = list.size() - 1; i > list.size() -4 ; i --){
        			System.out.println(list.get(i));
        		}
            	break;
            }
            if(eleccion == 3) {
            	System.out.println("Clientes por agente");
            	break;
            }
            else {
            	System.out.println("Has seleccionado una opcion invalida intentalo de nuevo eligiendo del 1 al 3, si deseas volver al menu anterior presiona 0");
            	
            }
            Texto.menuAgente();  

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
                    System.out.println("Ver listado de Destinos turisticos disponibles.");
                    break;
                case 2:
                    System.out.println("Ver hoteles por Destino");
                    break;
                case 3:
                    System.out.println("Ver tiempo de viaje para Destinos.");
                    break;
                case 4:
                    venderTiquete();
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

    public static void venderTiquete() {

        //Variables que se usarán en el método.
        Viajero viajeroActual = null;
        Agente agenteActual = null;

        System.out.println(" ");
        System.out.println("//----------//PLATAFORMA DE VENTE DE TIQUETES//----------//");
        System.out.println(" ");

        //Se pregunta por el documento del viajero para después verificar si se encuentra o no entre los inscritos:
        System.out.println("Inserte el número de documento de la persona que va a viajar:");
        int cedulaViajero = intro.nextInt();

        for (int i = 0; i < Viajero.listaViajeros.size(); i++) {
            if (Viajero.listaViajeros.get(i).getCedula() == cedulaViajero) {
                viajeroActual = Viajero.listaViajeros.get(i);
            }
        }

        System.out.println("Inserte documento de el agente que va a ser asignado:");
        int cedulaAgente = intro.nextInt();

        for (int i = 0; i < Viajero.listaViajeros.size(); i++) {
            if (Viajero.listaViajeros.get(i).getCedula() == cedulaViajero) {
                viajeroActual = Viajero.listaViajeros.get(i);
            }
        }
        Transporte transporte1 = new Transporte("avion", 10, 10);
        ArrayList<String> nacionalidades2 = new ArrayList<>();

        nacionalidades2.add("Colombia");
        Destino destino1 = new Destino("San Andres", 973, nacionalidades2);
        Tiquete tiquete1 = new Tiquete(viajeroActual, agenteActual, transporte1, 10, destino1, 100);
        System.out.println(tiquete1.getPrecio());
        System.out.println(tiquete1.getViajero().getNombre());
    }

    // MÉTODOS DE MENÚ DE VIAJERO:
    public static void imprimirClientes() {
        ArrayList<Viajero> listaViajero = Viajero.getListaViajeros();
        System.out.println(" ");
        System.out.println("//----------// LISTADO DE CLIENTES DE SAM TRAVEL //----------//");
        System.out.println(" ");
        for (int i = 0; i < listaViajero.size(); i++) {
            Viajero viajero = listaViajero.get(i);
            System.out.println("//----------------------------------------//");
            System.out.println("    ID: " + viajero.getCedula());
            System.out.println("    Nombre: " + viajero.getNombre());
            System.out.println("    País de origen: " + viajero.getNacionalidad());
            System.out.println("    Millas Acumuladas: " + viajero.getMillas());
            System.out.println("    Presupuesto: " + viajero.getPresupuesto());
            System.out.println("    Agente encargado: ID :" + viajero.getAgente().getCedula() + " Nombre: " + viajero.getAgente().getNombre());
            System.out.println(" ");
        }
        System.out.println("//----------// FIN DE LISTADO DE CLIENTES DE SAM TRAVEL //----------//");
    }

    public static void mejorViajero() {
        ArrayList<Viajero> listaViajero = Viajero.getListaViajeros();
        int masMillas = -1;
        Viajero aux = null;
        for (int i = 0; i < listaViajero.size(); i++) {
            Viajero viajero = listaViajero.get(i);

            if (viajero.getMillas() > masMillas) {
                masMillas = viajero.getMillas();
                aux = viajero;
            } else if (viajero.getMillas() == masMillas && viajero.getPresupuesto() > aux.getPresupuesto()) {
                masMillas = viajero.getMillas();
                aux = viajero;
            }

        }
        System.out.println("//----------------------------------------//");
        System.out.println("El Mejor Viajero es :" + aux.getNombre());
        System.out.println("    Millas Acumuladas: " + aux.getMillas());
        System.out.println("    Presupuesto: " + aux.getPresupuesto());
        System.out.println("//----------------------------------------//");
        System.out.println(" ");
    }

    public static void clientesMasPresupuesto() {
        ArrayList<Viajero> listaViajero = Viajero.getListaViajeros();
        int masPresupuesto = -1;
        Viajero aux = null;
        for (int i = 0; i < listaViajero.size(); i++) {
            Viajero viajero = listaViajero.get(i);

            if (viajero.getPresupuesto() > masPresupuesto) {
                masPresupuesto = viajero.getMillas();
                aux = viajero;
            } else if (viajero.getPresupuesto() == masPresupuesto && viajero.getMillas() > aux.getMillas()) {
                masPresupuesto = viajero.getMillas();
                aux = viajero;

            }
        }
        System.out.println("//----------------------------------------//");
        System.out.println("El Mejor Viajero es :" + aux.getNombre());
        System.out.println("    Millas Acumuladas: " + aux.getMillas());
        System.out.println("    Presupuesto: " + aux.getPresupuesto());
        System.out.println("//----------------------------------------//");
        System.out.println(" ");
    }

    public static void cambiarNacionalidad() {
        ArrayList<Viajero> listaViajero = Viajero.getListaViajeros();
        Viajero aux = null;
        System.out.println("//----------------------------------------//");
        System.out.println("Por favor inserte el documento de la persona que desea cambiar su nacionalidad: ");
        int doc = intro.nextInt();
        for (int i = 0; i < listaViajero.size(); i++) {
            Viajero viajero = listaViajero.get(i);
            if (viajero.getCedula() == doc) {
                aux = viajero;
            }
        }
        if (aux == null) {
            System.out.println("La cédula insertada no se encuentra inscrita en nuestro sistema.");
            System.out.println(" ");
            System.out.println("Por favor vuelvalo a intentar.");
            System.out.println(" ");
        } else {
            System.out.println(" Inserte su nuevo país de origen:");
            String nuevaNacionalidad = intro.next();
            aux.setNacionalidad(nuevaNacionalidad);
            System.out.println(" ");
            System.out.println(" Proceso completado exitosamente.");
            System.out.println("");
            System.out.println("//----------------------------------------//");
            System.out.println("La nueva nacionalidad de " + aux.getNombre() + " con documento: " + aux.getCedula() + " es: " + aux.getNacionalidad());
            System.out.println(" ");
        }

    }
    
    
}