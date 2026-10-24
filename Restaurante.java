import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Platillo> platillos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public Restaurante (){
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

    private void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        String[] ingredientes = {"Tortilla", "Carne"};
        platillos.add(new Platillo("Tacos", 1 , 1234.72f, new ArrayList<>(Arrays.asList(ingredientes))));
    }

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public ArrayList<Platillo> getPlatillos(){
        return this.platillos;
    }

    public void getPlatillos(ArrayList<Platillo> platillos)
    {
        this.platillos = platillos;
    }

    public ArrayList<Mesa> setMesas(){
        return this.mesas;
    }

    public void getMesas(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }
}