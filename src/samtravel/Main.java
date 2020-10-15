package samtravel;

import utilidad.*;
import java.util.*;

import utilidad.Texto;
import samtravel.*;

public class Main {

    public static Scanner intro = new Scanner(System.in);

    public static void main(String[] args) {

        // Instancias
        boolean sesion = true;
        int eleccion = 0;
        int eleccion2 = 0;

        Agente agenteSupremo = new Agente(10, "SAM", "Colombia", "123", "alma", 0);

        Viajero viajero1 = new Viajero(1, "Carlos", "Colombia", 1000, agenteSupremo);
        Viajero viajero2 = new Viajero(2, "Marcela", "Colombia", 2000, agenteSupremo);
        Viajero viajero3 = new Viajero(3, "Alejandra", "Alemania", 0, agenteSupremo);

        ArrayList<String> nacionalidades1;
        nacionalidades1 = new ArrayList<>();

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
