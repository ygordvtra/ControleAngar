import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ControleAngar {

    private ArrayList<Aeronave> naves = new ArrayList<Aeronave>();

    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public Planador lePlanador (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Comprimento das Asas"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        double comprimentoAsas = this.retornaDouble(valores [4]);

        Planador planador = new Planador (valores[0],capacidadepassageiros,pesokg,velocidademax, comprimentoAsas);
        return planador;
    }

    public Aviao leAviao (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Quantidade de Turbinas"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        int qteTurbinas = this.retornaInteiro(valores [4]);

        Aviao aviao = new Aviao (valores[0],capacidadepassageiros,pesokg,velocidademax, qteTurbinas);
        return aviao;
    }

    public Helicoptero leHelicoptero (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Quantidade de Hélices"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        int qteHelices = this.retornaInteiro(valores [4]);

        Helicoptero helicoptero = new Helicoptero (valores[0],capacidadepassageiros,pesokg,velocidademax, qteHelices);
        return helicoptero;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // MÈtodo est·tico, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // N„o conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Enquanto n„o for possÌvel converter o valor de entrada para inteiro, permanece no loop
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n˙mero inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    private boolean doubleValido(String s) {
        try {
            Double.parseDouble(s); // MÈtodo est·tico, que tenta tranformar uma string em double
            return true;
        } catch (NumberFormatException e) { // N„o conseguiu tranformar em double e gera erro
            return false;
        }
    }
    public double retornaDouble(String entrada) { // retorna um valor inteiro
        float numFloat;

        //Enquanto n„o for possÌvel converter o valor de entrada para FLOAT, permanece no loop
        while (!this.doubleValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n˙mero decimal.");
        }
        return Double.parseDouble(entrada);
    }


    public void salvaNaves (ArrayList<Aeronave> naves ){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("naves.dados"));
            for (int i=0; i < naves.size(); i++)
                outputStream.writeObject(naves.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"ImpossÌvel criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("finally")
    public ArrayList<Aeronave> recuperaNaves (){
        ArrayList<Aeronave> navesTemp = new ArrayList<Aeronave>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("naves.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Aeronave) {
                    navesTemp.add((Aeronave) obj);
                }
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com corpos celestes N√O existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectInputStream
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return navesTemp;
        }
    }


    public void menuNaves (){

        String menu = "";
        String entrada;
        int    opc1, opc2;

        do {
            menu = "Controle de Aeronaves\n" +
                    "Opções:\n" +
                    "1. Entrar Aeronave\n" +
                    "2. Exibir Aeronave\n" +
                    "3. Limpar Aeronave\n" +
                    "4. Gravar Aeronave\n" +
                    "5. Recuperar Aeronave\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Aeronave\n" +
                            "Opções:\n" +
                            "1. Avião\n" +
                            "2. Helicóptero\n" +
                            "3. Planador";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2){
                        case 1: naves.add((Aeronave) leAviao());
                            break;
                        case 2: naves.add((Aeronave) leHelicoptero());
                            break;
                        case 3: naves.add((Aeronave) lePlanador());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Aeronave para entrada não escolhida!");
                    }

                    break;

                case 2: // Exibir dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"N„o h· corpos celestes em memÛria. Entre com corpos celestes primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < naves.size(); i++)	{
                        dados += naves.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;

                case 3: // Limpar Dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"N„o h· corpos celestes em memÛria. Entre com corpos celestes primeiramente");
                        break;
                    }
                    naves.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;

                case 4: // Grava Dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"N„o h· corpos celestes em memÛria. Entre com corpos celestes primeiramente");
                        break;
                    }
                    salvaNaves(naves);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;

                case 5: // Recupera Dados
                    naves = recuperaNaves();
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo CONTROLE ESPACIAL");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main(String[] args) {

        ControleAngar ca = new ControleAngar();

        ca.menuNaves();


    }

}
