import java.time.LocalTime;
import java.util.ArrayList;

public class GestorRestaurante {
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Platillo> menuGeneral; //No se toca a menos que gerente agregue un nuevo platillo
    private ArrayList<Platillo> listaPlatillos; //Lista para ordenar las categorias (no sale de la clase)


    public GestorRestaurante(ArrayList<Pedido> listaPedidos, ArrayList<Platillo> menuGeneral)
    {
        this.listaPedidos = listaPedidos;
        this.menuGeneral = menuGeneral;
        this.listaPlatillos = new ArrayList<>();
    }

    public void inicializarListaPlatillos(Pedido nuevoPedido){
        for(Platillo platillo : nuevoPedido.getListaPlatillos())
        {
            this.listaPlatillos.add(platillo);
        }
    }

    public void ordenarCocina() //Trabajar con la lista de platillos
    {
        int ordenado = 0;
        int tamano = this.listaPlatillos.size();
        for(int i=tamano-1; i>=0; i--)
        {
            ordenado = 1;
            for(int j=0; j<i; j++)
            {
                if(this.listaPlatillos.get(j).getCategoria()>this.listaPlatillos.get(j+1).getCategoria()){
                    swap(j, j+1);
                    ordenado = 0;
                }  
                else if(this.listaPlatillos.get(j).getCategoria()==this.listaPlatillos.get(j+1).getCategoria())
                {
                    LocalTime hora1 = horaPedido(this.listaPlatillos.get(j));
                    LocalTime hora2 = horaPedido(this.listaPlatillos.get(j+1));

                    if(hora1.isAfter(hora2))
                    {
                        swap(j, j+1);
                        ordenado = 0;
                    }
                } 
            }
            if(ordenado == 1)
            {
                break;
            }
        }
    }
    
    public void buscarEstadoPedido(Pedido pedido)
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

    private LocalTime horaPedido(Platillo platillo)
    {
        for(Pedido pedido : this.listaPedidos)
        {
            for(Platillo plat : pedido.getListaPlatillos())
            {
                if(plat == platillo){
                    return pedido.getHoraLLegada();
                }
            }
        }
        return null;
    }

    private void swap(int cambio1, int cambio2)
    {
        Platillo aux = this.listaPlatillos.get(cambio1);
        this.listaPlatillos.set(cambio1, this.listaPlatillos.get(cambio2));
        this.listaPlatillos.set(cambio2, aux);
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

    