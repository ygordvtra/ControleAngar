public class Aviao extends Aeronave {
    //C, S, M
    public int qteTurbinas;

    public Aviao(String modelo, int capacidadepassageiros, double pesokg, double velocidademax, int qteTurbinas) {
        super(modelo, capacidadepassageiros, pesokg, velocidademax);
        this.qteTurbinas = qteTurbinas;
    }

    public int getQteTurbinas() {
        return qteTurbinas;
    }

    public void setQteTurbinas(int qteTurbinas) {
        this.qteTurbinas = qteTurbinas;
    }

    public String toString() {
        String retorno = super.toString();
        retorno += "Quantidade de Turbinas "     + this.qteTurbinas     + "\n";
        return retorno;
    }

    @Override
    public boolean ativarVoo() {
        return false;
    }
}
