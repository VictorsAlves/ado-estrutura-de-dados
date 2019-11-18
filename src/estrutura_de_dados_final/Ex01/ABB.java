/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura_de_dados_final.Ex01;

/**
 *
 * @author ana.csantos119
 */
public class ABB {

    public No raiz;

    //Cria uma árvore vazia
    public ABB() {
        this.raiz = null;
    }

    public void insere(int elemento) {
        No pai = null;
        No p = raiz;
        No novo = new No(elemento, null, null);

        //Busca onde inserir o novo nó
        while (p != null) {
            pai = p;
            if (elemento < p.getElemento()) {
                p = p.getEsquerda();

            } else {

                p = p.getDireita();

            }
        }
        //Árvore ser vaziz
        if (pai == null) {
            raiz = novo;
            System.out.println("Iniciando Arvore com Raiz = " + raiz.getElemento());
        } else if (elemento < pai.getElemento()) {
            pai.setEsquerda(novo);
            System.out.println("  Inserindo " + elemento + " a esquerda de " + pai.getElemento());
        } else {
            pai.setDireita(novo);
            System.out.println("  Inserindo " + elemento + " a direita de " + pai.getElemento());
        }
    }

    public void insereR(int elemento) {
        if (raiz == null) {
            raiz = new No(elemento, null, null);
        } else {
            No novo = new No(elemento, null, null);
            insereR(raiz, novo);
        }
    }

    public void insereR(No p, No novo) {
        if (novo.getElemento() < p.getElemento()) {
            if (p.getEsquerda() == null) {
                p.setEsquerda(novo);
            } else {
                insereR(p.getEsquerda(), novo);
            }
        } else if (p.getDireita() == null) {
            p.setDireita(novo);
        } else {
            insereR(p.getDireita(), novo);
        }
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No p) {
        if (p != null) {
            System.out.print(p.getElemento() + " ");
            preOrdem(p.getEsquerda());
            preOrdem(p.getDireita());
        }
    }

    public void inOrdem() {
        inOrdem(raiz);
    }

    private void inOrdem(No p) {
        if (p != null) {
            inOrdem(p.getEsquerda());
            System.out.print(p.getElemento() + " ");
            inOrdem(p.getDireita());
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(No p) {
        if (p != null) {
            posOrdem(p.getEsquerda());
            posOrdem(p.getDireita());
            System.out.print(p.getElemento() + " ");
        }
    }

    public No buscaR(int elemento) {
        return buscaR(elemento, raiz);
    }

    private No buscaR(int elemento, No p) {
        if (p == null) {
            return null;            //Não achou
        }

        if (elemento == p.getElemento()) {
            return p;               //Achou
        }
        if (elemento < p.getElemento()) {
            return buscaR(elemento, p.getEsquerda());
        } else {
            return buscaR(elemento, p.getDireita());
        }
    }

    public No buscaIt(int elemento) {
        No p = raiz;

        while (p != null) {
            if (elemento == p.getElemento()) {
                return p;       //Achou
            } else if (elemento < p.getElemento()) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }
        return null; //Não achou
    }

    public No maior() {
        return maior(raiz);
    }

    private No maior(No p) {
        if (p.getDireita() == null) {
            return p;
        }
        return maior(p.getDireita());
    }

    public No menorIt() {
        No p = raiz;
        while (p.getEsquerda() != null) {
            p = p.getEsquerda();
        }
        return p;
    }

    public No menor() {
        return menor(raiz);
    }

    public No menor(No p) {
        if (p.getEsquerda() == null) {
            return p;
        }
        return menor(p.getEsquerda());
    }

    //Método que remove um nó na ABB
    public No remove(int elemento) {
        return remove(raiz, elemento);
    }

    public No remove(No p, int elemento) {
        if (p == null) {
            return null; //Não achei
        }
        if (elemento < p.getElemento()) {
            p.setEsquerda(remove(p.getEsquerda(), elemento));
        } else if (elemento > p.getElemento()) {
            p.setDireita(remove(p.getDireita(), elemento));
        } else {
            //elemento==p.getElemento()
            //Verifica se o elemento será removido tem subárvore esquerda
            if (p.getEsquerda() != null) {
                //busca o maior na subárvore esquerda
                No aux = maior(p.getEsquerda());
                //Copia o elemento maior da subarv esq para p
                p.setElemento(aux.getElemento());
                //Remove elemento copiado recursivamente
                p.setEsquerda(remove(p.getEsquerda(), aux.getElemento()));
            } //Verifica se o elemento será removido tem subárvore direita
            else if (p.getDireita() != null) {
                //busca o menor na subárvore direita
                No aux = menor(p.getDireita());
                //Copia o elemento menor da subarv dir para p
                p.setElemento(aux.getElemento());
                //Remove elemento copiado recursivamente
                p.setDireita(remove(p.getDireita(), aux.getElemento()));
            } else //Verifica se é folha
            {
                return null;
            }
        }
        return p;
    }

}
