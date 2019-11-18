package estrutura_de_dados_final.Ex10;

/**
 *
 * @author Victor
 */
public class FreqPalavra {

    private String palavra;
    private int frequencia;

    public FreqPalavra(String palavra, int frequencia) {
        this.palavra = palavra;
        this.frequencia = frequencia;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String print() {
        return "palavra = " + palavra + " / frenquencia = " + frequencia;
    }

}
