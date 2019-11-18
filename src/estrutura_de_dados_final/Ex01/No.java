package estrutura_de_dados_final.Ex01;

import estrutura_de_dados_final.Ex10.*;

/**
 *
 * @author Victor
 */
public class No {

    public No esquerda;
    public No direita;
    public int elemento;

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esquerda = esq;
        this.direita = dir;
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

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", esq=" + esquerda + ", dir=" + direita + '}';
    }
}
