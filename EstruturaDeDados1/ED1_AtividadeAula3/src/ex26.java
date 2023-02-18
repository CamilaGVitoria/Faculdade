import java.util.Scanner;

public class ex26 {
    public static void main(String[] args) throws Exception {
        Scanner recebe = new Scanner(System.in);

        int data, dia, mes, ano, ndata;

        System.out.println("Digite a data no formato DDMMAA: " );
        data = recebe.nextInt();

        dia = data / 10000;
        mes = data % 10000 / 100;
        ano = data % 100;
        ndata = mes*10000 + dia*100 + ano;

        System.out.println("DIA: " + dia);
        System.out.println("MES: " + mes);
        System.out.println("ANO: " + ano);
        System.out.println("DATA NO FORMATO MMDDAA: " + ndata);

        recebe.close();
    }
}
