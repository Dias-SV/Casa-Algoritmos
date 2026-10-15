public class Gerente extends Empleado {
    
    public Gerente(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Gerente";
    }
}