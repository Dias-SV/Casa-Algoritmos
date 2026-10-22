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
        int tamano = this.listaPedidos.size()-1;
        for(int i=tamano-1; i>=0; i--)
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
    
    public void buscarEstadoPedido(Pedido pedido) //Deberia usar uno de los parametros, no el objeto como tal
    {
        
    }

    public void analizarVentas()
    {
        quickSort(0, this.listaPedidos.size()-1);
        
        for(Pedido pedido : this.listaPedidos)
        {
            System.out.println("La mesa "+pedido.getMesa().getNumMesa()+" tiene un consumo de $"+pedido.getMesa().getCuentaTotal());
        }
    }

    public void revisarAlergenos(String alergeno)
    {
        System.out.println("Platillos que contienen el alérgeno: "+alergeno);
        for(int i=0; i<this.menuGeneral.size(); i++)
        {
            if(this.menuGeneral.get(i).getIngredientes().contains(alergeno))
            {
                System.out.println("El platillo "+this.menuGeneral.get(i).getNombre()+" contiene "+alergeno);
            }
        }
    }
    
    public int consumoMesa(float consumo)
    {
        quickSort(0, this.listaPedidos.size()-1);
        int inicio = 0;
        int fin = this.listaPedidos.size()-1;
        
        while(inicio <= fin)
        {
            int medio = (inicio+fin)/2;
            float consumoLista = this.listaPedidos.get(medio).getMesa().getCuentaTotal();
            
            if( consumoLista == consumo)
            {
                return this.listaPedidos.get(medio).getMesa().getNumMesa();
            }
            if(consumo < consumoLista)
            {
                inicio = medio + 1;
            }
            if(consumo > consumoLista)
            {
                fin = medio - 1;
            }
        }
        return -1;
    }

    private void swap(int cambio1, int cambio2)
    {
        Pedido aux = this.listaPedidos.get(cambio1);
        this.listaPedidos.set(cambio1, this.listaPedidos.get(cambio2));
        this.listaPedidos.set(cambio2, aux);
    }
    
    private void quickSort(int inicio, int fin)
    {
        if(inicio < fin)
        {
            int indicePivote = partition(inicio, fin);
            quickSort(inicio, indicePivote-1);
            quickSort(indicePivote+1, fin);
            
        }
    }
    
    private int partition(int inicio, int fin)
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

    