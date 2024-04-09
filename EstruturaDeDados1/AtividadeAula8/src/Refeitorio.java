import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Refeitorio {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        Queue<Object> filaRefeitorio = new LinkedList<>();

        while (true) {
            System.out.println("Informe o tipo de pessoa: \nDigite 1 se for aluno\nDigite 2 se for professor"
                    + "\nDigite 3 se for tecnico\nDigite s para sair");
            String tipoPessoa = recebe.nextLine();

            if (tipoPessoa.equalsIgnoreCase("s")) {
                break;
            }

            switch (tipoPessoa.toLowerCase()) {
                case "1":
                    System.out.println("Nome do aluno: ");
                    String nomeAluno = recebe.nextLine();

                    System.out.println("Número de matricula: ");
                    int matricula = recebe.nextInt();
                    recebe.nextLine();

                    System.out.println("Curso: ");
                    String curso = recebe.nextLine();

                    Aluno aluno = new Aluno(nomeAluno, curso, matricula);
                    filaRefeitorio.add(aluno);

                    break;

                case "2":
                    System.out.println("Nome do professor: ");
                    String nomeProf = recebe.nextLine();

                    System.out.println("Número do SIAP: ");
                    int siapProf = recebe.nextInt();
                    recebe.nextLine();

                    System.out.println("Titulo: ");
                    String titulo = recebe.nextLine();

                    Professor professor = new Professor(nomeProf, titulo, siapProf);
                    filaRefeitorio.add(professor);

                    break;
                case "3":
                    System.out.println("Nome do técnico administrativo: ");
                    String nomeTecnico = recebe.nextLine();

                    System.out.println("Número do SIAP: ");
                    int siapTec = recebe.nextInt();
                    recebe.nextLine();

                    TecnicoAdministrativo tecnico = new TecnicoAdministrativo(nomeTecnico, siapTec);
                    filaRefeitorio.add(tecnico);
                    break;

                default:
                    System.out.println("Valor invalido!!");
                    break;
            }
            System.out.println("\nFila do refeitorio: ");
            for (Object pessoa : filaRefeitorio) {
                System.out.println(pessoa);
            }
            System.out.println();
        }

        System.out.println("\nEntrando no refeitorio: ");

        while (!filaRefeitorio.isEmpty()) {
            Object pessoaAtual = filaRefeitorio.poll();
            System.out.println("Entrou no refeitorio: " + pessoaAtual);
        }

        System.out.println("\nTodos entraram no refeitorio!!");

        recebe.close();
    }
}
