import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Josephus {
    public static void main(String[] args) {
        int n = 20;
        int m = 2;
        
        List<Pessoa> roda = criarRodaPessoas(n);
        int sobrevivente = resolverProblemaJosephus(roda, m);
        
        System.out.println("A pessoa sobrevivente é a número " + sobrevivente);
    }
    
    private static List<Pessoa> criarRodaPessoas(int n) {
        List<Pessoa> roda = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            Pessoa pessoa = new Pessoa(i, "Nome " + i, "Telefone " + i, "Endereço " + i, "CPF " + i);
            roda.add(pessoa);
        }
        
        return roda;
    }
    
    private static int resolverProblemaJosephus(List<Pessoa> roda, int m) {
        Random random = new Random();
        int indice = 0;
        
        while (roda.size() > 1) {
            indice = (indice + random.nextInt(m)) % roda.size();
            roda.remove(indice);
        }
        
        return roda.get(0).getNumero();
    }
}
