public class Aluno {
    private String nomeAluno;
    private String curso;
    private int matricula;

    public Aluno(String nomeAluno, String curso, int matricula) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.curso = curso;
    }
    public String getNome() {
        return nomeAluno;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public int getMatricula() {
        return matricula;
    }
}