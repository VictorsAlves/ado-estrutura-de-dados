package estrutura_de_dados_final.Ex10;

/**
 *
 * @author Victor
 */
public class Arvore {
    //arvore do nos
    private No no = null;
    //start do controller
    public Arvore(String texto) {
        no = orderByAlfa(texto);
    }
    //printar a arvore
    public void printArvore(){
        printNoOrdenado(no);
    }
    //ordena em ordem alfabetica
    private No orderByAlfa(String texto) {
        //quanto o texto nao for vazio
        while (!texto.isEmpty()) {
            //obtendo palavras entre espacoes
            String palavra = texto.substring(0, (texto.contains(" ")) ? texto.indexOf(" ") + 1 : texto.length()).replace(",", "").replace(".", "").trim();
            //se for uma palavra
            if (!palavra.isEmpty()) {
                //verificando existencia a arvore
                if (no == null) {
                    //instanciando ela
                    no = new No(new FreqPalavra(palavra));
                } else {
                    //comparando os nos e montando a arvore
                    compareNo(no, palavra);
                }
            }
            //obtendo a sobra do texto
            texto = (texto.contains(" ")) ? texto.substring(texto.indexOf(" ") + 1, texto.length()) : "";
        }
        //retornando o no
        return no;
    }
    //comparar nos
    private void compareNo(final No no, String palavra) {
        // verificando se a palavra é maior ou menor ou igual ao palavra no elemento deste NO
        int compare = palavra.compareTo(no.getElemento().getPalavra());
        //caso seja menor
        if (compare < 0) {
            if (no.getEsquerda() != null) {
                //caso exista uma palavra neste elemento, reaplica a funcao para o proximo no
                compareNo(no.getEsquerda(), palavra);
            } else {
                //caso nao exista uma palavra, registrando e verificando se ela ja existe na arvore e quantas vezes ela se repete
                no.setEsquerda(new No(new FreqPalavra(palavra)));
            }
            //caso seja maior
        } else if (compare > 0) {
            if (no.getDireita() != null) {
                //caso exista uma palavra neste elemento, reaplica a funcao para o proximo no
                compareNo(no.getDireita(), palavra);
            } else {
                //caso nao exista uma palavra, registrando e verificando se ela ja existe na arvore e quantas vezes ela se repete
                no.setDireita(new No(new FreqPalavra(palavra)));
            }
        } else {
            no.getElemento().acrecentaFrequencia();
        }
    }
    //print da arvore ordenada
    private void printNoOrdenado(No no) {
        if (no != null) {
            //reaplicando a funcao para o menor no, que se encontra a esquerda da arvore
            printNoOrdenado(no.getEsquerda());
            //printando o elemento (palavra e sequencia), caso seja a ultima palavra encontrada na arvore
            if (no.getElemento() != null) {
                System.out.println(no.getElemento().toString());
            }
            //reaplicando a funcao para o maior no, que se encontra a direita da arvore
            printNoOrdenado(no.getDireita());
        }
    }
}