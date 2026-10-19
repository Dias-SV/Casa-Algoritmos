public class Gerente extends Empleado {
    
    public Gerente(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Gerente";
    }
    
    public void analizarVentas(GestorRestaurante gestor){
        gestor.analizarVentas();
    }
    
    public void agregarPlatilloNuevo(Restaurante menu){
        menu.agregarPlatillo();
    }
    
    public void agregarMesa(int numero){
        Mesa mesa = new Mesa(numero);
    }
    
    public void buscarConsumo(GestorRestaurante gestor, float consumo){
        int numeroMesa = gestor.consumoMesa(consumo);
    }
}