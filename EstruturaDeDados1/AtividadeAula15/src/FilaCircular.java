import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class FilaCircular {
    private Deque<Pessoa> fila;

    public FilaCircular() {
        fila = new LinkedList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        fila.addLast(pessoa);
    }

    public Pessoa atenderPessoa() {
        if (!fila.isEmpty()) {
            return fila.pollFirst();
        }
        return null;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public void ordenarPorPrioridade() {
        List<Pessoa> lista = new ArrayList<>(fila);
        lista.sort(Comparator.comparingInt(p -> -p.prioridade));
        fila = new LinkedList<>(lista);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : fila) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}
