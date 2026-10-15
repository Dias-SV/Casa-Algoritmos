import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Mesa mesaAsociada;
    private ArrayList<Platillo> listaDePlatillos;
    private LocalTime horaLlegada;
    private int categoria;
    private boolean estatus;

    public Pedido(int idPedido, Mesa mesaAsociada, ArrayList<Platillo> listaDePlatillos, LocalTime horaLlegada) {
        this.idPedido = idPedido;
        this.mesaAsociada = mesaAsociada;
        this.listaDePlatillos = listaDePlatillos;
        this.horaLlegada = horaLlegada;
        this.estatus = true;
    }

    public void agregarPlatillo(Platillo platillo) {
        listaDePlatillos.add(platillo);
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesaAsociada;
    }
    public void setMesa(Mesa mesaAsociada) {
        this.mesaAsociada = mesaAsociada;
    }

    public ArrayList<Platillo> getListaPlatillos() {
        return listaDePlatillos;
    }
    public void setNumMesa(ArrayList<Platillo> platillos) {
        this.listaDePlatillos = platillos;
    }

    public LocalTime getHoraLLegada() {
        return horaLlegada;
    }
    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public boolean getEstatus() {
        return estatus;
    }
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public int getCategoria(){
        return categoria;
    }

    public void setCategoria(int categoria)
    {
        this.categoria = categoria;
    }

}