public class Planador extends Aeronave {

    private double comprimentoAsas;

    public Planador(String modelo, int capacidadepassageiros, double pesokg, double velocidademax, double comprimentoAsas) {
        super(modelo, capacidadepassageiros, pesokg, velocidademax);
        this.comprimentoAsas = comprimentoAsas;
    }

    public double getComprimentoAsas() {
        return comprimentoAsas;
    }

    public void setComprimentoAsas(double comprimentoAsas) {
        this.comprimentoAsas = comprimentoAsas;
    }
    public String toString() {
        String retorno = super.toString();
        retorno += "Comprimento das Asas: "     + this.comprimentoAsas     + "\n";
        return retorno;
    }

    @Override
    public boolean ativarVoo() {
        return false;
    }
}
