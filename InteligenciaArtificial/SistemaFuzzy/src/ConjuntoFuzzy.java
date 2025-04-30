public class ConjuntoFuzzy {
    private String nome;
    private double a, b, c; // Parâmetros da função triangular

    public ConjuntoFuzzy(String nome, double a, double b, double c) {
        this.nome = nome;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcularPertinencia(double valor) {
        if (valor <= a || valor >= c) {
            return 0;
        } else if (valor == b) {
            return 1;
        } else if (valor > a && valor < b) {
            return (valor - a) / (b - a);
        } else {
            return (c - valor) / (c - b);
        }
    }

    public String getNome() {
        return nome;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
