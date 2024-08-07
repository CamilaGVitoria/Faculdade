package Ex6;

import java.util.Random;

public class Ex6 {

    public static void main(String[] args) {
        LinkedList L1 = new LinkedList();
        LinkedList L2 = new LinkedList();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            L1.add(random.nextInt(201) - 100);
            L2.add(random.nextInt(201) - 100);
        }

        System.out.println("Lista L1:");
        L1.printList();

        System.out.println("Lista L2:");
        L2.printList();

        LinkedList L3_inverted = L1.invert();
        System.out.println("L1 invertida:");
        L3_inverted.printList();

        LinkedList L3_odds = L1.getOdds().concatenate(L2.getOdds());
        System.out.println("Elementos ímpares de L1 e L2:");
        L3_odds.printList();

        LinkedList L3_concatenated = L1.concatenate(L2);
        System.out.println("L1 concatenada com L2:");
        L3_concatenated.printList();

        LinkedList L3_intersection = L1.intersection(L2);
        System.out.println("Intersecção de L1 e L2:");
        L3_intersection.printList();

        LinkedList L3_intercalated = L1.intercalate(L2);
        System.out.println("L1 e L2 intercaladas:");
        L3_intercalated.printList();

        LinkedList L3_intercalatedSorted = L1.intercalateSorted(L2);
        System.out.println("L1 e L2 intercaladas e ordenadas:");
        L3_intercalatedSorted.printList();
    }

}
