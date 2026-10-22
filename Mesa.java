public class Mesa {
    private int numMesa;
    private boolean ocupada;
    private float cuentaTotal;

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getOcupada(int ocupada) {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public float getCuentaTotal() {
        return cuentaTotal;
    }
    public void setCuentaTotal(float cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

}