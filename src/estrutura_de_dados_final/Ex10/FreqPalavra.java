package estrutura_de_dados_final.Ex10;

/**
 *
 * @author Victor
 */
public class FreqPalavra {

    private String palavra;
    private int frequencia;

    public FreqPalavra(String palavra) {
        this.palavra = palavra;
        this.frequencia = 1;
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
    
    public void acrecentaFrequencia() {
        this.frequencia++;
    }

    @Override
    public String toString() {
        return "palavra = " + palavra + " \nfrenquencia = " + frequencia + "\n";
    }

}
