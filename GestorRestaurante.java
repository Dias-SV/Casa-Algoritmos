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
            if(this.listaPedidos.get(i).getCategoria()>this.listaPedidos.get(i+1).getCategoria()){
                swap(i, i+1);
            }
            else if(this.listaPedidos.get(i).getCategoria()==this.listaPedidos.get(i+1).getCategoria())
                {
                    if(this.listaPedidos.get(i).getHoraLLegada().isAfter(this.listaPedidos.get(i+1).getHoraLLegada()))
                    {
                        swap(i, i+1);
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
        quickSort(0, this.listaPedidos.size()-1);
    }

    public void revisarAlergenos(String alergeno)
    {
        

        
    }

    public void swap(int cambio1, int cambio2)
    {
        Pedido aux = this.listaPedidos.get(cambio1);
        this.listaPedidos.set(cambio1, this.listaPedidos.get(cambio2));
        this.listaPedidos.set(cambio2, aux);
    }
    
    public void quickSort(int inicio, int fin)
    {
        if(inicio < fin)
        {
            int indicePivote = partition(inicio, fin);
            quickSort(inicio, indicePivote-1);
            quickSort(indicePivote+1, fin);
            
        }
    }
    
    public int partition(int inicio, int fin)
    {
        float pivote = this.listaPedidos.get(fin).getMesa().getCuentaTotal();
        int i = inicio -1;
        int j = inicio-1;
        for( j= inicio; j<= fin -1; j++)
        {
            if(this.listaPedidos.get(j).getMesa().getCuentaTotal() >= pivote)
            {
                i = i + 1;
                swap(i, j);
            }
        }
        swap(i, j);
        return i+1;
    }

    }

    