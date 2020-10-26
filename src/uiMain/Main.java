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

        //INSTANCIAS
        Agente agenteSupremo = new Agente(10, "SAM", true, 0);
        Agente agente1 = new Agente(11, "Bustamante", true, 0.15);
        Agente agente2 = new Agente(12, "Ramirez", false, 0.1);
        Agente agente3 = new Agente(13, "Bastidas", false, 0.15);
        Agente agente4 = new Agente(14, "Reinoso", true, 0.18);

        Viajero viajero1 = new Viajero(1, "Carlos", true, 1000400);
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

    // MENUS PARA SUPERUSUARIO 
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
                case 0:
                    sesion = false;
                    break;

            }

        }
    }

    public static void menuAgente() {
        boolean sesion = true;
        int eleccion = 0;
        text.menuAgente();
        while (sesion) {
            eleccion = intro.nextInt();
            if (eleccion == 1) {
                mostrarAgentes();
                break;
            }
            if (eleccion == 2) {
                mejoresAgentes();
                break;
            }
            if (eleccion == 3) {
                viajerosPorAgente();
                break;
            } 
            
            if (eleccion == 4) {
                crearAgente();
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
                    System.out.println("Reembolso de Viajes.");
                    break;
                case 0:
                    sesion = false;
                    break;
            }

        }
    }

    // MÃ‰TODOS DE MENÃš DE VIAJERO:
    /*
        
     */
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
        System.out.println("//---------- INSCRIPCIÃ“N DE VIAJERO ----------//");
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
                System.out.println("Â¿El viajero tiene visado? ");
                System.out.println("        1. Tiene visado.");
                System.out.println("        2. No tiene visado.");
                System.out.println("//-----> ElecciÃ³n a continuaciÃ³n:");

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
                System.out.println("El nÃºmero de cÃ©dula ingresado ya existe, por favor intentelo nuevamente.");
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
            System.out.println("//-----> Por favor ingrese el documento de viajero que se le otorgarÃ¡ visa: ");
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
                        System.out.println(" El ciudadan@ " + p.getNombre() + " ya tenÃ­a un visado internacional.");
                        System.out.println(" ");
                        System.out.println("//------------------------------------------------//");
                        a = false;
                    }
                }
            } else {
                System.out.println(" ");
                System.out.println(" No existe ningÃºn ciudadano con la cÃ©dula ingresada, por favor intentalo de nuevo.");
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
            System.out.println("//-----> Por favor ingrese el documento de viajero al cuÃ¡l desea ver que viajes ha realizado:");
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
                    System.out.println("El viajer@ no ha realizado ningÃºn viaje.");
                    a = false;
                }

            } else {
                System.out.println(" ");
                System.out.println(" No existe ningÃºn viajer@ con la cÃ©dula ingresada, por favor intentalo de nuevo.");
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
                System.out.println("//-----> Â¿Cuanto dinero desea depositar?");
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

    // MÃ‰TODOS DE MENÃš DE AGENTE:
    static void mostrarAgentes() {
		System.out.println("Listado de agentes:");
	    ArrayList<Agente> agentes = Agente.getListaAgentes();
	    System.out.println("Lista de Agentes");
	    for (Agente agente : agentes) {
	    	System.out.println("//-----------------------------------------------------------//");	
	    	System.out.println("//                                                           //");
	        System.out.println("Nombre: " + agente.getNombre());
	        System.out.println("Identificacion: " + agente.getCedula());
	        System.out.println("//                                                           //");
	        System.out.println("//-----------------------------------------------------------//");
	    }
    }
    
    static void mejoresAgentes() {
    	System.out.println("Agentes con mas clientes");
		Agente.mejoresAgentes();
		List<Entry<String, Integer>> list = Agente.mejoresAgentes();
		int j = 0;
		for (int i = list.size() - 1; i > list.size() - 4; i--) {			 
			System.out.println("//-----------------------------------------------------------//");	
	    	System.out.println("//                                                           //");
			System.out.println("Agente: " + list.get(i).getKey());
			System.out.println("Numero de viajes vendidos: " + list.get(i).getValue());
			String agente = list.get(i).getKey();
			System.out.println("Comision: " + Agente.comision(agente));
			System.out.println("//                                                           //");
	        System.out.println("//-----------------------------------------------------------//");
	        j++;
		}
		
    }
    
    
    public static void viajerosPorAgente() {
    	System.out.println("Introduce la cedula del agente");
    	int cedula = intro.nextInt();
    	if (Agente.existeAgente(cedula) != null) {
    		Agente agente = Agente.existeAgente(cedula);
    		if(agente.getListaClientes().size() > 0) {
    			System.out.println("//-----------------------------------------------------------//");	
    	    	System.out.println("//                                                           //");
        		System.out.println(" El agente " + agente.getNombre() + " Tienes los siguientes clientes: ");
        		for (Viajero viajero : agente.getListaClientes()) {
        			System.out.println("             nombre:  " + viajero.getNombre() );
    			}
        		System.out.println("//-----------------------------------------------------------//");	
    	    	System.out.println("//                                                           //");    			
    		}
    		else {
    			System.out.println(" El agente " + agente.getNombre() + " aun no ha realizado ninguna venta ");
    		}
    		
    		
    	}
    }
    
    
    static int numeroAgente = 1;
    public static void crearAgente(){
    	System.out.println("//-----------------------------------------------------------//");	
    	System.out.println("//                                                           //");
    	System.out.println("Ingrese la cedula del nuevo agente");
    	int cedula = intro.nextInt();
    	if(Agente.buscarCedula(cedula)) {
    		System.out.println("El agente ya se encuentra registrado");
    		System.out.println("//-----------------------------------------------------------//");	
	    	System.out.println("//                                                           //");
    	}
    	else {
    		System.out.println("Ingrese el nombre del Agente");
    		String nombre = intro.next();
    		System.out.println("//                                                           //");
    		System.out.println("Ingrese el porcentaje de comision ganado por el Agente");
    		double pComision = intro.nextDouble();  
    		Agente agente = new Agente(cedula, nombre, false, pComision);   		
    	}
    	
    	
    }

    // MÃ‰TODOS DE MENÃš DE TURISMO:
    public static void imprimirDestinos() {
        System.out.println(" ");
        System.out.println("//---------- LISTADO DE DESTINOS TURÃ�STICOS ----------//");
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
                        text.imprimirHoteles(h);
                    }
                    a = false;
                } else {
                    System.out.println(" ");
                    System.out.println("No existen hoteles en este destino turÃ­stico.");
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
        String tipoTransporte;
        System.out.println(" ");
        System.out.println("//---------- CREACION DE NUEVO DESTINO TURISTICO ----------//");
        System.out.println(" ");
        while (a) {
            System.out.println("//-----> Por favor digite el nombre del Destino turÃ­stico a crear:");
            nombreDestino = intro.next();
            if (!Destino.existeDestino(nombreDestino)) {

                System.out.println(" ");
                System.out.println("//-----> Â¿A que distancia esta el Destino de Medellin?");
                distancia = intro.nextInt();
                System.out.println(" ");
                System.out.println("Â¿El Destino exige visado para poder viajar? ");
                System.out.println("        1. Exige.");
                System.out.println("        2. No es necesario.");
                System.out.println("//-----> ElecciÃ³n a continuaciÃ³n:");
                respuestaVisado = intro.nextInt();

                if (respuestaVisado == 1) {
                    visa = true;
                } else {
                    visa = false;
                }

                Destino destino = new Destino(nombreDestino, distancia, visa);
                System.out.println(" ");
                System.out.println("Un nuevo destino turÃ­stico a sido creado satisfactoriamente.");
                System.out.println(" ");
                text.imprimirDestino(destino);
                System.out.println(" ");
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turÃ­stico escrito ya existe.");
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
            System.out.println("//-----> Por favor digite el nombre del Destino turÃ­stico en el cual desea crear un hotel:");
            nombreDestino = intro.next();
            if (Destino.existeDestino(nombreDestino)) {
                destinoDondeConstruir = Destino.devolverDestino(nombreDestino);
                System.out.println(" ");
                System.out.println("//-----> Â¿Como se llamara el nuevo Hotel?");
                nombreNuevoHotel = intro.next();
                System.out.println(" ");
                System.out.println("Â¿De que categorÃ­a es el hotel? ");
                System.out.println("        1. 1 Estrella.");
                System.out.println("        2. 2 Estrellas.");
                System.out.println("        3. 3 Estrellas.");
                System.out.println("        4. 4 Estrellas.");
                System.out.println("        5. 5 Estrellas.");
                System.out.println("//-----> ElecciÃ³n a continuaciÃ³n:");
                estrellas = intro.nextInt();
                System.out.println(" ");
                System.out.println("//-----> Por ultimo Â¿Cuanto es el costo por noche?");
                costoPorNoche = intro.nextInt();
                Hotel hotel = new Hotel(nombreNuevoHotel, costoPorNoche, destinoDondeConstruir, estrellas);
                System.out.println(" ");
                System.out.println("Un nuevo hotel en " + destinoDondeConstruir.getNombre() + " ha sido creado satisfactoriamente.");
                System.out.println("");
                text.imprimirHoteles(hotel);
                a = false;

            } else {
                System.out.println(" ");
                System.out.println("El destino turÃ­stico digitado no existe");
                System.out.println("Por favor intentelo de nuevo.");
            }
        }
    }

    // MÃ‰TODOS DE MENÃš DE VENTAS:
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

            } else {
                System.out.println(" ");
                System.out.println("No hay ningÃºn viajero con la cÃ©dula digitada.");
            }

        }

    }

    public static void venderTiquete() {

        // Variables que se usarÃ¡n en el mÃ©todo.
        Viajero viajero = null;
        Agente agenteAsignado = null;
        Destino destino = null;
        Transporte transporte = null;
        String ciudad;
        String tipoTransporte = "";
        int cobranza = 0;
        boolean v = true;
        boolean a = true;
        boolean c = true;
        boolean d = true;

        System.out.println(" ");
        System.out.println("//----------//PLATAFORMA DE VENTA DE TIQUETES//----------//");
        System.out.println(" ");

        // Se pregunta por el documento del viajero para despuÃ©s verificar si se encuentra o no entre los inscritos:
        while (v) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Inserte el nÃºmero de documento de la persona que va a viajar:");
            int cedulaViajero = intro.nextInt();
            if (Viajero.verificarCedula(cedulaViajero)) {
                viajero = Viajero.devolverPorCedula(cedulaViajero);
                agenteAsignado = viajero.getAgente();
                System.out.println("//----------------------------------------------------------------");
                System.out.println("Viajero: " + viajero.getNombre());
                System.out.println("Con Presupuesto: " + viajero.getPresupuesto() + " pesos.");
                v = false;
            } else {
                System.out.println("No se encontrÃ³ un usuario con el nÃºmero de cedula ingreso, por favor intentelo nuevamente.");
                System.out.println("//----------------------------------------------------------------");
                System.out.println(" ");
            }
        }

        //SelecciÃ³n de medio de transporte:
        //
        Map<Destino, int[]> catalogoTransporte = posiblesTransportes(viajero);

        while (c) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("//-----> Digite el nombre del destino turÃ­stico al que desea viajar:");
            String decisionDestino = intro.next();
            if (Destino.existeDestino(decisionDestino)) {
                destino = Destino.devolverDestino(decisionDestino);
                c = false;
            } else {
                System.out.println(" ");
                System.out.println("No digitÃ³ ningÃºn destino turÃ­stico conocido."
                        + "Por favor vuelvalo a intentar.");
                System.out.println(" ");
            }
        }
        while (d) {
            System.out.println(" ");
            System.out.println("//---------- SAM TRAVEL -----------// ");
            System.out.println(" ");
            System.out.println("Elija su prÃ³ximo viaje: ");
            System.out.println("");

            int[] info = catalogoTransporte.get(destino);
            for (int i = 0; i < info.length; i++) {
                if ((i == 0) && (info[i] != -1)) {
                    System.out.println(" ------> 1. Tiquete Aereo por: " + info[i] + " pesos.");
                } else if ((i == 1) && (info[i] != -1)) {
                    System.out.println(" ------> 2. Tiquete Terrestre por: " + info[i]*2 + " pesos.");
                } else if ((i == 2) && (info[i] != -1)) {
                    System.out.println(" ------> 3. Tiquete MarÃ­timo por " + info[i]*3 + " pesos.");
                }
            }
            System.out.println(" ");
            System.out.println("    DINERO :" + viajero.getPresupuesto() + " pesos.");
            System.out.println("//-----> Digite el nÃºmero del Tiquete que desea adquirir.");
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
                System.out.println("Ud no digitÃ³ una opciÃ³n vÃ¡lida.");
                System.out.println("Vuelvalo a intentar.");
                System.out.println("//-------------------------------------------");
            }
            cobranza = info[noTiquete - 1];
        }

        viajero.pagar(cobranza); // VIAJERO PAGA EL TIQUETE DE TRANSPORTE.
        transporte = new Transporte(tipoTransporte, destino);

        //Listado de hoteles en ese destino
        System.out.println("");
        System.out.println("A continuaciÃ³n el listado de hoteles disponibles en " + destino.getNombre());
        System.out.println(" ");
        for (Hotel h : destino.getHoteles()) {
            System.out.println("//----------------------------------------//");
            System.out.println("   Nombre: " + h.getNombre());
            System.out.println("   Estrellas: " + h.getEstrellas());
            System.out.println("   Costo: " + h.getCosto());
            System.out.println(" ");
        }

        Tiquete miTiquete = new Tiquete(viajero, agenteAsignado, transporte, destino);

        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//--------COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---------//");
        System.out.println("//                                                           //");
        System.out.println("// Documento: " + viajero.getCedula());
        System.out.println("// A nombre de: " + viajero.getNombre());
        System.out.println("// Con destino a : " + destino.getNombre());
        System.out.println("// Transporte de tipo: " + transporte.getTipo());
        System.out.println("// Tiempo de Viaje: " + miTiquete.getTiempoViaje() + " horas");
        System.out.println("// Agente encargado: ID " + agenteAsignado.getCedula() + " Nombre: " + agenteAsignado.getNombre());
        System.out.println(" ");
        System.out.println("// PRECIO TOTAL: " + miTiquete.getPrecio());
        System.out.println("//-----------------------------------------------------------//");
        System.out.println("//-----------------------------------------------------------//");
    }

    public static Map<Destino, int[]> posiblesTransportes(Viajero viajero) {
        System.out.println(" ");
        System.out.println("//------- OFERTA DE TRANSPORTE PARA EL VIAJERO " + viajero.getNombre() + " -------//");
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
        return opcionesTransporte;
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
