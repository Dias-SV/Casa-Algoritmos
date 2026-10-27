package empleados;
public class Mesero extends Empleado {
    
    public Mesero(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override 
    public String getPuesto() {
        return "Mesero";
    }
    
}
