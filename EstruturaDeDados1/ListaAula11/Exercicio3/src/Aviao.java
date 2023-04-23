public class Aviao {
    private String nomeAviao;
    private int numeroAviao;

    public Aviao(String nomeAviao, int numeroAviao) {
        this.nomeAviao = nomeAviao;
        this.numeroAviao = numeroAviao;
    }

    public String getNomeAviao() {
        return nomeAviao;
    }

    public int getNumeroAviao() {
        return numeroAviao;
    }

    @Override
    public String toString() {
        return "Avião " + numeroAviao + " - " + nomeAviao;
    }
}
