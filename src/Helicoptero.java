public class Helicoptero extends Aeronave {

    private  int qteHelices;

    public Helicoptero(String modelo, int capacidadepassageiros, double pesokg, double velocidademax, int qteHelices) {
        super(modelo, capacidadepassageiros, pesokg, velocidademax);
        this.qteHelices = qteHelices;
    }
    public int getQteHelices() {
        return qteHelices;
    }
    public void setQteHelices(int qteHelices) {
        this.qteHelices = qteHelices;
    }
    public String toString() {
        String retorno = super.toString();
        retorno += "Quantidade de Hélices: "     + this.qteHelices     + "\n";
        return retorno;
    }

    @Override
    public boolean ativarVoo() {
        return false;
    }
}
