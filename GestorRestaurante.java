import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GestorRestaurante {
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Platillo> menuGeneral; //No se toca a menos que gerente agregue un nuevo platillo
    private ArrayList<Platillo> listaPlatillos; //Lista para ordenar las categorias (no sale de la clase)
    private ArrayList<Pedido> pedidoscomp;
    private ArrayList<Pedido> venta;


    public GestorRestaurante(ArrayList<Pedido> listaPedidos, ArrayList<Platillo> menuGeneral)
    {
        this.listaPedidos = listaPedidos;
        this.menuGeneral = menuGeneral;
        this.listaPlatillos = new ArrayList<>();
        this.pedidoscomp = new ArrayList<>();
        this.venta = new ArrayList<>();
    }

    public void inicializarListaPlatillos(Pedido nuevoPedido){
        for(Platillo platillo : nuevoPedido.getListaPlatillos())
        {
            this.listaPlatillos.add(platillo);
        }
    }

    public void ordenarCocina() //Trabajar con la lista de platillos
    {
        int ordenado;
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
    
    public void buscarEstadoPedido(int id)
    {
        int encontrado = 0;
        int capacidad = 101;
        int direccionBuscar = id % capacidad;
        ArrayList<ArrayList<Pedido>> tablaHash = funcionHash();
        ArrayList<Pedido> obtener = tablaHash.get(direccionBuscar);
        
        for(int i = 0; i<obtener.size(); i++)
        {
            if(obtener.get(i).getIdPedido() == id){
                String estado = obtener.get(i).getEstatus() ? "Completado":"Pendiente";
                System.out.println("El pedido "+obtener.get(i).getIdPedido()+" se encuentra "+estado);
                encontrado = 1;
                break;
            }
        }
        if(encontrado == 0){
            System.out.println("El pedido "+id+" no se encontró");
        }
    }
// metodo para generar un id de un pedido
    public int idrandom(){

        int idaleat = ThreadLocalRandom.current().nextInt(10000,100000);
        return  idaleat;
    }
// Implemente un metodo parecido al anterior que busca el estado de un pedido
    public void buscarpedidoymarcar()
    {
        if(this.listaPedidos.isEmpty())
        {
            System.out.println("No hay pedidos pendientes por completar");
            return;
        }
        this.listaPedidos.get(0).setEstatus(true);
        Pedido pedidolisto = this.listaPedidos.remove(0);
        this.pedidoscomp.add(pedidolisto);
        System.out.println("El pedido "+pedidolisto.getIdPedido()+" ha sido completado y está listo para entregar");
    }


    public void analizarVentas()
    {
        this.venta.clear();
        this.venta.addAll(this.listaPedidos);
        this.venta.addAll(this.pedidoscomp);

        if(this.venta.isEmpty())
        {
            System.out.println("\nNo hay ventas registradas en el sistema");
            return;
        }
        quickSort(0, this.venta.size()-1);
        
        for(Pedido pedido : this.venta)
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
                System.out.println((i+1)+"."+this.menuGeneral.get(i).getNombre());
            }
        }
    }
    
    public int consumoMesa(float consumo)
    {
        this.venta.clear();
        this.venta.addAll(this.listaPedidos);
        this.venta.addAll(this.pedidoscomp);

        if(this.venta.isEmpty()){
            System.out.println("No es posible realizar el análisis de consumo por mesa");
            return -1;
        }

        quickSort(0, this.venta.size()-1);
        int inicio = 0;
        int fin = this.venta.size()-1;
        
        while(inicio <= fin)
        {
            int medio = (inicio+fin)/2;
            int consumoLista = this.venta.get(medio).getMesa().getCuentaTotal();
            
            if( consumoLista == consumo)
            {
                return this.venta.get(medio).getMesa().getNumMesa();
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

    private ArrayList<ArrayList<Pedido>> funcionHash(){
        int capacidad = 101;
        ArrayList<ArrayList<Pedido>> listaColisiones = new ArrayList<>(capacidad);

        for(int j=0; j<capacidad; j++)
        {
            listaColisiones.add(new ArrayList<> ());
        }

        for(int i= 0; i<this.listaPedidos.size(); i++)
        {
            int clave = this.listaPedidos.get(i).getIdPedido();
            int direccion = clave % capacidad;
            listaColisiones.get(direccion).add(this.listaPedidos.get(i));
        }
        return listaColisiones;
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

    private void swapPedido(int cambio1, int cambio2)
    {
        Pedido aux = this.venta.get(cambio1);
        this.venta.set(cambio1, this.venta.get(cambio2));
        this.venta.set(cambio2, aux);
    }
    
    private void quickSort( int inicio, int fin)
    {
        if(inicio < fin)
        {
            int indicePivote = partition( inicio, fin);
            quickSort(inicio, indicePivote-1);
            quickSort(indicePivote+1, fin);
            
        }
    }
    
    private int partition(int inicio, int fin)
    {
        float pivote = this.venta.get(fin).getMesa().getCuentaTotal();
        int i = inicio -1;
        int j = inicio-1;
        for( j= inicio; j<= fin -1; j++)
        {
            if(this.venta.get(j).getMesa().getCuentaTotal() >= pivote)
            {
                i = i + 1;
                swapPedido(i, j);
            }
        }
        swapPedido(i, j);
        return i+1;
    }

    }



    