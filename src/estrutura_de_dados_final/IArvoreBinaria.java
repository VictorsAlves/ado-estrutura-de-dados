/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura_de_dados_final;

import estrutura_de_dados_final.Ex10.No;

/**
 *
 * @author Victor
 */
public interface IArvoreBinaria {

    /**
     *
     * @param elemento
     */
    
    public  void insere(int elemento);

    public void insereR(int elemento);

    public void insereR(No p, No novo);

    public void preOrdem();

    public void preOrdem(No p);

    public void inOrdem();

    public void inOrdem(No p);

    public void posOrdem();

    public void posOrdem(No p);

    public No buscaR(int elemento);

    public No buscaR(int elemento, No p);

    public No buscaIt(int elemento);

    public No maior();

    public No maior(No p);

    public No menorIt();

    public No menor();

    public No menor(No p);

    public No remove(int elemento);

    public No remove(No p, int elemento);


}
