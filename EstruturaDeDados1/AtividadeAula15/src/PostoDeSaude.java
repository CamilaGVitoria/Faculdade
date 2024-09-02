import java.util.Random;

public class PostoDeSaude {
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular();

        int pessoasAtendidas = 0;
        int grupo = 1;

        while (pessoasAtendidas < 100) {
            for (int i = 0; i < 10; i++) {
                Pessoa p = gerarPessoaAleatoria(pessoasAtendidas + i + 1);
                fila.adicionarPessoa(p);
            }

            fila.ordenarPorPrioridade();

            int atenderNesteGrupo = Math.min(grupo, 100 - pessoasAtendidas); // Aumentar gradualmente até atingir 100 atendimentos
            System.out.println("Atendendo " + atenderNesteGrupo + " pessoas do grupo " + grupo + ":");
            for (int i = 0; i < atenderNesteGrupo; i++) {
                Pessoa atendida = fila.atenderPessoa();
                if (atendida != null) {
                    System.out.println(atendida);
                    pessoasAtendidas++;
                }
            }
            grupo++;
            System.out.println("=====================================");
        }

        if (!fila.estaVazia()) {
            System.out.println("Pessoas que não foram atendidas:");
            System.out.println(fila);
        }
    }

    public static Pessoa gerarPessoaAleatoria(int id) {
        Random random = new Random();
        String sexo = random.nextBoolean() ? "M" : "F";
        int idade = random.nextInt(80) + 18; 
        boolean gestante = (sexo.equals("F") && random.nextBoolean());
        boolean lactante = (sexo.equals("F") && random.nextBoolean());
        boolean necessidadeEspecial = random.nextInt(10) < 1; 

        return new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);
    }
}
