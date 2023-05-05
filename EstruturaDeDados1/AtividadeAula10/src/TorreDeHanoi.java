import java.util.Scanner;

public class TorreDeHanoi {
    /* Valores para testar:
        1) 1 Disco
        2) 10 Discos
        3) 20 Discos
        4) 30 Discos
        5) 40 Discos
        6) 41 Discos  */  
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de Discos: ");
        int qtdDiscos = recebe.nextInt();

        long tempoDeInicio = System.nanoTime();
        long movimentos = moverDiscos(qtdDiscos, 'A', 'C', 'B');        
        long tempoFinal = System.nanoTime();
        
        long tempoExecucaoEmNanosegundos = tempoFinal - tempoDeInicio;
        long tempoExecucaoEmMs = tempoExecucaoEmNanosegundos / 1000000;
        
        long horas = tempoExecucaoEmMs / 3600000;
        long minutos = (tempoExecucaoEmMs % 3600000) / 60000;
        long segundos = (tempoExecucaoEmMs % 60000) / 1000;
        long milissegundos = tempoExecucaoEmMs % 1000;
        
        String tempoFormatado = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milissegundos);
        
        System.out.println("Tempo de execução: " + tempoFormatado);
        System.out.println("Movimentos realizados: " + movimentos);

        recebe.close();
    }
        
    public static long moverDiscos(int numeroDisco, char torreOrigem, char torreDestino, char torreAuxiliar) {
        long movimentos = 0;

        if (numeroDisco == 1) {
            System.out.println("Move disco 1 da torre " + torreOrigem + " para a torre " + torreDestino);
            
            movimentos++;
        } else {
            movimentos += moverDiscos(numeroDisco-1, torreOrigem, torreAuxiliar, torreDestino);
            System.out.println("Move disco " + numeroDisco + " da torre " + torreOrigem + " para a torre " + torreDestino);
            
            movimentos++;
            
            movimentos += moverDiscos(numeroDisco-1, torreAuxiliar, torreDestino, torreOrigem);
        }
        return movimentos;
    }
    
}
