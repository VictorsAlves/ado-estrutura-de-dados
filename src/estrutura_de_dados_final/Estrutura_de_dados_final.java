/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura_de_dados_final;

import estrutura_de_dados_final.Ex01.ABB;

/**
 *
 * @author Victor
 */
public class Estrutura_de_dados_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ABB tree = new ABB() {};
        tree.insere(8);
        tree.insere(2);
        tree.insere(5);
        tree.insere(9);
        tree.insere(1);
        tree.preOrdem();

        
        
    }

}
