import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Platillo> platillos = new ArrayList<>();
    private static ArrayList<Mesa> mesas = new ArrayList<>();

    public Restaurante() { //Para testing
        cargarPlatillos();
    }

    public void agregarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPlatillo(Platillo platillo) {
        platillos.add(platillo);
    }
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }
    public ArrayList<Mesa> getMesas() {
        return mesas; 
    }

    public static void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        String[] ingredientes = {"Tortilla", "Carne"};
        platillos.add(new Platillo("Tacos", 1 , 1234.72f, new ArrayList<>(Arrays.asList(ingredientes))));
    }
}