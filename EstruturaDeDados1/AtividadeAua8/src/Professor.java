public class Professor {
    private String nomeProf;
    private String titulo;
    private int siapProf;

    public Professor(String nomeProf, String titulo,int siapProf) {
        this.nomeProf = nomeProf;
        this.siapProf = siapProf;
        this.titulo = titulo;
    }
    public String getNome() {
        return nomeProf;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public int getSiap() {
        return siapProf;
    }
}
