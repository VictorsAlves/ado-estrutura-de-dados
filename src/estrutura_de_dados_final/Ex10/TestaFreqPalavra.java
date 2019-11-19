package estrutura_de_dados_final.Ex10;

import estrutura_de_dados_final.Ex10.Arvore;
import estrutura_de_dados_final.Ex10.FreqPalavra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class TestaFreqPalavra {

    public static void main(String[] args) throws IOException {
        Arvore arvore = new Arvore(read("C:\\Users\\Victor\\Documents\\NetBeansProjects\\estrutura_de_dados_final\\src\\estrutura_de_dados_final\\assets\\regioes.txt"));
        arvore.printArvore();
    }
    
    //lendo arquivo
    private static String read(String caminho) {
        String conteudo = "", linha = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            while (linha != null) {
                conteudo += linha + " ";
                linha = lerArq.readLine();
                if (linha != null) {
                    conteudo += " ";
                }
            }
            arq.close();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return conteudo;
    }
}
