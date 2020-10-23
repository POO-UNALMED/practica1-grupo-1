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

        Viajero viajero1 = new Viajero(1, "Carlos", true, 10000);
        Viajero viajero2 = new Viajero(2, "Marcela", false, 20000);
        Viajero viajero3 = new Viajero(3, "Luisa", true, 10000);
        Viajero viajero4 = new Viajero(4, "Andrea", true, 0);
        Viajero viajero5 = new Viajero(5, "Estefania", false, 0);
        Viajero viajero6 = new Viajero(6, "Diana", true, 0);

        Destino destino1 = new Destino("SanAndres", 500, false);
        Destino destino2 = new Destino("Cartagena", 300, false);
        Destino destino3 = new Destino("BuenosAires", 1000, true);
        Destino destino4 = new Destino("RioDeJaneiro", 800, true);

        Hotel hotel1 = new Hotel("Hotelucho", 100, destino1, 2);
        Hotel hotel2 = new Hotel("Chocolate", 60, destino1, 3);

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

    // MENUS PARA SUPERUSUARIO 
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
                    otorgarVisado();
                    break;
                case 4:
                    viajesPorCliente();
                    break;
                case 5:
                    consignarDinero();
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
            Texto.menuVenta();
            eleccion = intro.nextInt();
            switch (eleccion) {
                case 1:
                    cotizarViaje();
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

    public static void inscribirViajero() {
        boolean a = true;
        int cedula;
        boolean visado = false;
        System.out.println(" ");
        System.out.println("//---------- INSCRIPCIÓN DE VIAJERO ----------//");
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
                System.out.println("//-----> Elección a continuación:");

                int eleccionVisado = intro.nextInt();
                if (eleccionVisado == 1) {
                    visado = true;
                } else {
                    visado = false;
                }

                a = false;
                Viajero nuevoViajero = new Viajero(cedula, nombre, visado, 0);

                System.out.println("El viajero " + nuevoViajero.getNombre() + " ha sido creado satisfactoriamente.");
            } else {
                System.out.println(" ");
                System.out.println("El número de cédula ingresado ya existe, por favor intentelo nuevamente.");
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
            System.out.println("//-----> Por favor ingrese el documento de viajero que se le otorgará visa: ");
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
                        System.out.println(" El ciudadan@ " + p.getNombre() + " ya tenía un visado internacional.");
                        System.out.println(" ");
                        System.out.println("//------------------------------------------------//");
                        a = false;
                    }
                }
            } else {
                System.out.println(" ");
                System.out.println(" No existe ningún ciudadano con la cédula ingresada, por favor intentalo de nuevo.");
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
        System.out.println("//---------- OTORGAR VISADO A VIAJERO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println(" ");
            System.out.println("//-----> Por favor ingrese el documento de viajero al cuál desea ver que viajes ha realizado:");
            cedula = intro.nextInt();
            if (Viajero.verificarCedula(cedula)) {
                viajero = Viajero.devolverPorCedula(cedula);
                if (!viajero.getViajesRealizados().isEmpty()) {
                    for (Tiquete t : viajero.getViajesRealizados()) {
                        Texto.imprimirViaje(t);
                    }
                    a = false;
                } else {
                    System.out.println(" ");
                    System.out.println("El viajer@ no ha realizado no ha realizado viajes todavía.");
                    a = false;
                }

            } else {
                System.out.println(" ");
                System.out.println(" No existe ningún viajer@ con la cédula ingresada, por favor intentalo de nuevo.");
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
    public static void imprimirDestinos() {
        System.out.println(" ");
        System.out.println("//---------- LISTADO DE DESTINOS TURÍSTICOS ----------//");
        System.out.println(" ");
        ArrayList<Destino> listaDestinos = Destino.getListaDestinos();
        for (Destino d : listaDestinos) {
            Texto.imprimirDestino(d);
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
                if (!destino.getHoteles().isEmpty()) {
                    System.out.println(" ");
                    System.out.println("//---------- LISTADO DE HOTELES PARA " + destino.getNombre() + " ----------//");
                    System.out.println(" ");
                    for (Hotel h : destino.getHoteles()) {
                        Texto.imprimirHoteles(h);
                    }
                    a = false;
                } else {
                    System.out.println(" ");
                    System.out.println("No existen hoteles en este destino turístico.");
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
        boolean visa;
        System.out.println(" ");
        System.out.println("//---------- CREACION DE NUEVO DESTINO TURISTICO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println("//-----> Por favor digite el nombre del Destino turístico a crear:");
            nombreDestino = intro.next();
            if (!Destino.existeDestino(nombreDestino)) {
                System.out.println(" ");
                System.out.println("//-----> ¿A que distancia esta el Destino de Medellin?");
                distancia = intro.nextInt();
                System.out.println(" ");
                System.out.println("¿El Destino exige visado para poder viajar? ");
                System.out.println("        1. Exige.");
                System.out.println("        2. No es necesario.");
                System.out.println("//-----> Elección a continuación:");
                respuestaVisado = intro.nextInt();
                if (respuestaVisado == 1) {
                    visa = true;
                } else {
                    visa = false;
                }
                Destino destino = new Destino(nombreDestino, distancia, visa);
                System.out.println(" ");
                System.out.println("Un nuevo destino turístico a sido creado satisfactoriamente.");
                System.out.println(" ");
                Texto.imprimirDestino(destino);
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turístico escrito ya existe.");
                System.out.println("Por favor intentelo de nuevo.");
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
            System.out.println("//-----> Por favor digite el nombre del Destino turístico en el cual desea crear un hotel:");
            nombreDestino = intro.next();
            if (Destino.existeDestino(nombreDestino)) {
                destinoDondeConstruir = Destino.devolverDestino(nombreDestino);
                System.out.println(" ");
                System.out.println("//-----> ¿Como se llamara el nuevo Hotel?");
                nombreNuevoHotel = intro.next();
                System.out.println(" ");
                System.out.println("¿De que categoría es el hotel? ");
                System.out.println("        1. 1 Estrella.");
                System.out.println("        2. 2 Estrellas.");
                System.out.println("        3. 3 Estrellas.");
                System.out.println("        4. 4 Estrellas.");
                System.out.println("        5. 5 Estrellas.");
                System.out.println("//-----> Elección a continuación:");
                estrellas = intro.nextInt();
                System.out.println(" ");
                System.out.println("//-----> Por ultimo ¿Cuanto es el costo por noche?");
                costoPorNoche = intro.nextInt();
                Hotel hotel = new Hotel(nombreNuevoHotel, costoPorNoche, destinoDondeConstruir, estrellas);
                System.out.println(" ");
                System.out.println("Un nuevo hotel en " + destinoDondeConstruir.getNombre() + " ha sido creado satisfactoriamente.");
                System.out.println("");
                Texto.imprimirHoteles(hotel);
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turístico digitado no existe");
                System.out.println("Por favor intentelo de nuevo.");
            }
        }
    }

    // MÉTODOS DE MENÚ DE VENTAS:
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
            if(Viajero.verificarCedula(cedula)){
                viajero = Viajero.devolverPorCedula(cedula);
                
            }
            else{
                System.out.println(" ");
                System.out.println("No hay ningún viajero con la cédula digitada.");
            }
            
        }

    }

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
        for (Destino d : Destino.getListaDestinos()) {
            System.out.println("//----------------------------------------//");
            System.out.println("   Destino Turístico : " + d.getNombre());
            System.out.println(" ");
        }

        System.out.println("//-----> Escriba el nombre del Destino turístico a viajar.");
        ciudad = intro.next();
        for (Destino d : Destino.getListaDestinos()) {
            if (d.getNombre().equals(ciudad)) {
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
                break;
            case 2:
                transporte = new Transporte("Coomotor", "terrestre");
                break;
            case 3:
                transporte = new Transporte("Maribell", "maritimo");
                break;
        }

        Tiquete miTiquete = new Tiquete(viajero, agenteAsignado, transporte, destino);

        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//--------COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---------//");
        System.out.println("//                                                           //");
        System.out.println("// Documento: " + viajero.getCedula());
        System.out.println("// A nombre de: " + viajero.getNombre());
        System.out.println("// Con destino a : " + destino.getNombre());
        System.out.println("// Transporte a cargo de: " + transporte.getNombre() + "(" + transporte.getTipo() + ")");
        System.out.println("// Tiempo de Viaje: " + miTiquete.getTiempoViaje() + " horas");
        System.out.println("// Agente encargado: ID " + agenteAsignado.getCedula() + " Nombre: " + agenteAsignado.getNombre());
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
