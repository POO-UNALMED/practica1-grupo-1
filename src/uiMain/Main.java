package uiMain;

import gestorAplicacion.persons.Agente;
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
        Agente agenteSupremo = new Agente(10, "SAM", "Colombia", "alma", 0);
        Agente agente1 = new Agente(1087904564, "Carlos Bustamente", "Colombia", "Viaja facil", 0.15);
        Agente agente2 = new Agente(1094520234, "Juan Ramirez", "Colombia", "Despegar", 0.1);
        Agente agente3 = new Agente(1087904564, "Lucas Bastidas", "Colombia", "Despegar", 0.15);

        Viajero viajero1 = new Viajero(1, "Carlos", "Colombia", 1000, agente2);
        Viajero viajero2 = new Viajero(2, "Marcela", "Colombia", 2000, agente2);
        Viajero viajero3 = new Viajero(3, "Luisa", "Alemania", 0, agente1);
        Viajero viajero4 = new Viajero(3, "Andrea", "Alemania", 0, agente1);
        Viajero viajero5 = new Viajero(3, "Estefania", "Rusia", 0, agente1);
        Viajero viajero6 = new Viajero(3, "Diana", "Inglaterra", 0, agente3);

        Destino.setDestinoSinVisado("Albania");
        Destino.setDestinoSinVisado("Alemania");
        Destino.setDestinoSinVisado("Andorra");
        Destino.setDestinoSinVisado("Austria");
        Destino.setDestinoSinVisado("Belgica");
        Destino.setDestinoSinVisado("Bosnia");
        Destino.setDestinoSinVisado("Croacia");
        Destino.setDestinoSinVisado("Dinamarca");
        Destino.setDestinoSinVisado("Espana");

        Destino destino1 = new Destino("San Andres", "Colombia", 973);

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
            System.out.println("    País de origen: " + viajero.getNacionalidad());
            System.out.println("    Millas Acumuladas: " + viajero.getMillas());
            System.out.println("    Presupuesto: " + viajero.getPresupuesto());
            System.out.println("    Agente encargado: ID :" + viajero.getAgente().getCedula() + " Nombre: "
                    + viajero.getAgente().getNombre());
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
            System.out.println("La nueva nacionalidad de " + aux.getNombre() + " con documento: " + aux.getCedula()
                    + " es: " + aux.getNacionalidad());
            System.out.println(" ");
        }

    }

    // MÉTODOS DE MENÚ DE AGENTE:
    public static void viajerosPorAgente() {
        for (int i = 0; i < Agente.listaAgentes.size(); i++) {
            Agente aux = Agente.listaAgentes.get(i);
            if (aux.listaClientes.isEmpty()) {
                continue;
            } else {
                System.out.println(" El agente: " + aux.getNombre() + " Tienes los siguientes clientes: ");
                System.out.println(" ");
                for (int j = 0; j < aux.listaClientes.size(); j++) {
                    Viajero v = aux.listaClientes.get(j);
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
            if (viajero.verificarCedula(cedulaViajero) == true) {
                viajero = (Viajero) viajero.devolverPorCedula(cedulaViajero);
                agenteAsignado = viajero.getAgente();
                System.out.println("Usuario: " + viajero.getNombre() + " encontrado y listo para viajar.");
                v = false;
                break;
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
        Transporte transporteActual = null;
        switch (eleccionTransporte) {
            case 1:
                transporteActual = new Transporte("Latam", "aereo");
            case 2:
                transporteActual = new Transporte("Coomotor", "terrestre");
            case 3:
                transporteActual = new Transporte("Maribell", "maritimo");
        }

        Destino destino1 = new Destino("San Andres", "Colombia", 973);
        Tiquete tiquete1 = new Tiquete(viajero, agenteAsignado, transporteActual, destino1);

        System.out.println(tiquete1.getPrecio());
        System.out.println(tiquete1.getViajero().getNombre());
        System.out.println(tiquete1.getTiempoViaje());
    }
}
