public class Mesa {
    private int numMesa;
    private boolean ocupada;
    private int cuentaTotal;

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        this.ocupada = false;
        this.cuentaTotal = 0;
    }

    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getCuentaTotal() {
        return cuentaTotal;
    }
    public void setCuentaTotal(int cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

}