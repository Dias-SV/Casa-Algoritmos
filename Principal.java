import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        
        do {
            Empleado empleado;
            System.out.println("\nElige tu puesto:");
            System.out.println("1. Mesero");
            System.out.println("2. Cocinero");
            System.out.println("3. Gerente");
            System.out.println("4. Salir");
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
        } while (condition);
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
                case 1:
                    System.out.print("\nNumero de mesa: ");
                    int numero = entrada.nextInt();
                    
                    do {
                        String platillo = nextLine();
                        //Implementar busqueda del platillo para verificar su existencia y agregarlo a la lista 
                        ArrayList<Platillo> platillos = new ArrayList<>();
                        //platillo.add();
                    } while (!platillo.equals("."));
                    
                    //Restaurante.getPedidos().add();
                    break;

                case 2:
                    String platillo = nextLine();
                    //Implementar busqueda del platillo para verificar su existencia y verificar alergenos
                    break;

                case 3:
                    //Implementar busqueda del platill
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
                    break;

                case 2:
                    System.out.print("\nMarcar como completado el pedido (s/n)"); //Poner entre pedido y (s/n) el pedido hasta adelante del arreglo
                    String confirmacion = entrada.nextLine().trim();
                    
                    if (confirmacion.equalsIgnoreCase("s")) {
                        //Cambiar el estatus del pedido adelante del arreglo
                    } else {
                        System.out.println("Indique el pedido completado: ");
                        //Hacer busqueda del pedido por id
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
            System.out.println("3. Buscar mesa por consumo");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    
                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("Saliendo del menu..");
                    break;

                case 4:

                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            
        } while (opcion != 4);
    }
}
