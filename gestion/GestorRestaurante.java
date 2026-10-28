package gestion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import restaurante.Mesa;
import restaurante.Pedido;
import restaurante.Platillo;

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

    public ArrayList<Pedido> getPedidosCompletados()
    {
        return this.pedidoscomp;
    }

    public void inicializarListaPlatillos(Pedido nuevoPedido){
        for(Platillo platillo : nuevoPedido.getListaPlatillos())
        {
            this.listaPlatillos.add(platillo);
        }
    }

     public void ordenarCocina(int categoria) //Trabajar con la lista de platillos
    {
        if(this.listaPlatillos.isEmpty())
        {
            System.out.println("No hay platillos pendientes en la cocina");
            return;
        }

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

        String nombre = "";
        if(categoria == 1)
            nombre = "\nEntradas";
        else if(categoria == 2)
            nombre = "\nPlatos Fuertes";
        else if(categoria == 3)
            nombre = "\nPostres";
        
        System.out.println(nombre.toUpperCase());
        boolean encontrado = false;
        for(Platillo platillo : this.listaPlatillos)
        {
            if(platillo.getCategoria() == categoria)
            {
                LocalTime hora = horaPedido(platillo);
                System.out.println("- "+platillo.getNombre()+" "+hora);
                encontrado = true;
            }
        }

        if(!encontrado)
        {
            System.out.println("No hay platillos pendientes");
        }
    }
    
    public void buscarEstadoPedido(int id) {
        int capacidad = 101;
        int direccionBuscar = id % capacidad;
        ArrayList<ArrayList<Pedido>> tablaHash = funcionHash();
        ArrayList<Pedido> obtener = tablaHash.get(direccionBuscar);

        boolean encontrado = false;
        for(int i = 0; i < obtener.size(); i++)
        {
            if(obtener.get(i).getIdPedido() == id)
            {
                String estado = obtener.get(i).getEstatus() ? "Completado" : "Pendiente";
                System.out.println("El pedido " + obtener.get(i).getIdPedido() + " se encuentra " + estado);
                encontrado = true;
                break;
            }
        }

        if(!encontrado)
        {
            System.out.println("El pedido " + id + " no se encontró");
        }
    }
// metodo para generar un id de un pedido
    public int idRandom(){

        int idAleat = ThreadLocalRandom.current().nextInt(10000,100000);
        return  idAleat;
    }
// Implemente un metodo parecido al anterior que busca el estado de un pedido
    public void buscarPedidoMarcar()
    {
        if(this.listaPedidos.isEmpty())
        {
            System.out.println("\nNo hay pedidos pendientes por completar");
            return;
        }
        
        Pedido pedidolisto = this.listaPedidos.remove(0);
        pedidolisto.setEstatus(true);
        this.pedidoscomp.add(pedidolisto);
        this.listaPlatillos.removeAll(pedidolisto.getListaPlatillos());
        System.out.println("\nEl pedido "+pedidolisto.getIdPedido()+" ha sido completado y está listo para entregar");
        
        Mesa mesa = pedidolisto.getMesa();
        boolean tienePendientes = false;
        for (Pedido pedido : this.listaPedidos) {
            if (pedido.getMesa().getNumMesa() == mesa.getNumMesa()) {
                tienePendientes = true;
                break;
            }
        }

        if (!tienePendientes) {
            mesa.setOcupada(false);
            System.out.println("\nLa cuenta final de la mesa fue de $" + mesa.getCuentaTotal());
        }
            
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
        boolean encontrado = false;
        System.out.println("\nPlatillos que contienen el alérgeno: "+alergeno);
        for(int i=0; i<this.menuGeneral.size(); i++){
            boolean contiene = false;
            for(String alergenos : this.menuGeneral.get(i).getIngredientes())
            {
                if(alergenos.trim().equalsIgnoreCase(alergeno.trim()))
                {
                    contiene = true;
                    break;
                }
            }
            if(contiene)
            {
                encontrado = true;
                System.out.println((i+1)+". "+this.menuGeneral.get(i).getNombre());
            }
        }
        if(!encontrado)
        {
            System.out.println("\nNo se encontró ninguna coincidencia en el menú");
        }
    }
    
    public int consumoMesa(int consumo)
    {
        this.venta.clear();
        this.venta.addAll(this.listaPedidos);
        this.venta.addAll(this.pedidoscomp);

        if(this.venta.isEmpty()){
            System.out.println("\nNo es posible realizar el análisis de consumo por mesa");
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

    private ArrayList<ArrayList<Pedido>> funcionHash() {
        int capacidad = 101;
        ArrayList<ArrayList<Pedido>> listaColisiones = new ArrayList<>(capacidad);

        for(int j = 0; j < capacidad; j++)
        {
            listaColisiones.add(new ArrayList<>());
        }

        ArrayList<Pedido> todos = new ArrayList<>(this.listaPedidos);
        todos.addAll(this.pedidoscomp);

        for(int i = 0; i < todos.size(); i++)
        {
            int clave = todos.get(i).getIdPedido();
            int direccion = clave % capacidad;
            listaColisiones.get(direccion).add(todos.get(i));
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

    public void mostrarCompletados()
    {
        if(this.pedidoscomp.isEmpty())
        {
            System.out.println("\nNo hay pedidos completados hasta el momento");
        }
        else
        {
            System.out.println("\nPedidos completados: ");
            for(Pedido pedido : this.pedidoscomp)
                {
                    pedido.mostrarPedido();

                } 
        }
        
    }

}

    

    