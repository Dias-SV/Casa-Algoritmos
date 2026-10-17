import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Platillo> platillos = new ArrayList<>();

    public Restaurante() {
        cargarPlatillos();
    }

    public agregarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    public agregarPlatillo(Platillo platillo) {
        platillos.add(platillo);
    }

    private void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        String[] ingredientes = {"Tortilla", "Carne"};
        platillos.add(new Platillo("Tacos", "Mexicana", 1234.72f, new ArrayList<>(Arrays.asList(ingredientes))));
    }
}