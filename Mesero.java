public class Mesero extends Empleado {
    
    public Mesero(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Mesero";
    }
    
    /*public void agregarPedido(Restaurante control, Pedido pedido){
        control.agregarPedido(pedido);
    }
    
    public void verificarAlergenos(GestorRestaurante gestor, String alergeno){
        gestor.revisarAlergenos(alergeno);  
    }
    
    public void buscarPedido(GestorRestaurante gestor, Pedido pedido){
        gestor.buscarEstadoPedido(pedido);
    }*/
}
