import java.util.ArrayList;
import java.util.Arrays;

public class Restaurante {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Platillo> platillos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public Restaurante() { //Para testing
        cargarPlatillos();
        cargarMesas();
    }

    public void agregarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }


    public void agregarPlatillo(Platillo platillo) {
        platillos.add(platillo);
    }
    
    public void agregarMesa(Mesa mesa){
        mesas.add(mesa);
    }
    public ArrayList<Mesa> getMesas() {
        return mesas; 
    }

    public void cargarPlatillos() { //Probicional, se debe que arreglar como se aborda
        platillos.add(new Platillo("Sopa de fideo", 1, 119, new ArrayList<>(Arrays.asList("Caldo de res", "Fideo", "Cebolla", "Perejil", "Ajo", "Pimienta", "Sal", "Aceite de olivo", "Manteca", "Queso añejo"))));
        platillos.add(new Platillo("Ejotes de fonda", 1, 86, new ArrayList<>(Arrays.asList("Ejote verde", "Mantequilla", "Limón", "Perifollo", "Sal", "Pimienta"))));
        platillos.add(new Platillo("Tamales de escamoles", 1, 327, new ArrayList<>(Arrays.asList("Escamoles", "Nopal", "Epazote", "Chile verde", "Totomoxtle", "Orégano", "Sal"))));
        platillos.add(new Platillo("Sopa de tortilla", 1, 120, new ArrayList<>(Arrays.asList("Tortillas de maíz", "Jitomate", "Cebolla blanca", "Ajo", "Chile pasilla seco", "Caldo de pollo", "Epazote", "Aceite vegetal", "Aguacate", "Queso fresco", "Crema", "Sal", "Pimienta"))));
        platillos.add(new Platillo("Crema de pistache", 1, 180, new ArrayList<>(Arrays.asList("Pistache", "Crema", "Leche entera", "Caldo de pollo", "Cebolla blanca", "Ajo", "Mantequilla", "Harina de trigo", "Sal", "Pimienta blanca"))));
        platillos.add(new Platillo("Ensalada Caesar", 1, 239, new ArrayList<>(Arrays.asList("Lechuga romana", "Queso parmesano", "Pan para crutones", "Aceite de oliva extra virgen", "Huevo", "Limón", "Ajo", "Mostaza Dijon", "Salsa inglesa", "Sal"))));
        platillos.add(new Platillo("Ensalada de mandarina", 1, 215, new ArrayList<>(Arrays.asList("Mix de lechugas", "Mandarina", "Queso de cabra", "Mix de semillas", "Miel", "Mostaza Dijon", "Manzana", "Aceite de oliva", "Vinagre de manzana", "Sal"))));
        

        platillos.add(new Platillo("Pipián verde", 2, 244, new ArrayList<>(Arrays.asList("Pollo", "Caldo de pollo", "Chile serrano", "Cebolla", "Ajo", "Tomate verde", "Hoja santa", "Pepita de calabaza", "Sal", "Manteca de cerdo"))));
        platillos.add(new Platillo("Mole de olla", 2, 307, new ArrayList<>(Arrays.asList("Cuete de res", "Chamorro de cerdo", "Chambarete", "Chile ancho", "Vinagre blanco", "Agua", "Cebolla blanca", "Ajo", "Calabacita", "Xoconostle", "Elote", "Epazote", "Sal", "Aceíte de maíz", "Agua"))));
        platillos.add(new Platillo("Chalupas Poblanas", 2, 125, new ArrayList<>(Arrays.asList("Tortillas de maíz", "Carnitas de cerdo", "Cebolla morada", "Tomate verde", "Jitomate", "Chile serrano", "Chile de árbol seco", "Ajo", "Cilantro", "Manteca", "Sal"))));
        platillos.add(new Platillo("Cochinita Pibil", 2, 299, new ArrayList<>(Arrays.asList("Carne de cerdo", "Pasta de achiote", "Naranja agria", "Limón", "Ajo", "Cebolla morada", "Chile abanero", "Jitomate", "Piña", "Cilantro", "Manteca de cerdo", "Tortillas de maíz", "Orégano", "Comino", "Sal", "Pimienta"))));
        platillos.add(new Platillo("Enchiladas de Jamaica", 2, 159, new ArrayList<>(Arrays.asList("Tortillas de maíz", "Flor de jamaica", "Tomate verde", "Chile serrano", "Cebolla blanca", "Cebolla morada", "Crema", "Queso oaxaca", "Queso fresco", "Ajo", "Cilantro", "Betabel", "Aceite vegetal", "Sal"))));
        platillos.add(new Platillo("Pozole verde", 2, 165, new ArrayList<>(Arrays.asList("Maíz pozolero", "Carne de cerdo", "Costilla de cerdo", "Tomate verde", "Pepita de calabaza", "Lechuga romana", "Rábanos", "Ajo", "Cilantro", "Epazote", "Orégano seco", "Limón", "Tostadas de maíz", "Sal"))));
        platillos.add(new Platillo("Chilaquiles verdes", 2, 175, new ArrayList<>(Arrays.asList("Tortillaz de maíz", "Tomate verde", "Cebolla blanca", "Cilantro", "Aceite vegetal", "Crema", "Queso fresco", "Epazote", "Pollo", "Sal"))));
        platillos.add(new Platillo("Pollo con mole poblano", 2, 330, new ArrayList<>(Arrays.asList("Pollo", "Pasta de mole poblano", "Caldo de pollo", "Arroz blanco", "Jitomate", "Cebolla blanca", "Plátano macho", "Aceite vegetal", "Ajonjolí", "Canela", "Anís", "Tomillo", "Laurel", "Sal", "Pimienta"))));
        

        platillos.add(new Platillo("Pay de pétalos de rosa", 3, 170, new ArrayList<>(Arrays.asList("Galletas", "Mantequilla", "Queso crema", "Crema para batir", "Leche condensada", "Grenetina", "Pétalos de rosa", "Azúcar refinada", "Limón", "Extracto de vainilla"))));
        platillos.add(new Platillo("Bomba Poblana", 3, 210, new ArrayList<>(Arrays.asList("Chocolate semiamargo", "Chocolate con leche", "Crema para batir", "Mantequilla", "Harina de trigo", "Azúcar", "Huevo", "Cacao en polvo", "Leche", "Vainilla", "Grenetina"))));
        platillos.add(new Platillo("Pastel de elote", 3, 160, new ArrayList<>(Arrays.asList("Elote", "Harina de trigo", "Mantequilla", "Leche condensada", "Leche entera", "Huevo", "Polvo para hornear", "Extracto vainilla", "Canela", "Sal"))));
        platillos.add(new Platillo("Fresas con crema", 3, 140, new ArrayList<>(Arrays.asList("Fresas", "Crema para batir", "Media crema", "Leche condensada", "Leche evaporada", "Azúcar refinada", "Extracto de vainilla"))));
        platillos.add(new Platillo("Arroz de la Abuela", 3, 140, new ArrayList<>(Arrays.asList("Arroz blanco", "Leche entera", "Leche condensada", "Azúcar refinada", "Canela", "Pasas", "Vainilla", "Fécula de maíz", "Harina de trigo", "Mantequilla", "Clara de huevo"))));
        platillos.add(new Platillo("Cielo rojo de bayas", 3, 170, new ArrayList<>(Arrays.asList("Fresas", "Arándano azul", "Zarzamora", "Frambuesa", "Yogurt natural", "Amaranto", "Miel"))));
        
    }

    public void cargarMesas()
    {
        for(int i=0; i<=15; i++)
        {
            mesas.add(new Mesa(i));
        }
    }

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public ArrayList<Platillo> getPlatillos(){
        return this.platillos;
    }

    public void getPlatillos(ArrayList<Platillo> platillos)
    {
        this.platillos = platillos;
    }

    public ArrayList<Mesa> setMesas(){
        return this.mesas;
    }

    public void getMesas(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }
}