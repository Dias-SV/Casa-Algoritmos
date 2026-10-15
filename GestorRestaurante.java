import java.util.ArrayList;

public class GestorRestaurante {
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Platillo> menuGeneral;

    public GestorRestaurante(ArrayList<Pedido> listaPedidos, ArrayList<Platillo> menuGeneral)
    {
        this.listaPedidos = listaPedidos;
        this.menuGeneral = menuGeneral;
    }


    public void ordenarCocina()
    {
        int tamano = this.listaPedidos.size();
        for(int i=tamano; i>=0; i--)
        {
            if(listaPedidos.get(i).getCategoria()>listaPedidos.get(i+1).getCategoria()){
                swap(listaPedidos.get(i), listaPedidos.get(i+1));
            }
            else if(listaPedidos.get(i).getCategoria()==listaPedidos.get(i+1).getCategoria())
                {
                    if(listaPedidos.get(i).getHoraLLegada().isAfter(listaPedidos.get(i+1).getHoraLLegada()))
                    {
                        swap(listaPedidos.get(i), listaPedidos.get(i+1));
                    }
                }
            }
        }
    }

    public void buscarEstadoPedido(Pedido pedido)
    {
        if(pedido.getEstatus())
        {
            System.out.println("En preparación...");
        }

    }

    public void analizarVentas()
    {
        
    }

    public void revisarAlergenos(String alergeno)
    {
        

        
    }

    public void swap(Pedido cambio1, Pedido cambio2)
    {
        Pedido aux = cambio1;
        cambio1 = cambio2;
        cambio2 = aux;
    }

