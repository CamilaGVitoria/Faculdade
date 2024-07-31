package Ex3;

public class Aviao {
    private String nome;
    private int id;

    public Aviao(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Avião [Nome: " + nome + ", ID: " + id + "]";
    }
}