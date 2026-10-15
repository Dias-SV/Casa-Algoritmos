import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Mesa mesaAsociada;
    private ArrayList<Platillo> listaDePlatillos;
    private LocalDate horaLlegada;
    private boolean estatus;

    public Pedido(int idPedido, Mesa mesaAsociada, ArrayList<Platillo> listaDePlatillos, LocalDate horaLlegada) {
        this.idPedido = idPedido;
        this.mesaAsociada = mesaAsociada;
        this.listaDePlatillos = listaDePlatillos;
        this.horaLlegada = horaLlegada;
        this.estatus = false;
    }

    public void agregarPlatillo(Platillo platillo) {
        listaDePlatillos.add(platillo);
    }

}