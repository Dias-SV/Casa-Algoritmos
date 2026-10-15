import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Platillo> platillos = new ArrayList<>();

    static {
        cargarPlatillos();
    }

    public static agregarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    public static agregarPlatillo(Platillo platillo) {
        platillos.add(platillo);
    }

    private static void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        String[] ingredientes = {"Tortilla", "Carne"};
        platillos.add(new Platillo("Tacos", "Mexicana", 1234.72, new ArrayList<>(Arrays.asList(ingredientes))));
    }
}