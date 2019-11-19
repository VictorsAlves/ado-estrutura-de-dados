package estrutura_de_dados_final.Ex10;

/**
 *
 * @author Victor
 */
public class No {

    private No esquerda;
    private No direita;
    private FreqPalavra elemento;

    public No(FreqPalavra elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esquerda = esq;
        this.direita = dir;
    }
    
    public No(FreqPalavra elemento) {
        this.elemento = elemento;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public FreqPalavra getElemento() {
        return elemento;
    }
    public void setElemento(FreqPalavra elemento) {
       this.elemento = elemento;
    }
}
