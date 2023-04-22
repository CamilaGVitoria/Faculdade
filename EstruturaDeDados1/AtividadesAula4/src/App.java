public class App {
    public static void main(String[] args) throws Exception {
        int compra = 100;
        int venda = 101;

        double lucro = venda - compra;

        if( ((10/compra) * 100) < lucro ){
                System.out.println("ta certo");
        }
        System.out.println("nop");



    }
}
