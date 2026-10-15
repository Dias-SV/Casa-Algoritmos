import java.util.Scanner;

public class Principal {
    static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Empleado empleado = elegirEmpleado();
        System.out.println("\nHola, " + empleado.getNombreCompleto() + ". Puesto: " + empleado.getPuesto());
    }


    private static Empleado elegirEmpleado() {
        System.out.println("\nElige tu puesto:");
        System.out.println("1. Mesero");
        System.out.println("2. Cocinero");
        System.out.println("3. Gerente");

        int opcion;
        do {
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
        } while (opcion < 1 || opcion > 3);
        entrada.nextLine(); //Limpiar buffer
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();

        switch (opcion) {
            case 1:
                return new Mesero(nombre, apellido);

            case 2:
                return new Cocinero(nombre, apellido);

            case 3:
                return new Gerente(nombre, apellido);

            default:
                System.out.println("Error")
        }
    }

}
