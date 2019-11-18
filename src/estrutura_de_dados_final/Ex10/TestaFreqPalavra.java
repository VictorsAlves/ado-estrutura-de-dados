package estrutura_de_dados_final.Ex10;

import estrutura_de_dados_final.Ex10.Controller;
import estrutura_de_dados_final.Ex10.FreqPalavra;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class TestaFreqPalavra {

    public static void main(String[] args) throws IOException {
        String caminhoA = "C:\\Users\\Victor\\Documents\\NetBeansProjects\\estrutura_de_dados_final\\src\\estrutura_de_dados_final\\assets\\regioes.txt";
        new Controller().start(caminhoA);
    }
}
