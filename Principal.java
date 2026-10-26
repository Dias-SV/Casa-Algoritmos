import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static Restaurante restaurante = new Restaurante();
    static GestorRestaurante gestor = new GestorRestaurante(restaurante.getPedidos(), restaurante.getPlatillos());

    public static void main(String[] args) {
        int opcion = 0;
        boolean condition = true;
        
        do {
            Empleado empleado;
            System.out.println("\nElige tu puesto:");
            System.out.println("1. Mesero");
            System.out.println("2. Cocinero");
            System.out.println("3. Gerente");
            System.out.println("4. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine(); //Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = entrada.nextLine();
                    empleado = new Mesero(nombre, apellido);
                    System.out.println("\nHola, " + empleado.getNombreCompleto() + ". Puesto: " + empleado.getPuesto());
                    menuMesero();
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    nombre = entrada.nextLine();
                    System.out.print("Apellido: ");
                    apellido = entrada.nextLine();
                    empleado = new Cocinero(nombre, apellido);
                    System.out.println("\nHola, " + empleado.getNombreCompleto() + ". Puesto: " + empleado.getPuesto());
                    menuCocinero();
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    nombre = entrada.nextLine();
                    System.out.print("Apellido: ");
                    apellido = entrada.nextLine();
                    empleado = new Gerente(nombre, apellido);
                    System.out.println("\nPuesto: " + empleado.getPuesto() + "\nHola, " + empleado.getNombreCompleto());
                    menuGerente();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }
        } while (opcion != 4);
    }

    public static void menuMesero() {
        int opcion;
        do {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Verificar alergenos");
            System.out.println("3. Buscar pedido");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1: //Todo esto probablemente lo cambie
                    System.out.print("\nNumero de mesa: ");
                    int numeroMesa = entrada.nextInt();
                    entrada.nextLine();

                    Mesa mesa = null;
                    for (Mesa mesas : restaurante.getMesas()) { //Cambiar a busqueda hash tal vez
                        if (mesas.getNumMesa() == numeroMesa) {
                            mesa = mesas;
                            break;
                        }
                    }

                    if(mesa == null)
                    {
                        System.out.println("La mesa "+numeroMesa+" no existe");
                        break;
                    }

                    if(mesa.isOcupada()){
                        System.out.println("La mesa "+numeroMesa+" ya se encuentra ocupada.");
                        break;
                    }

                    System.out.print("Platillos (presione '.' para acabar): ");
                    ArrayList<Platillo> platillos = new ArrayList<>();
                    String platillo = entrada.nextLine().trim();
                    int cuenta = 0;
                    while (!platillo.equals(".")) { //Puesta para tener una idea, no final
                        if (!platillo.isEmpty()) {
                            for (Platillo plato : restaurante.getPlatillos()) {
                                if (plato.getNombre().equalsIgnoreCase(platillo.trim())) {
                                    platillos.add(plato); 
                                    cuenta += plato.getPrecio();
                                    break;
                                }
                            }
                        }
                        platillo = entrada.nextLine().trim();
                    }

                    if(platillos.isEmpty()){
                        System.out.println("No es posible registrar un pedido sin un platillo");
                        break;
                    }
                    int idAsignado = gestor.idrandom();
                    mesa.setOcupada(true);
                    mesa.setCuentaTotal(cuenta);

                    restaurante.agregarPedido(new Pedido(idAsignado, mesa, platillos, LocalTime.now())); //ahora ya cada pedido genera un id random
                    System.out.println("ID del pedido: "+idAsignado);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del alergeno: ");
                    String alergeno = entrada.nextLine();
                    gestor.revisarAlergenos(alergeno);
                    break;

                case 3:
                    System.out.print("Ingrese el numero de pedido: "); //Tal vez cambiarlo a usar la hora
                    int numeroPedido = entrada.nextInt();
                    gestor.buscarEstadoPedido(numeroPedido);
                    break;

                case 4:
                    System.out.println("Saliendo del menu..");
                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (opcion != 4);
    }

    public static void menuCocinero() {
        int opcion;
        do {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ver lista de pedidos");
            System.out.println("2. Marcar pedido como completado");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("\nPedidos pendientes:");
                    if(restaurante.getPedidos().isEmpty())
                    {
                        System.out.println("No hay pedidos pendientes en este momento");
                    }
                    else
                    {
                        for (Pedido pedido : restaurante.getPedidos()) { 
                            if (!pedido.getEstatus()) {
                                pedido.mostrarPedido();   
                            }
                        }   
                    }
                    
                    break;

                case 2:
                    System.out.print("\nMarcar como completado el pedido? (s/n)\n");
                    if(restaurante.getPedidos().isEmpty())
                    {
                        gestor.buscarpedidoymarcar();
                        break;    
                    }
                    
                    Pedido pedido = restaurante.getPedidos().getFirst();
                    pedido.mostrarPedido();
                    String confirmacion = entrada.nextLine().trim();
                    
                    
                        if (confirmacion.equalsIgnoreCase("s")) {
                            gestor.buscarpedidoymarcar();
                        } else {
                            System.out.println("No se ha marcado ningún pedido como completado ");
                        }   
                    
                    
                    break;

                case 3:
                    System.out.println("Saliendo del menu..");
                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (opcion != 3);
    }

    public static void menuGerente() {
        int opcion;
        do {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Analizar ventas");
            System.out.println("2. Agregar platillo");
            System.out.println("3. Agregar mesa");
            System.out.println("4. Buscar mesa por consumo");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    gestor.analizarVentas();
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del platillo: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Ingrese el numero de la categoria: ");
                    int categoria = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Ingrese el precio: ");
                    int precio = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("Ingrese los ingredientes (presione '.' para terminar):");
                    ArrayList<String> ingredientes = new ArrayList<>();
                    String ingrediente = entrada.nextLine().trim();
                    while (!ingrediente.equals(".")) {
                        if (!ingrediente.isEmpty()) {
                            ingredientes.add(ingrediente);    
                        }
                        ingrediente = entrada.nextLine().trim();
                    }
                    
                    restaurante.agregarPlatillo(new Platillo(nombre, categoria, precio, ingredientes));
                    System.out.println("Platillo agregado");
                    break;

                case 3:
                    System.out.print("Ingrese el numero de mesa: ");
                    int numero = entrada.nextInt();
                    entrada.nextLine();

                    boolean existe = false;
                    for (Mesa mesa : restaurante.getMesas()) { //Se puede mejorar haciendo una tabla hash
                        if (mesa.getNumMesa() == numero) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Ya se tiene una mesa con este numero");
                    } else {
                        restaurante.agregarMesa(new Mesa(numero));
                        System.out.println("Mesa agregada");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el consumo de la mesa: ");
                    int consumo = entrada.nextInt();
                    int numeroMesa = gestor.consumoMesa(consumo);

                    if (numeroMesa == -1) {
                        System.out.println("No se encontro una mesa con este consumo");
                    } else {
                        System.out.println("La mesa con el consumo de " + consumo + " es la numero " + numeroMesa);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del menu..");
                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            
        } while (opcion != 5);
    }
}
