public class Cocinero extends Empleado {
    
    public Cocinero(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Cocinero";
    }

    public void revisarLista(){
        
    }
    
    public void pedidoCompletado(){
        
    }
}