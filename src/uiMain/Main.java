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
    public static Texto text = new Texto();

    public static void main(String[] args) {

        boolean sesion = true;
        int eleccion = 0;
        int eleccion2 = 0;

        //INSTANCIAS DE AGENTE
        Agente agenteSupremo = new Agente(10, "SAM", true, 0.13);
        Agente agente1 = new Agente(11, "Bustamante", true, 0.15);
        Agente agente2 = new Agente(12, "Ramirez", false, 0.12);
        Agente agente3 = new Agente(13, "Bastidas", false, 0.15);
        Agente agente4 = new Agente(14, "Castillo", true, 0.18);
        Agente agente5 = new Agente(15, "Reinoso", true, 0.18);

        //INSTANCIAS DE VIAJERO
        Viajero viajero1 = new Viajero(1, "Carlos", true, 5000);
        Viajero viajero2 = new Viajero(2, "Marcela", false, 20000);
        Viajero viajero3 = new Viajero(3, "Luisa", true, 1000);
        Viajero viajero4 = new Viajero(4, "Andrea", false, 1100);
        Viajero viajero5 = new Viajero(5, "Estefania", false, 1000);
        Viajero viajero6 = new Viajero(6, "Diana", true, 10000);
        Viajero viajero7 = new Viajero(7, "Ulises", false, 2500);
        Viajero viajero8 = new Viajero(8, "Julio", true, 4300);
        Viajero viajero9 = new Viajero(9, "Alberto", false, 5000);

        //INSTANCIAS DE DESTINO
        Destino destino1 = new Destino("SanAndres", 500, false, true, false);
        Destino destino2 = new Destino("Cartagena", 300, false, true, true);
        Destino destino3 = new Destino("BuenosAires", 1000, true, true, true);
        Destino destino4 = new Destino("RioDeJaneiro", 800, true, true, false);
        Destino destino5 = new Destino("Cusco", 400, true, false, true);
        Destino destino6 = new Destino("Bogota", 100, false, false, true);
        Destino destino7 = new Destino("Santiago", 1000, true, true, true);
        Destino destino8 = new Destino("Panama", 800, false, true, false);
        Destino destino9 = new Destino("Lima", 700, false, true, true);
        Destino destino10 = new Destino("Patagonia", 1200, true, false, false);

        //INSTANCIAS DE HOTEL
        Hotel hotel1 = new Hotel("Andira", 60, destino1, 2);
        Hotel hotel2 = new Hotel("Tiburon", 80, destino1, 3);
        Hotel hotel3 = new Hotel("PlayaBlanca", 120, destino1, 4);
        Hotel hotel4 = new Hotel("Decameron", 160, destino1, 5);
        Hotel hotel5 = new Hotel("Litium", 110, destino2, 4);
        Hotel hotel6 = new Hotel("Hijano", 90, destino2, 3);
        Hotel hotel7 = new Hotel("Luxury", 120, destino3, 5);
        Hotel hotel8 = new Hotel("Tango", 80, destino3, 5);
        Hotel hotel9 = new Hotel("Angel", 70, destino3, 4);
        Hotel hotel10 = new Hotel("CostaDelSol", 60, destino4, 4);
        Hotel hotel11 = new Hotel("Limon", 60, destino5, 2);
        Hotel hotel12 = new Hotel("Tiburon", 80, destino5, 1);
        Hotel hotel13 = new Hotel("Chocolate", 60, destino6, 4);
        Hotel hotel14 = new Hotel("Normandy", 70, destino6, 3);
        Hotel hotel15 = new Hotel("Bugaloo", 85, destino7, 4);
        Hotel hotel16 = new Hotel("Revolucion", 100, destino7, 3);
        Hotel hotel17 = new Hotel("SanBlas", 130, destino8, 4);
        Hotel hotel18 = new Hotel("LaMiel", 60, destino8, 2);
        Hotel hotel19 = new Hotel("Barreda", 160, destino8, 5);
        Hotel hotel20 = new Hotel("Ceviche", 110, destino9, 4);

        //INSTANCIAS DE TRANSPORTE
        Transporte transporte1 = new Transporte("aereo", destino1);
        Transporte transporte2 = new Transporte("maritimo", destino2);
        Transporte transporte3 = new Transporte("terrestre", destino3);
        Transporte transporte4 = new Transporte("maritimo", destino3);
        Transporte transporte5 = new Transporte("aereo", destino4);
        Transporte transporte6 = new Transporte("terrestre", destino5);
        Transporte transporte7 = new Transporte("aereo", destino5);
        Transporte transporte8 = new Transporte("terrestre", destino7);
        Transporte transporte9 = new Transporte("terrestre", destino9);
        Transporte transporte10 = new Transporte("aereo", destino10);

        //INSTANCIAS DE TIQUETE
        Tiquete tiquete1 = new Tiquete(viajero1, transporte1);
        Tiquete tiquete2 = new Tiquete(viajero2, transporte2);
        Tiquete tiquete3 = new Tiquete(viajero3, transporte3);
        Tiquete tiquete4 = new Tiquete(viajero3, transporte4);
        Tiquete tiquete5 = new Tiquete(viajero4, transporte10);
        Tiquete tiquete6 = new Tiquete(viajero4, transporte6, hotel12, 2);
        Tiquete tiquete7 = new Tiquete(viajero5, transporte7, hotel12, 3);
        Tiquete tiquete8 = new Tiquete(viajero6, transporte8, hotel15, 5);
        Tiquete tiquete9 = new Tiquete(viajero8, transporte9, hotel20, 4);
        Tiquete tiquete10 = new Tiquete(viajero9, transporte5, hotel10, 8);

        // MENUS PARA SUPERUSUARIO 
        text.presentacion();
        while (sesion) {
            text.menuUsuario();
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
            text.menuViajero();
            eleccion = intro.nextInt();
            switch (eleccion) {
                case 1:
                    imprimirClientes();
                    break;
                case 2:
                    inscribirViajero();
                    break;
                case 3:
                    otorgarVisado();
                    break;
                case 4:
                    viajesPorCliente();
                    break;
                case 5:
                    consignarDinero();
                    break;
                case 6:
                    redimirMillas();
                    break;
                case 7:
                    retirarViajero();
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
            text.menuAgente();
            eleccion = intro.nextInt();
            switch (eleccion) {
                case 1:
                    mostrarAgentes();
                    break;
                case 2:
                    mejoresAgentes();
                    break;
                case 3:
                    viajerosPorAgente();
                    break;
                case 4:
                    crearAgente();
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
            text.menuTurismo();
            eleccion = intro.nextInt();
            switch (eleccion) {
                case 1:
                    imprimirDestinos();
                    break;
                case 2:
                    verHotelesDestino();
                    break;
                case 3:
                    crearNuevoDestino();
                    break;
                case 4:
                    crearHotel();
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
            text.menuVenta();
            eleccion = intro.nextInt();
            switch (eleccion) {
                case 1:
                    cotizarViaje();
                    break;
                case 2:
                    venderTiquete();
                    break;
                case 3:
                    imprimirTiquetes();
                    break;
                case 0:
                    sesion = false;
                    break;
            }

        }
    }

    // METODOS DE MENÃš DE VIAJERO:
    public static Viajero seleccionarViajero() {
        boolean v = true;
        Viajero viajero = null;
        while (v) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Inserte el número de documento de la persona: ");
            int cedulaViajero = intro.nextInt();
            if (Viajero.verificarCedula(cedulaViajero)) {
                viajero = Viajero.devolverPorCedula(cedulaViajero);
                System.out.println("//--------------------------------");
                System.out.println("Se encontró el usuario");
                text.imprimirViajero(viajero);
                v = false;
            } else {
                System.out.println("No se encontró un usuario con el número de cedula ingreso, por favor intentelo nuevamente.");
                System.out.println("//----------------------------------------------------------------");
                System.out.println(" ");
            }
        }
        return viajero;
    }

    public static void imprimirClientes() {
        System.out.println(" ");
        System.out.println("//----------// LISTADO DE CLIENTES DE SAM TRAVEL //----------//");
        System.out.println(" ");
        for (Viajero v : Viajero.getListaViajeros()) {
            text.imprimirViajero(v);
        }
        System.out.println("//----------// FIN DE LISTADO DE CLIENTES DE SAM TRAVEL //----------//");
    }

    public static void inscribirViajero() {
        boolean a = true;
        int cedula;
        boolean visado = false;
        System.out.println(" ");
        System.out.println("//---------- INSCRIPCION DE VIAJERO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println(" ");
            System.out.println("//-----> Por favor ingrese el documento del nuevo viajero: ");
            cedula = intro.nextInt();
            if (Persona.verificarCedula(cedula) == false) {

                System.out.println(" ");
                System.out.println("//-----> Inserte nombre del viajero:");
                String nombre = intro.next();
                System.out.println(" ");
                System.out.println("¿El viajero tiene visado? ");
                System.out.println("        1. Tiene visado.");
                System.out.println("        2. No tiene visado.");
                System.out.println("//-----> Eleccion a continuacion:");

                int eleccionVisado = intro.nextInt();
                if (eleccionVisado == 1) {
                    visado = true;
                } else {
                    visado = false;
                }

                a = false;
                Viajero nuevoViajero = new Viajero(cedula, nombre, visado, 0);
                System.out.println(" ");
                System.out.println("El viajero " + nuevoViajero.getNombre() + " ha sido creado satisfactoriamente.");
                System.out.println(" ");
                text.imprimirViajero(nuevoViajero);

            } else {
                System.out.println("El numero de cedula ingresado ya existe, por favor intentelo nuevamente.");
            }
        }
    }

    public static void otorgarVisado() {
        boolean a = true;
        boolean visado;
        int cedula;
        System.out.println(" ");
        System.out.println("//---------- OTORGAR VISADO A VIAJERO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println(" ");
            System.out.println("//-----> Por favor ingrese el documento de viajero que se le otorgara visado: ");
            cedula = intro.nextInt();
            if (Persona.verificarCedula(cedula)) {
                for (Persona p : Persona.getListaPersonas()) {
                    if ((p.getCedula() == cedula) && (p.isVisado() == false)) {
                        p.setVisado(true);
                        System.out.println(" ");
                        System.out.println(" El ciudadan@ " + p.getNombre() + " ahora tiene un visado internacional.");
                        System.out.println(" ");
                        System.out.println("//------------------------------------------------//");
                        a = false;
                    } else if ((p.getCedula() == cedula) && (p.isVisado() == true)) {
                        System.out.println(" ");
                        System.out.println(" El ciudadan@ " + p.getNombre() + " ya tenia un visado internacional.");
                        System.out.println(" ");
                        System.out.println("//------------------------------------------------//");
                        a = false;
                    }
                }
            } else {
                System.out.println(" ");
                System.out.println(" No existe ningun ciudadano con la cedula ingresada, por favor intentalo de nuevo.");
                System.out.println(" ");

            }

        }
    }

    public static void viajesPorCliente() {
        boolean a = true;
        boolean visado;
        int cedula;
        Viajero viajero;
        System.out.println(" ");
        System.out.println("//---------- VIAJES POR CLIENTE ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println(" ");
            System.out.println("//-----> Por favor ingrese el documento de viajero al cual desea ver que viajes ha realizado:");
            cedula = intro.nextInt();
            if (Viajero.verificarCedula(cedula)) {
                viajero = Viajero.devolverPorCedula(cedula);
                if (viajero.haViajado()) {
                    for (Tiquete t : viajero.getViajesRealizados()) {
                        text.imprimirViaje(t);
                    }
                    a = false;
                } else {
                    System.out.println(" ");
                    System.out.println("El viajer@ no ha realizado ningun viaje.");
                    a = false;
                }

            } else {
                System.out.println(" ");
                System.out.println(" No existe ningun viajer@ con la cedula ingresada, por favor intentalo de nuevo.");
                System.out.println(" ");

            }

        }
    }

    public static void consignarDinero() {
        boolean a = true;
        int cedulaCliente;
        int consignacion = 0;
        Viajero viajeroConsigna;
        System.out.println(" ");
        System.out.println("//---------- CONSIGNACION DE DINERO PARA CLIENTES ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println(" ");
            System.out.println("//-----> Por favor digite el documento del cliente que desea consignar dinero:");
            cedulaCliente = intro.nextInt();
            if (Viajero.verificarCedula(cedulaCliente)) {
                viajeroConsigna = Viajero.devolverPorCedula(cedulaCliente);
                System.out.println("//-----> ¿Cuanto dinero desea depositar?");
                consignacion = intro.nextInt();
                viajeroConsigna.consignarDinero(consignacion);
                System.out.println(" ");
                System.out.println("//--------------------------------------------------------------------------");
                System.out.println("Se ha consignado " + consignacion + " pesos a la cuenta de el viajero " + viajeroConsigna.getNombre() + ".");
                System.out.println("El nuevo presupuesto es de : " + viajeroConsigna.getPresupuesto());
                System.out.println("Proceso realizado satisfactoriamente.");
                System.out.println(" ");
                a = false;
            }
        }
    }

    public static void redimirMillas() {
        System.out.println("");
        System.out.println("//----------------- SISTEMA DE REDENCION DE MILLAS ----------------------//");
        System.out.println("");
        Viajero viajero = seleccionarViajero();
        if (viajero.getMillas() > 0) {
            System.out.println("Al viajero " + viajero.getNombre() + " se le redimirán " + viajero.getMillas() + " millas en dinero real.");
            viajero.redimirMillas();
            System.out.println("El nuevo presupuesto de " + viajero.getNombre() + " es de " + viajero.getPresupuesto());
            System.out.println(" ");
        } else {
            System.out.println("");
            System.out.println("El viajero seleccionado no tiene millas por redimir.");
        }

    }

    public static void retirarViajero() {
        System.out.println("");
        System.out.println("//----------------- RETIRO DE VIAJERO ----------------------//");
        System.out.println("");
        Viajero viajero = seleccionarViajero();
        System.out.println(" El viajero " + viajero.getNombre() + " será retirado del sistema.");
        System.out.println(" El presupuesto de " + viajero.getPresupuesto() + " pesos y " + viajero.getMillas() + " millas serán devueltos en dinero al viajero.");
        viajero.redimirMillas();
        System.out.println(" Devolucion total: " + viajero.getPresupuesto() + " pesos.");
        System.out.println(" ");
        viajero.retiroViajero();
        System.out.println(" El viajero ha sido retirado satisfactoriamente del sistema.");
        System.out.println("//---------------------------------------------------------------");

    }

    // METODOS DE MENU DE AGENTE:
    public static void mostrarAgentes() {

        ArrayList<Agente> agentes = Agente.getListaAgentes();
        System.out.println(" ");
        System.out.println("//------------------------------- LISTADO DE AGENTES ----------------------------//");
        System.out.println(" ");
        for (Agente agente : agentes) {
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("    ID: " + agente.getCedula());
            System.out.println("    Nombre: " + agente.getNombre());
            System.out.println("    Identificacion: " + agente.getCedula());
            System.out.println("    Comision ganada: " + agente.getComision());
        }
        System.out.println("//-------------------------------------------------------------");
    }

    public static void mejoresAgentes() {
        System.out.println("Agentes con mas clientes");
        Agente.mejoresAgentes();
        List<Entry<String, Integer>> list = Agente.mejoresAgentes();
        int j = 0;
        for (int i = list.size() - 1; i > list.size() - 4; i--) {
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("    Agente: " + list.get(i).getKey());
            System.out.println("    Numero de clientes atendidos: " + list.get(i).getValue());
            String agente = list.get(i).getKey();
            System.out.println("    Comision: " + Agente.comision(agente));
            System.out.println("    ");
            j++;
        }

    }

    public static void viajerosPorAgente() {
        System.out.println("Introduce la cedula del agente");
        int cedula = intro.nextInt();
        if (Agente.existeAgente(cedula) != null) {
            Agente agente = Agente.existeAgente(cedula);
            if (agente.getListaClientes().size() > 0) {
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("//                                                           //");
                System.out.println(" El agente " + agente.getNombre() + " Tienes los siguientes clientes: ");
                for (Viajero viajero : agente.getListaClientes()) {
                    System.out.println("             nombre:  " + viajero.getNombre());
                }
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("//                                                           //");
            } else {
                System.out.println(" El agente " + agente.getNombre() + " aun no ha realizado ninguna venta ");
            }

        } else {
            System.out.println(" ");
            System.out.println(" El número de cedula ingresado no pertenece a ningún agente.");
            System.out.println(" ");
        }
    }

    public static void crearAgente() {
        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//                                                           //");
        System.out.println("Ingrese la cedula del nuevo agente");
        int cedula = intro.nextInt();
        if (Agente.buscarCedula(cedula)) {
            System.out.println("El agente ya se encuentra registrado");
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("//                                                           //");
        } else {
            System.out.println("Ingrese el nombre del Agente");
            String nombre = intro.next();
            System.out.println("//                                                           //");
            System.out.println("Ingrese el porcentaje de comision ganado por el Agente");
            double pComision = intro.nextDouble();
            Agente agente = new Agente(cedula, nombre, false, pComision);
        }

    }

    // METODOS MENU DE TURISMO:
    public static void imprimirDestinos() {
        System.out.println(" ");
        System.out.println("//---------- LISTADO DE DESTINOS TURISTICOS ----------//");
        System.out.println(" ");
        for (Destino d : Destino.getListaDestinos()) {
            text.imprimirDestino(d);
        }
    }

    public static void verHotelesDestino() {
        Destino destino;
        boolean a = true;
        while (a) {
            System.out.println("//-----> Por favor digite el nombre del destino que desea consultar: ");
            String nombreDestino = intro.next();
            if (Destino.existeDestino(nombreDestino)) {
                destino = Destino.devolverDestino(nombreDestino);
                if (destino.tieneHoteles()) {
                    System.out.println(" ");
                    System.out.println("//---------- LISTADO DE HOTELES PARA " + destino.getNombre() + " ----------//");
                    System.out.println(" ");
                    for (Hotel h : destino.getHoteles()) {
                        text.imprimirHotel(h);
                    }
                    a = false;
                } else {
                    System.out.println(" ");
                    System.out.println("No existen hoteles en este destino turistico.");
                    a = false;
                }
            } else {
                System.out.println(" ");
                System.out.println("El destino escrito no existe, por favor intentelo de nuevo.");
            }
        }
    }

    public static void crearNuevoDestino() {
        boolean a = true;
        String nombreDestino = " ";
        int distancia;
        int respuestaVisado;
        int respuestaMar;
        int respuestaTierra;
        boolean visa;
        boolean accesoMar = false;
        boolean accesoTierra = false;
        String tipoTransporte;
        System.out.println(" ");
        System.out.println("//---------- CREACION DE NUEVO DESTINO TURISTICO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println("//-----------------------------------------------------------------");
            System.out.println("//-----> Por favor digite el nombre del Destino turístico a crear:");
            nombreDestino = intro.next();
            if (!Destino.existeDestino(nombreDestino)) {

                System.out.println(" ");
                System.out.println("//----------------------------------------------------");
                System.out.println("//-----> ¿A que distancia en kilometros esta el Destino de Medellin?");
                distancia = intro.nextInt();
                System.out.println(" ");
                System.out.println("//----------------------------------------------------");
                System.out.println("¿El Destino exige visado para poder viajar? ");
                System.out.println("        1. Exige.");
                System.out.println("        2. No es necesario.");
                System.out.println("//-----> Elección a continuacion:");
                respuestaVisado = intro.nextInt();

                if (respuestaVisado == 1) {
                    visa = true;
                } else {
                    visa = false;
                }

                System.out.println(" ");
                System.out.println("//------------------------------------------- ");
                System.out.println("¿El Destino tiene acceso por via maritima? ");
                System.out.println("        1. Tiene entrada por mar.");
                System.out.println("        2. No tiene.");
                System.out.println("//-----> Elección a continuación");
                respuestaMar = intro.nextInt();

                if (respuestaMar == 1) {
                    accesoMar = true;
                } else if (respuestaMar == 2) {
                    accesoMar = false;
                } else {
                    System.out.println("");
                    System.out.println("Ud no digito una opcion valida.");
                    System.out.println("Se considerara que el destino no tiene acceso por mar.");
                }

                System.out.println(" ");
                System.out.println("//------------------------------------------- ");
                System.out.println("¿El Destino tiene acceso por via terrestre? ");
                System.out.println("        1. Tiene acceso por tierra.");
                System.out.println("        2. No tiene.");
                System.out.println("//-----> Elección a continuacion");
                respuestaTierra = intro.nextInt();

                if (respuestaTierra == 1) {
                    accesoTierra = true;
                } else if (respuestaMar == 2) {
                    accesoTierra = false;
                } else {
                    System.out.println("");
                    System.out.println("Ud no digito una opcion valida");
                    System.out.println("Se considerara que el destino no tiene acceso por tierra.");
                }

                Destino destino = new Destino(nombreDestino, distancia, visa, accesoMar, accesoTierra);
                System.out.println(" ");
                System.out.println("Un nuevo destino turistico a sido creado satisfactoriamente.");
                System.out.println(" ");
                text.imprimirDestino(destino);
                System.out.println(" ");
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turistico escrito ya existe.");
                System.out.println("Por favor intentelo de nuevo.");
                System.out.println(" ");
            }
        }
    }

    public static void crearHotel() {
        boolean a = true;
        String nombreDestino = " ";
        String nombreNuevoHotel = " ";
        int estrellas;
        int costoPorNoche;
        Destino destinoDondeConstruir;
        System.out.println(" ");
        System.out.println("//---------- CREACION DE HOTEL ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println("//-----> Por favor digite el nombre del Destino turistico en el cual desea crear un hotel:");
            nombreDestino = intro.next();
            if (Destino.existeDestino(nombreDestino)) {
                destinoDondeConstruir = Destino.devolverDestino(nombreDestino);
                System.out.println(" ");
                System.out.println("//-----> ¿Como se llamara el nuevo Hotel?");
                nombreNuevoHotel = intro.next();
                System.out.println(" ");
                System.out.println("¿De que categoria es el hotel? ");
                System.out.println(" ");
                System.out.println("        1. 1 Estrella.");
                System.out.println("        2. 2 Estrellas.");
                System.out.println("        3. 3 Estrellas.");
                System.out.println("        4. 4 Estrellas.");
                System.out.println("        5. 5 Estrellas.");
                System.out.println(" ");
                System.out.println("//-----> Eleccion a continuacion:");
                estrellas = intro.nextInt();
                System.out.println(" ");
                System.out.println("//-----> Por ultimo ¿Cuanto es el costo por noche?");
                costoPorNoche = intro.nextInt();
                Hotel hotel = new Hotel(nombreNuevoHotel, costoPorNoche, destinoDondeConstruir, estrellas);
                System.out.println(" ");
                System.out.println("Un nuevo hotel en " + destinoDondeConstruir.getNombre() + " ha sido creado satisfactoriamente.");
                System.out.println("");
                text.imprimirHotel(hotel);
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turistico digitado no existe.");
                System.out.println("Por favor intentelo de nuevo.");
                System.out.println(" ");
            }
        }
    }

    // METODOS DE MENU DE VENTAS:
    public static void cotizarViaje() {
        boolean a = true;
        Viajero viajero;
        int cedula;
        System.out.println(" ");
        System.out.println("//---------- COTIZACION DE VIAJES ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println("//-----> Por favor digite la cedula del viajer@ que desea cotizar un viaje: ");
            cedula = intro.nextInt();
            if (Viajero.verificarCedula(cedula)) {
                viajero = Viajero.devolverPorCedula(cedula);
                posiblesTransportes(viajero);
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("No hay ningun viajero con la cedula digitada.");
            }

        }

    }

    public static void venderTiquete() {

        // Variables que se usarán en el método.
        Viajero viajero = null;
        Destino destino = null;
        Transporte transporte = null;
        Hotel hotel = null;
        String tipoTransporte = "";
        boolean reservaHotel;
        int diasEstadia = 0;
        int cobranza = 0;
        boolean puedeViajar;
        boolean c = true;
        boolean d = true;

        System.out.println(" ");
        System.out.println("//----------//PLATAFORMA DE VENTA DE TIQUETES//----------//");
        System.out.println(" ");

        // Se pregunta por el documento del viajero para después verificar si se encuentra o no entre los inscritos:
        viajero = seleccionarViajero();

        //Selección de medio de transporte:
        //
        Map<Destino, int[]> catalogoTransporte = posiblesTransportes(viajero);
        puedeViajar = !catalogoTransporte.isEmpty();

        if (!puedeViajar) {
            System.out.println("El viajero no cuenta con el dinero suficiente para realizar alguno de los viajes.");
            System.out.println("//---------------------------------------------------------------------------------");
        }

        while ((c) && (puedeViajar)) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Digite el nombre del destino turístico al que desea viajar:");
            String decisionDestino = intro.next();
            if (Destino.existeDestino(decisionDestino)) {
                destino = Destino.devolverDestino(decisionDestino);
                c = false;
            } else {
                System.out.println(" ");
                System.out.println("No digitó ningún destino turístico conocido.");
                System.out.println("Por favor vuelvalo a intentar.");
                System.out.println(" ");
            }
        }
        while ((d) && (puedeViajar)) {
            int[] info = new int[3];
            info = catalogoTransporte.get(destino);
            System.out.println(" ");
            System.out.println("//---------- SAM TRAVEL -----------// ");
            System.out.println(" ");
            System.out.println("Elija su próximo viaje: ");
            System.out.println(" ");
            for (int i = 0; i < info.length; i++) {
                if ((i == 0) && (info[i] != -1)) {
                    System.out.println(" ------> 1. Tiquete Aereo por: " + info[i] + " pesos.");
                } else if ((i == 1) && (info[i] != -1)) {
                    System.out.println(" ------> 2. Tiquete Terrestre por: " + info[i] + " pesos.");
                } else if ((i == 2) && (info[i] != -1)) {
                    System.out.println(" ------> 3. Tiquete Marítimo por " + info[i] + " pesos.");
                }
            }

            System.out.println(" ");
            System.out.println("    DINERO :" + viajero.getPresupuesto() + " pesos.");
            System.out.println(" ");
            System.out.println("//-----> Digite el número del Tiquete que desea adquirir.");
            int noTiquete = intro.nextInt();
            if (noTiquete == 1) {
                tipoTransporte = "aereo";
                d = false;
            } else if (noTiquete == 2) {
                tipoTransporte = "terrestre";
                d = false;
            } else if (noTiquete == 3) {
                tipoTransporte = "maritimo";
                d = false;
            } else {
                System.out.println(" ");
                System.out.println("Ud no digitó una opción válida.");
                System.out.println("Vuelvalo a intentar.");
                System.out.println("//-------------------------------------------");
            }
            cobranza = info[noTiquete - 1];
        }
        if (puedeViajar) {
            viajero.pagar(cobranza); // VIAJERO PAGA EL TIQUETE DE TRANSPORTE.
            transporte = new Transporte(tipoTransporte, destino); //CREACIÓN DE TRANSPORTE.

            if (viajero.puedePagarHotel(destino) && (destino.tieneHoteles())) {
                //Listado de hoteles en ese destino
                System.out.println("");
                System.out.println("A continuación el listado de hoteles disponibles en " + destino.getNombre());
                System.out.println(" ");
                for (Hotel h : destino.getHoteles()) {
                    if (viajero.getPresupuesto() >= h.getCosto()) {
                        text.imprimirHotel(h);
                    }
                }
                hotel = seleccionHotel(viajero, destino);
                diasEstadia = seleccionDiasEstadia(viajero, hotel);
                reservaHotel = true;

            } else if (!destino.tieneHoteles()) {
                System.out.println(" ");
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("Lastimosamente el destino turistico seleccionado");
                System.out.println("No tiene oferta hotelera disponible.");
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("");
                reservaHotel = false;
            } else {
                System.out.println(" ");
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("Al viajero No le alcanza para pagar un hotel.");
                System.out.println("//-----------------------------------------------------------//");
                System.out.println("");
                reservaHotel = false;
            }

            //CREACION DE TIQUETE DEFINITIVO
            if (reservaHotel) {
                Tiquete miTiquete = new Tiquete(viajero, transporte, hotel, diasEstadia);
                text.imprimirTiquete(miTiquete);
            } else {

                Tiquete miTiquete = new Tiquete(viajero, transporte);
                text.imprimirTiquete(miTiquete);
            }
        }

    }

    public static Map<Destino, int[]> posiblesTransportes(Viajero viajero) {
        System.out.println(" ");
        System.out.println("//------- OFERTA DE TRANSPORTE PARA EL VIAJERO " + viajero.getNombre() + " -------//");
        System.out.println(" ");
        System.out.println(" A continuación se imprimirán todas los posibles tiquetes de transporte que podría comprar el viajero.");
        System.out.println("    Esto último a partir de su presupuesto actual de " + viajero.getPresupuesto() + " pesos.");
        System.out.println("");
        System.out.println("//--------------------------------------------------------------------------------------");
        System.out.println(" ");

        //Proceso para determinar cuales tiquetes de viaje puede costear el Viajero.
        Map<Destino, int[]> opcionesTransporte = Destino.esPosibleViajar(viajero);
        opcionesTransporte.forEach((key, value) -> {
            System.out.println("//---------------------------------------------");
            System.out.println("Destino: " + key.getNombre());
            for (int i = 0; i < value.length; i++) {
                if ((i == 0) && (value[i] != -1)) {
                    System.out.println("    Costo tiquete aereo: " + value[0] + " pesos.");
                } else if ((i == 1) && (value[i] != -1)) {
                    System.out.println("    Costo tiquete terrestre: " + value[1] + " pesos.");
                } else if ((i == 2) && (value[i] != -1)) {
                    System.out.println("    Costo tiquete maritimo:  " + value[2] + " pesos.");
                }
            }
        });
        System.out.println("//---------------------------------------------");
        System.out.println(" ");
        return opcionesTransporte;
    }

    public static Hotel seleccionHotel(Viajero v, Destino d) {
        boolean c = true;
        Hotel hotel = null;
        while (c) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Digite el nombre del Hotel en el que desea hospedarse: ");
            String decisionHotel = intro.next();
            if (Hotel.existeHotel(decisionHotel)) {
                hotel = Hotel.devolverHotel(decisionHotel);
                c = false;
            } else {
                System.out.println(" ");
                System.out.println("No digitó ningún destino turístico conocido.");
                System.out.println("Por favor vuelvalo a intentar.");
                System.out.println(" ");
            }
        }
        return hotel;
    }

    public static int seleccionDiasEstadia(Viajero v, Hotel h) {
        boolean c = true;
        int limiteDias = (int) Math.floor(v.getPresupuesto() / h.getCosto());
        int estadia = 1;
        if (limiteDias == 1) {
            return estadia;
        } else {
            while (c) {
                System.out.println(" ");
                System.out.println("//-----------------------------------------------------------------------");
                System.out.println("El hotel elegido tiene un costo por noche de: " + h.getCosto() + " pesos.");
                System.out.println("Según el presupuesto del viajero, se podría hospedar en el hotel entre 1 y " + limiteDias + " días.");
                System.out.println(" ");
                System.out.println("//-----> Digite la cantidad de días que desea hospedarse en el hotel " + h.getNombre() + ":");
                int dias = intro.nextInt();
                if ((dias >= 1) && (dias <= limiteDias)) {
                    estadia = dias;
                    c = false;
                } else {
                    System.out.println(" ");
                    System.out.println("No digitó un día dentro del rango posible.");
                    System.out.println("Por favor vuelvalo a intentar.");
                    System.out.println(" ");
                }
            }
            return estadia;
        }
    }

    public static void imprimirTiquetes() {

        System.out.println(" ");
        System.out.println("//-------- LISTADO DE VIAJES REALIZADOS POR SAM TRAVEL --------//");
        System.out.println(" ");
        for (Tiquete t
                : Tiquete.getViajesRealizados()) {

            text.imprimirTiquete(t);
            System.out.println(" ");
        }
    }

}

// CÃ³digo basura
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
            System.out.println("La cÃ©dula insertada no se encuentra inscrita en nuestro sistema.");
            System.out.println(" ");
            System.out.println("Por favor vuelvalo a intentar.");
            System.out.println(" ");
        } else {
            System.out.println(" Inserte su nuevo paÃ­s de origen:");
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
 */
