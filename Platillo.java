import java.util.ArrayList;

public class Platillo {
    private String nombre;
    private int categoria;
    private float precio;
    private ArrayList<String> ingredientes;

    public Platillo(String nombre, int categoria, float precio, ArrayList<String> ingredientes) {
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

    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
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