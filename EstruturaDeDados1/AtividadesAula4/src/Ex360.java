import java.util.Scanner;

public class Ex360 {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int dataNasc = 0;
        int diaNasc = 0;
        int mesNasc = 0;
        String signo = "";

        System.out.println("Digite sua data de nascimento o formato ddmm ou 9999 para encerrar: ");
        dataNasc = recebe.nextInt();

        while (dataNasc != 9999) {
            diaNasc = dataNasc / 100; 
            mesNasc = dataNasc % 100;
    
            if (mesNasc == 12 && diaNasc > 21 || mesNasc == 1 && diaNasc <= 20){signo = "Capricórnio";} 
            if (mesNasc == 1 && diaNasc > 20 || mesNasc == 2 && diaNasc <= 19){signo = "Aquário";} 
            if (mesNasc == 2 && diaNasc > 19 || mesNasc == 3 && diaNasc <= 20){signo = "Peixes";} 
            if (mesNasc == 3 && diaNasc > 20 || mesNasc == 4 && diaNasc <= 20){signo = "Áries";} 
            if (mesNasc == 4 && diaNasc > 20 || mesNasc == 5 && diaNasc <= 20){signo = "Touro";} 
            if (mesNasc == 5 && diaNasc > 20 || mesNasc == 6 && diaNasc <= 20){signo = "Gêmios";} 
            if (mesNasc == 6 && diaNasc > 20 || mesNasc == 7 && diaNasc <= 21){signo = "Cancer";} 
            if (mesNasc == 7 && diaNasc > 21 || mesNasc == 8 && diaNasc <= 22){signo = "Leão";} 
            if (mesNasc == 8 && diaNasc > 22 || mesNasc == 9 && diaNasc <= 22){signo = "Virgem";} 
            if (mesNasc == 9 && diaNasc > 22 || mesNasc == 10 && diaNasc <= 22){signo = "Libra";} 
            if (mesNasc == 10 && diaNasc > 22 || mesNasc == 11 && diaNasc <= 21){signo = "Escorpião";} 
            if (mesNasc == 11 && diaNasc > 21 || mesNasc == 12 && diaNasc <= 22){signo = "Sagitário";} 

            System.out.println(signo);

            System.out.println("Digite sua data de nascimento o formato ddmm ou 9999 para encerrar: ");
            dataNasc = recebe.nextInt();
                
        }

        recebe.close();
       //encerra
    }
}
