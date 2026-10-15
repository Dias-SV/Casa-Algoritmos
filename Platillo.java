import java.util.ArrayList;

public class Platillo {
    private String nombre;
    private String categoria;
    private float precio;
    private ArrayList<String> ingredientes;

    public Platillo(String nombre, String categoria, float precio, ArrayList<String> ingredientes) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

}