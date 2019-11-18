package estrutura_de_dados_final.Ex10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class Controller {

    private No no = null;

    //start do controller
    public void start(String path) {
        String texto = read(path);
        no = orderByAlfa(texto);
        printNoOrdenado(no);
    }

    //ordena em ordem alfabetica
    public No orderByAlfa(String texto) {
        //quanto o texto nao for vazio
        while (!texto.isEmpty()) {

            //obtendo palavras entre espacoes
            String palavra = texto.substring(0, (texto.indexOf(" ") > -1) ? texto.indexOf(" ") + 1 : texto.length()).replace(",", "").replace(".", "").trim();

            //se for uma palavra
            if (!palavra.isEmpty()) {

                //verificando existencia a arvore
                if (no == null) {
                    //instanciando ela
                    no = new No(new FreqPalavra(palavra, 1), null, null);
                } else {
                    //comparando os nos e montando a arvore
                    compareNo(no, palavra, 1);
                }
            }

            //obtendo a sobra do texto
            texto = (texto.indexOf(" ") > -1) ? texto.substring(texto.indexOf(" ") + 1, texto.length()) : "";
        }

        //retornando o no
        return no;
    }

    public void compareNo(final No no, String palavra, int ocorrencia) {

        // verificando se a palavra é maior ou menor ou igual ao palavra no elemento deste NO
        int compare = palavra.compareTo(no.getElemento().getPalavra());

        //caso seja menor
        if (compare < 0) {
            if (no.getEsquerda() != null) {
                //caso exista uma palavra neste elemento, reaplica a funcao para o proximo no
                compareNo(no.getEsquerda(), palavra, ocorrencia);
            } else {
                //caso nao exista uma palavra, registrando e verificando se ela ja existe na arvore e quantas vezes ela se repete
                no.setEsquerda(new No(new FreqPalavra(palavra, fraquencia(palavra, this.no, ocorrencia)), null, null));
            }
            //caso seja maior
        } else if (compare > 0) {
            if (no.getDireita() != null) {
                //caso exista uma palavra neste elemento, reaplica a funcao para o proximo no
                compareNo(no.getDireita(), palavra, ocorrencia);
            } else {
                //caso nao exista uma palavra, registrando e verificando se ela ja existe na arvore e quantas vezes ela se repete
                no.setDireita(new No(new FreqPalavra(palavra, fraquencia(palavra, this.no, ocorrencia)), null, null));
            }
        } else {
            //caso seja igual a palavra existente neste No
            if (no.getDireita() != null) {
                //caso exista uma palavra neste elemento, reaplica a funcao para o proximo no
                compareNo(no.getDireita(), palavra, ocorrencia);
            } else {
                //caso nao exista uma palavra, registrando e verificando se ela ja existe na arvore e quantas vezes ela se repete
                no.setDireita(new No(new FreqPalavra(palavra, fraquencia(palavra, this.no, ocorrencia)), null, null));
            }
        }
    }

    public void printNoOrdenado(No no) {
        if (no != null) {
            //reaplicando a funcao para o menor no, que se encontra a esquerda da arvore
            printNoOrdenado(no.getEsquerda());

            if (no.getElemento() != null && fraquencia(no.getElemento().getPalavra(), no.getDireita(), 0) == 0) {
                //printando o elemento (palavra e sequencia), caso seja a ultima palavra encontrada na arvore
                System.out.println(no.getElemento().print());
            }

            //reaplicando a funcao para o maior no, que se encontra a direita da arvore
            printNoOrdenado(no.getDireita());
        }
    }

    private int fraquencia(String elemento, No p, int ocorrencia) {
        //caso o no ou o elemento dentro dela seja inexistente
        if (p == null || p.getElemento() == null) {
            //retorna o numero de ocorrencias encontradas
            return ocorrencia;
        }

        //verificando se a palavra e maior ou menor ou igual a palavra existente neste no
        int comp = elemento.compareTo(p.getElemento().getPalavra());

        //caso encontre a palavra aumenta a ocorrencia e continua repetindo a funcao para achar novas palavras
        if (comp == 0) {
            fraquencia(elemento, p.getDireita(), ocorrencia++);
        } else if (comp < 1) {
            //caso menor reaplica a funcao procurando nova palavra
            return fraquencia(elemento, p.getEsquerda(), ocorrencia);
        } else {
            //caso menor reaplica a funcao procurando nova palavra
            return fraquencia(elemento, p.getDireita(), ocorrencia);
        }

        //retorna o numero de ocorrencias encontradas
        return ocorrencia;
    }

    //lendo arquivo
    private static String read(String caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha + " ";
                    linha = lerArq.readLine();
                    if (linha != null) {
                        conteudo += " ";
                    }
                }
                arq.close();
            } catch (IOException e) {
                System.out.println("Erro: não foi possível ler o arquivo");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("erro: Arquivo não encontrado!");
        }
        if (conteudo.contains("Erro")) {
            return "";
        } else {
            return conteudo;
        }
    }
}
