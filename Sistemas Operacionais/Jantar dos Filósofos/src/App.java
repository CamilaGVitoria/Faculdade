import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) {
        Lock[] garfos = new Lock[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new ReentrantLock();
        }

        Thread[] filosofos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Thread(new Filosofo(i, garfos[i], garfos[(i + 1) % 5]));
            filosofos[i].start();
        }
    }
}

class Filosofo implements Runnable {
    private int id;
    private Lock garfoEsquerda;
    private Lock garfoDireita;

    public Filosofo(int id, Lock garfoEsquerda, Lock garfoDireita) {
        this.id = id;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }

    private void pegarGarfos() {
        garfoEsquerda.lock();
        garfoDireita.lock();
    }

    private void liberarGarfos() {
        garfoEsquerda.unlock();
        garfoDireita.unlock();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Filósofo " + id + " está pensando.");
                Thread.sleep(1000); 

                System.out.println("Filósofo " + id + " está com fome e tentando pegar garfos.");
                pegarGarfos();

                System.out.println("Filósofo " + id + " está comendo.");
                Thread.sleep(2000); 
                
                System.out.println("Filósofo " + id + " terminou de comer e está liberando os garfos.");
                liberarGarfos();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}