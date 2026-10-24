public class Gerente extends Empleado {
    
    public Gerente(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Gerente";
    }
    
    /*public void analizarVentas(GestorRestaurante gestor){
        gestor.analizarVentas();
    }
    
    public void agregarPlatilloNuevo(Restaurante menu, Platillo platilloNuevo){
        menu.agregarPlatillo(platilloNuevo);
    }
    
    public void agregarMesa(Restaurante control, int numero){
        Mesa mesa = new Mesa(numero);
        control.agregarMesa(mesa);
        
    }
    
    public void buscarConsumo(GestorRestaurante gestor, float consumo){
        int numeroMesa = gestor.consumoMesa(consumo);
    }*/
}