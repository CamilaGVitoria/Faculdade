import java.util.Scanner;

public class ex25 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        int data, dia, mes, ano;

        System.out.println("Digite data no formato ddmmaa: ");
        data = recebe.nextInt();

        dia = data / 10000;
        mes = data % 10000 / 100;
        ano = data % 100;

        System.out.println("DIA: " + dia);
        System.out.println("MES: " + mes);
        System.out.println("ANO: " + ano);

        recebe.close();
    }
}
