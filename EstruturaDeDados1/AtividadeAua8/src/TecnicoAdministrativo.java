public class TecnicoAdministrativo {
    private String nomeTecnico;
    private int siapTecnico;

    public TecnicoAdministrativo(String nomeTecnico, int siapTecnico) {
        this.nomeTecnico = nomeTecnico;
        this.siapTecnico = siapTecnico;
    }
    public String getnomeTec() {
        return nomeTecnico;
    }
    public int getSiap() {
        return siapTecnico;
    }
    
}
