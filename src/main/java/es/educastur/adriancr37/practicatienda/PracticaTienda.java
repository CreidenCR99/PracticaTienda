package es.educastur.adriancr37.practicatienda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * PracticaTienda
 *
 * @author Adrián Cuervo - CreidenCR99
 * @version 20/01/26
 */
public class PracticaTienda {

    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos;
    private HashMap<String, Cliente> clientes;
    LocalDate hoy = LocalDate.now();

    public PracticaTienda() {
        pedidos = new ArrayList();
        articulos = new HashMap();
        clientes = new HashMap();
    }

    public static void main(String[] args) {
        PracticaTienda p = new PracticaTienda();
        p.cargaDatos();
        p.menuOpciones();
    }

    public void cargaDatos() {
        clientes.put("80580845T", new Cliente("80580845T", "ANA", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 14, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 9, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 16, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-11", new Articulo("3-11", "HP LASERJET H200 ", 3, 50));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido("1-11", 3), new LineaPedido("4-22", 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido("4-11", 3), new LineaPedido("4-22", 2), new LineaPedido("4-33", 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido("4-22", 1), new LineaPedido("2-22", 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido("4-33", 3), new LineaPedido("2-11", 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido("2-11", 5), new LineaPedido("2-33", 3), new LineaPedido("4-33", 2)))));
    }

    //#region menuOpciones
    public void menuOpciones() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE OPCIONES");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - MENU LISTADOS");
            System.out.println("\t| 2 - MENU ARTICULOS");
            System.out.println("\t| 3 - MENU CLIENTES");
            System.out.println("\t| 4 - MENU PEDIDOS");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    menuListados();
                }
                case 2 -> {
                    menuArticulos();
                }
                case 3 -> {
                    menuClientes();
                }
                case 4 -> {
                    menuPedidos();
                }
            }
        } while (opcion != 0);
    }

    //#endregion
    //#region Listados
    public void menuListados() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE LISTADOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - LISTADO TOTAL");
            System.out.println("\t| 2 - LISTADO ARTICULOS");
            System.out.println("\t| 3 - LISTADO CLIENTES");
            System.out.println("\t| 4 - LISTADO PEDIDOS");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE LISTADOS
                case 1 -> {
                    listado();
                }
                case 2 -> {
                    listadoArticulos();
                }
                case 3 -> {
                    listadoClientes();
                }
                case 4 -> {
                    listadoPedidos();
                }
            }
        } while (opcion != 0);
    }

    public void listado() {
        listadoArticulos();
        listadoClientes();
        listadoPedidos();
    }

    public void listadoArticulos() {
        System.out.println();
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }
    }

    public void listadoClientes() {
        System.out.println();
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }

    public void listadoPedidos() {
        System.out.println();
        for (Pedido p : pedidos) {
            System.out.println(p + "Total:\t" + totalPedido(p));
        }

        System.out.println("\nListados de menor a mayor");
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p -> System.out.println(p + "Total:\t" + totalPedido(p))
                );

        System.out.println("\nListados de mayor a menor");
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido((Pedido)p)).reversed())
                .forEach(p -> System.out.println(p + "Total:\t" + totalPedido(p))
                );

        System.out.println("\n");
    }

    //#endregion
    //#region Articulos
    public void menuArticulos() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE ARTICULOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - LISTADO ARTICULO");
            System.out.println("\t| 2 - ALTA ARTICULO");
            System.out.println("\t| 3 - BAJA ARTICULO");
            System.out.println("\t| 4 - REPOSICION ARTICULO");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE ARTICULOS
                case 1 -> {
                    listadoArticulos();
                }
                case 2 -> {
                    altaArticulo();
                }
                case 3 -> {
                    bajaArticulo();
                }
                case 4 -> {
                    reposicionArticulos();
                }
            }
        } while (opcion != 0);
    }

    private void altaArticulo() {

        String idArticulo, descripcion, existencias, pvp; // TODAS LAS ENTRADAS COMO STRING FACILITA VALIDACION Y EVITA PROBLEMAS CON SCANNER

        System.out.println("ALTA DE NUEVO ARTICULO");
        //idArticulo VALIDADO CON EXPRESION REGULAR SENCILLA
        do {
            System.out.println("IdArticulo (IDENTIFICADOR):");
            idArticulo = sc.nextLine();
        } while (!idArticulo.matches("[1-6][-][0-9][0-9]") || articulos.containsKey(idArticulo));
        //OJO CONTROLAR tambien QUE NO EXISTA ESE ID PREVIAMENTE

        //ENTRADA DESCRIPCION SIN NINGUN TIPO DE VALIDACION
        System.out.println("DESCRIPCION:");
        descripcion = sc.nextLine();

        // EXISTENCIAS CON VALIDACION DE TIPO int
        do {
            System.out.println("EXISTENCIAS:");
            existencias = sc.nextLine(); //Se lee la entrada de EXISTENCIAS como un String
        } while (!MetodosAux.esInt(existencias)); //Se sigue pidiendo la entrada si no es int

        // PVP CON VALIDACION DE TIPO double
        do {
            System.out.println("PVP:");
            pvp = sc.nextLine(); //Se lee la entrada del PVP como un String
        } while (!MetodosAux.esDouble(pvp)); //Se sigue pidiendo la entrada si no es double

        //AÑADO OBJETO ARTICULO A LA COLECCION PARSEANDO A int y double los datos de existencias y PVP
        Articulo a = new Articulo(idArticulo, descripcion,
                Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
        System.out.println("- Articulo añadido -");
        /* por supuesto podría haberlo hecho con una única istrucción
        articulos.put(idArticulo,new Articulo(idArticulo,descripcion,Integer.parseInt(existencias),Double.parseDouble(pvp)));
         */
    }

    public void bajaArticulo() {

    }

    public void reposicionArticulos() {

    }

    //#endregion
    //#region Clientes
    public void menuClientes() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE CLIENTES");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - LISTADO CLIENTE");
            System.out.println("\t| 2 - ALTA CLIENTE");
            System.out.println("\t| 3 - BAJA CLIENTE");
            System.out.println("\t| 4 - MODIFICAR CLIENTE");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE CLIENTES
                case 1 -> {
                    listadoClientes();
                }
                case 2 -> {
                    altaCliente();
                }
                case 3 -> {
                    bajaCliente();
                }
                case 4 -> {
                    modificarCliente();
                }
            }
        } while (opcion != 0);
    }

    public void altaCliente() {
        sc.next();
        String idCliente;
        System.out.print("Teclea tu DNI: ");
        do {
            idCliente = sc.nextLine();
        } while (!MetodosAux.validarDNI(idCliente));
        System.out.println("Teclea tu nombre");
        String nombre = sc.nextLine().toUpperCase().trim();
        System.out.println("Teclea tu telefono");
        String telefono = sc.nextLine().trim();
        System.out.println("Teclea tu email");
        String email = sc.nextLine().trim();
        clientes.put(idCliente, new Cliente(idCliente, nombre, telefono, email));

    }

    public void bajaCliente() {

    }

    public void modificarCliente() {

    }

    //#endregion
    //#region Pedidos
    public void menuPedidos() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE PEDIDOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - LISTADO PEDIDOS");
            System.out.println("\t| 2 - NUEVO PEDIDO");
            System.out.println("\t| 3 - TOTAL PEDIDO");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE PEDIDOS
                case 1 -> {
                    listadoPedidos();
                }
                case 2 -> {
                    nuevoPedido();
                }
                case 3 -> {
                    System.out.print("Teclea una idPedido: ");
                    int idPedido = sc.nextInt();
                    totalPedido(pedidos.get(idPedido));
                    //80580845T-001/2025
                }
            }
        } while (opcion != 0);
    }

    private void stock(String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias() == 0) {
            throw new StockCero("0 unidades disponibles de: "
                    + articulos.get(idArticulo).getDescription());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades) {
            throw new StockInsuficiente("\nSolo hay " + articulos.get(idArticulo).getExistencias()
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescription());
        }
    }

    public void nuevoPedido() {
        sc.nextLine(); // Limpiar buffer tras nextInt()
        String idCliente;
        do {
            System.out.print("DNI CLIENTE: ");
            idCliente = sc.nextLine().toUpperCase().trim();
            if (!clientes.containsKey(idCliente)) {
                System.out.println("No eres cliente");
            }
        } while (!MetodosAux.validarDNI(idCliente));

        ArrayList<LineaPedido> cestaCompra = new ArrayList<>();
        String idArticulo;
        int unidades;
        System.out.println("\n\t(FIN para terminar la compra)");
        while (true) {
            System.out.print("Teclea el ID del articulo deseado: ");
            idArticulo = sc.nextLine().trim();
            if (idArticulo.equalsIgnoreCase("fin")) {
                break;
            }
            if (!articulos.containsKey(idArticulo)) {
                System.out.println("Articulo no encontrado.");
                continue;
            }
            System.out.print("Teclea las unidades deseadas: ");
            String unidadesStr = sc.nextLine().trim();
            if (!MetodosAux.esInt(unidadesStr)) {
                System.out.println("Introduce un número válido.");
                continue;
            }
            unidades = Integer.parseInt(unidadesStr);
            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(idArticulo, unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.print("Las quieres (Si/No) ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    int stockDisponible = articulos.get(idArticulo).getExistencias();
                    if (stockDisponible > 0) {
                        cestaCompra.add(new LineaPedido(idArticulo, stockDisponible));
                        articulos.get(idArticulo).setExistencias(0);
                    }
                }
            }
        }
        if (!cestaCompra.isEmpty()) {
            System.out.println("Este es tu pedido: ");
            for (LineaPedido l : cestaCompra) {
                System.out.println(l.getIdArticulo() + "\t- "
                        + articulos.get(l.getIdArticulo()).getDescription() + "\t- "
                        + l.getUnidades() + "\t- "
                        + articulos.get(l.getIdArticulo()).getPvp() + "\t- "
                        + articulos.get(l.getIdArticulo()).getPvp() * l.getUnidades());
            }
            System.out.print("Procedemos con la compra (Si/No): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                String idPedido = generaIdPedido(idCliente);
                pedidos.add(new Pedido(idPedido, clientes.get(idCliente), hoy, cestaCompra));
                for (LineaPedido l : cestaCompra) {
                    articulos.get(l.getIdArticulo()).setExistencias(
                            articulos.get(l.getIdArticulo()).getExistencias() - l.getUnidades());
                }
                System.out.println("Pedido realizado correctamente.");
            }
        }
    }

    private double totalPedido(Pedido p) {
        double totalPedido = 0;
        for (LineaPedido l : p.getCestaCompra()) {
            totalPedido += l.getUnidades() * articulos.get(l.getIdArticulo()).getPvp();
        }
        return totalPedido;
    }

    public String generaIdPedido(String idCliente) {
        int contador = 0;
        String nuevoId;
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%o3d", contador) + "/" + hoy.getYear();
        return nuevoId;
    }
    //#endregion
}