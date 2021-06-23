import java.io.Serializable;

public abstract class Aeronave implements Serializable {

    private String modelo;
    private int capacidadepassageiros;
    private double pesokg;
    private double velocidademax;

    public Aeronave(String modelo, int capacidadepassageiros, double pesokg, double velocidademax) {
        this.modelo = modelo;
        this.capacidadepassageiros = capacidadepassageiros;
        this.pesokg = pesokg;
        this.velocidademax = velocidademax;

    }

    public String toString() {
        String retorno = "";
        retorno += "Modelo: " + this.modelo + "\n";
        retorno += "Capacidade de Passageiros: " + this.capacidadepassageiros + "\n";
        retorno += "Peso em Kilos" + this.pesokg + " kg\n";
        retorno += "Velocidade Máxima" + this.velocidademax + " Kmh\n";
        return retorno;
    }

    public abstract boolean ativarVoo();

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadepassageiros() {
        return capacidadepassageiros;
    }

    public void setCapacidadepassageiros(int capacidadepassageiros) {
        this.capacidadepassageiros = capacidadepassageiros;
    }

    public double getPesokg() {
        return pesokg;
    }

    public void setPesokg(double pesokg) {
        this.pesokg = pesokg;
    }

    public double getVelocidademax() {
        return velocidademax;
    }

    public void setVelocidademax(double velocidademax) {
        this.velocidademax = velocidademax;
    }


}