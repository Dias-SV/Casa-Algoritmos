import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Platillo> platillos = new ArrayList<>();
    private static ArrayList<Mesa> mesas = new ArrayList<>();

    static {
        cargarPlatillos();
    }

    public void agregarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    public void agregarPlatillo(Platillo platillo) {
        platillos.add(platillo);
    }
    
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    
    }

    private static void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        String[] ingredientes = {"Tortilla", "Carne"};
        platillos.add(new Platillo("Tacos", "Mexicana", 1234.72f, new ArrayList<>(Arrays.asList(ingredientes))));
    }
}