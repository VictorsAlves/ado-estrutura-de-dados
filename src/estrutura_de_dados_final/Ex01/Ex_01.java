/*
Escreva um método que calcule o ​número de nós​ de uma árvore binária
 */
package estrutura_de_dados_final.Ex01;

/**
 *
 * @author Victor
 */
public class Ex_01 extends ABB {

    public static void main(String[] args) {
        ABB tree = new ABB();
        tree.insere(0);
        tree.insere(1);
        tree.insere(2);
        tree.insere(1);
        tree.insere(3);

        System.out.println(numeroNos(tree));

    }

    public static int numeroNos(ABB tree) {
        No pai = tree.raiz;

        int contador = 1;

        while (pai.getEsquerda() != null) {
            pai = pai.getEsquerda();
            contador++;
        }
        while (pai.getDireita() != null) {
            pai = pai.getDireita();
            contador++;
        }
        return contador;

    }

}
