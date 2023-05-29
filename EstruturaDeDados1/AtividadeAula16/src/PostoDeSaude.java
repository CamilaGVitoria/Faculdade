import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PostoDeSaude {
    public static void main(String[] args) {
        Deque<Pessoa> filaAtendimento = new LinkedList<>();
        List<Pessoa> naoAtendidas = new ArrayList<>();
        Random random = new Random();
        int numPessoasAtendidas = 0;
        int grupo = 1;    

        for (int i = 1; i <= 100; i++) {
            String sexo = random.nextBoolean() ? "M" : "F";
            int idade = random.nextInt(100);
            boolean gestante = random.nextBoolean();
            boolean lactante = random.nextBoolean();
            boolean necessidadeEspecial = random.nextBoolean();
            
            Pessoa pessoa = new Pessoa(i, sexo, idade, gestante, lactante, necessidadeEspecial);
            
            if (pessoa.necessidadeEspecial) {
                filaAtendimento.addFirst(pessoa);
            } else if (pessoa.idade >= 60) {
                filaAtendimento.addFirst(pessoa);
            } else if (pessoa.gestante || pessoa.lactante) {
                filaAtendimento.addLast(pessoa);
            } else {
                filaAtendimento.addLast(pessoa);
            }
        }
        
        while (numPessoasAtendidas < 100 && !filaAtendimento.isEmpty()) {
            int numPessoasGrupo = Math.min(grupo, filaAtendimento.size());
            
            System.out.println("Grupo " + grupo + ":");
            
            for (int i = 0; i < numPessoasGrupo; i++) {
                Pessoa pessoa = filaAtendimento.removeFirst();
                System.out.println("Pessoa " + pessoa.id + " atendida: " + pessoa);
                numPessoasAtendidas++;
            }
            
            grupo++;
        }
        
        naoAtendidas.addAll(filaAtendimento);
        
        System.out.println("\nPessoas não atendidas:");
        
        for (Pessoa pessoa : naoAtendidas) {
            System.out.println("Pessoa " + pessoa.id + ": " + pessoa);
        }
    }
}
