class Pessoa {
    int id;
    String sexo;
    int idade;
    boolean gestante;
    boolean lactante;
    boolean necessidadeEspecial;
    
    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
    }
    
    @Override
    public String toString() {
        String retorno = "ID: " + id + ", Sexo: " + sexo + ", Idade: " + idade + ", Gestante: " + gestante +
                         ", Lactante: " + lactante + ", Necessidade Especial: " + necessidadeEspecial;
        
        return retorno;
    }
}