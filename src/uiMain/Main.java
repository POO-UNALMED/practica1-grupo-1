package uiMain;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.persons.Persona;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import gestorAplicacion.utils.Transporte;
import gestorAplicacion.persons.Viajero;
import java.util.Map.Entry;
import java.util.*;
import java.lang.Math;
import uiMain.Texto;

public class Main {

    public static Scanner intro = new Scanner(System.in);

    public static void main(String[] args) {

        boolean sesion = true;
        int eleccion = 0;
        int eleccion2 = 0;

        //INSTANCIAS
        Agente agenteSupremo = new Agente(10, "SAM", true, 0);
        Agente agente1 = new Agente(11, "Bustamante", true, 0.15);
        Agente agente2 = new Agente(12, "Ramirez", false, 0.1);
        Agente agente3 = new Agente(13, "Bastidas", false, 0.15);
        Agente agente4 = new Agente(14, "Reinoso", true, 0.181);

        Viajero viajero1 = new Viajero(1, "Carlos", true , 10000);
        Viajero viajero2 = new Viajero(2, "Marcela", false, 20000);
        Viajero viajero3 = new Viajero(3, "Luisa", true, 10000);
        Viajero viajero4 = new Viajero(4, "Andrea", true, 0);
        Viajero viajero5 = new Viajero(5, "Estefania", false, 0);
        Viajero viajero6 = new Viajero(6, "Diana", true, 0);

        Destino destino1 = new Destino("SanAndres", "Colombia", 973);
        

        Hotel hotel1 = new Hotel("Hotelucho", 190, destino1, 100);

        Transporte aereo = new Transporte("Aerotour", "aereo");
        Transporte maritimo = new Transporte("TransMawi", "maritimo");
        Transporte terrestre = new Transporte("La Chalupa", "terrestre");

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
                    System.out.println("Estaremos a su servicios");
                    System.out.println("//-------------------------------------//");
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
                    inscribirViajero();
                    break;
                case 3:
                    clientesMasPresupuesto();
                    break;
                case 4:
                    System.out.println("Holi");
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
            if (eleccion == 1) {
                System.out.println("Listado de agentes:");
                ArrayList<Agente> agentes = Agente.getListaAgentes();
                for (Agente agente : agentes) {
                    System.out.println(agente.getNombre());
                }
                break;
            }
            if (eleccion == 2) {
                System.out.println("Agentes con mas clientes");
                Agente.mejoresAgentes();
                List<Entry<String, Integer>> list = Agente.mejoresAgentes();
                for (int i = list.size() - 1; i > list.size() - 4; i--) {
                    System.out.println(list.get(i));
                }
                break;
            }
            if (eleccion == 3) {
                viajerosPorAgente();

                break;
            } else {
                System.out.println(
                        "Has seleccionado una opcion invalida intentalo de nuevo eligiendo del 1 al 3, si deseas volver al menu anterior presiona 0");

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
                    venderTiquete();
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
            System.out.println("    Visado vigente: " + viajero.isVisado());
            System.out.println("    Millas Acumuladas: " + viajero.getMillas());
            System.out.println("    Presupuesto: " + viajero.getPresupuesto());
            System.out.println("    Agente encargado: ID :" + viajero.getAgente().getCedula() + " Nombre: "
                    + viajero.getAgente().getNombre());
            System.out.println(" ");
        }
        System.out.println("//----------// FIN DE LISTADO DE CLIENTES DE SAM TRAVEL //----------//");
    }
    
    public static void inscribirViajero(){
        boolean a = true;
        int cedula;
        boolean visado = false;
        System.out.println(" ");
        System.out.println("//---------- INSCRIPCIÓN DE VIAJERO ----------//");
        System.out.println(" ");
        while(a){
            System.out.println(" ");
            System.out.println("//-----> Por favor ingrese el documento del nuevo viajero: ");
            cedula = intro.nextInt();
            if(Persona.verificarCedula(cedula)){
                
                System.out.println(" ");
                System.out.println("//-----> Inserte nombre del viajero:");
                String nombre = intro.next();
                System.out.println(" ");
                System.out.println("¿El viajero tiene visado? ");
                System.out.println("        1. Tiene visado.");
                System.out.println("        2. No tiene visado.");
                System.out.println("//-----> Elección a continuación:");
                
                int eleccionVisado = intro.nextInt();
                if (eleccionVisado == 1){
                    visado = true;
                }
                else{
                    visado = false;
                }
                
                a = false;
                Viajero nuevoViajero = new Viajero(cedula,nombre,visado,0);
                
                System.out.println("El viajero " + nuevoViajero.getNombre() + " ha sido creado satisfactoriamente.");
            }
            else{
                System.out.println(" ");
                System.out.println("El número de cédula ingresado ya existe, por favor intentelo nuevamente.");
            }
        }
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



    // MÉTODOS DE MENÚ DE AGENTE:
    public static void viajerosPorAgente() {
        for (int i = 0; i < Agente.numeroAgentes(); i++) {
            Agente aux = Agente.getListaAgentes().get(i);
            if (aux.getListaClientes().isEmpty()) {
                continue;
            } else {
                System.out.println(" El agente: " + aux.getNombre() + " Tienes los siguientes clientes: ");
                System.out.println(" ");
                for (int j = 0; j < aux.getListaClientes().size(); j++) {
                    Viajero v = aux.getListaClientes().get(j);
                    System.out.println(v.getNombre());
                }
                System.out.println(" ");

            }
        }
    }

    // MÉTODOS DE MENÚ DE TURISMO:
    // MÉTODOS DE MENÚ DE VENTAS:
    public static void venderTiquete() {

        // Variables que se usarán en el método.
        Viajero viajero = null;
        Agente agenteAsignado = null;
        Destino destino = null;
        String ciudad;
        boolean v = true;
        boolean a = true;

        System.out.println(" ");
        System.out.println("//----------//PLATAFORMA DE VENTA DE TIQUETES//----------//");
        System.out.println(" ");

        // Se pregunta por el documento del viajero para después verificar si se encuentra o no entre los inscritos:
        while (v) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Inserte el número de documento de la persona que va a viajar:");
            int cedulaViajero = intro.nextInt();
            if (Viajero.verificarCedula(cedulaViajero)) {
                viajero = Viajero.devolverPorCedula(cedulaViajero);
                agenteAsignado = viajero.getAgente();
                System.out.println("Usuario: " + viajero.getNombre() + " encontrado y listo para viajar.");
                v = false;
            } else {
                System.out.println("No se encontró un usuario con el número de cedula ingreso, por favor intentelo nuevamente.");
                System.out.println(" ");
                System.out.println(" ");
            }
        }

        //Seleccionar sitios turísticos disponibles
        System.out.println("");
        System.out.println("A continuación el listado de sitios turísticos disponibles para su viaje: ");
        System.out.println(" ");
        for (Destino d : Destino.destinos) {
            System.out.println("//----------------------------------------//");
            System.out.println("   Ciudad: " + d.getCiudad());
            System.out.println("   Pais: " + d.getPais());
            System.out.println(" ");
        }

        System.out.println("//-----> Escriba el nombre de la ciudad a viajar.");
        ciudad = intro.next();
        for (Destino d : Destino.destinos) {
            if (d.getCiudad().equals(ciudad)) {
                destino = d;
            }
        }

        //Listado de hoteles en ese destino
        System.out.println("");
        System.out.println("A continuación el listado de hoteles disponibles en ese destino: ");
        System.out.println(" ");
        for (Hotel h : destino.getHoteles()) {
            System.out.println("//----------------------------------------//");
            System.out.println("   Nombre: " + h.getNombre());
            System.out.println("   Estrellas: " + h.getEstrellas());
            System.out.println("   Costo: " + h.getCosto());
            System.out.println(" ");
        }

        //Selección de transporte
        System.out.println("");
        System.out.println("//-----> Por favor seleccione el medio de transporte: ");
        System.out.println("  1.Aereo");
        System.out.println("  2.Terrestre");
        System.out.println("  3.Marítimo");
        System.out.println(" ");
        System.out.println("  Su eleccion:");

        int eleccionTransporte = intro.nextInt();
        Transporte transporte = null;
        switch (eleccionTransporte) {
            case 1:
                transporte = new Transporte("Latam", "aereo");
            case 2:
                transporte = new Transporte("Coomotor", "terrestre");
            case 3:
                transporte = new Transporte("Maribell", "maritimo");
        }

        
        Tiquete miTiquete = new Tiquete(viajero, agenteAsignado, transporte, destino);
        
        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//--------COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---------//");
        System.out.println("//                                                           //");
        System.out.println("// Documento: " + viajero.getCedula());
        System.out.println("// A nombre de: " + viajero.getNombre());
        System.out.println("// Con destino a : " + destino.getCiudad() + ", " + destino.getPais());
        System.out.println("// Transporte a cargo de: " + transporte.getNombre() + "(" + transporte.getTipo()+")");
        System.out.println("// Tiempo de Viaje: " + miTiquete.getTiempoViaje() + " horas");
        System.out.println("// Agente encargado: ID " + agenteAsignado.getCedula() + " Nombre: " +  agenteAsignado.getNombre());
        System.out.println(" ");
        System.out.println("// PRECIO TOTAL: " + miTiquete.getPrecio());
        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//-----------------------------------------------------------//");
        System.out.println(viajero.getMillas());
        
    }
    
}


// Código basura
/*
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
            System.out.println("La nueva nacionalidad de " + aux.getNombre() + " con documento: " + aux.getCedula()
                    + " es: " + aux.getNacionalidad());
            System.out.println(" ");
        }

    }
*/
