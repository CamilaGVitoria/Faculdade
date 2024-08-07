package Ex6;

public class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public LinkedList invert() {
        LinkedList invertedList = new LinkedList();
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = invertedList.head;
            invertedList.head = newNode;
            current = current.next;
        }
        return invertedList;
    }

    public LinkedList getOdds() {
        LinkedList oddList = new LinkedList();
        Node current = head;
        while (current != null) {
            if (current.data % 2 != 0) {
                oddList.add(current.data);
            }
            current = current.next;
        }
        return oddList;
    }

    public LinkedList concatenate(LinkedList list2) {
        LinkedList concatenatedList = new LinkedList();
        Node current = head;
        while (current != null) {
            concatenatedList.add(current.data);
            current = current.next;
        }
        current = list2.head;
        while (current != null) {
            concatenatedList.add(current.data);
            current = current.next;
        }
        return concatenatedList;
    }

    public LinkedList intersection(LinkedList list2) {
        LinkedList intersectionList = new LinkedList();
        Node current1 = head;
        while (current1 != null) {
            Node current2 = list2.head;
            while (current2 != null) {
                if (current1.data == current2.data) {
                    intersectionList.add(current1.data);
                    break;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }
        return intersectionList;
    }

    public LinkedList intercalate(LinkedList list2) {
        LinkedList intercalatedList = new LinkedList();
        Node current1 = head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            intercalatedList.add(current1.data);
            intercalatedList.add(current2.data);
            current1 = current1.next;
            current2 = current2.next;
        }
        while (current1 != null) {
            intercalatedList.add(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            intercalatedList.add(current2.data);
            current2 = current2.next;
        }
        return intercalatedList;
    }

    public LinkedList intercalateSorted(LinkedList list2) {
        LinkedList intercalatedList = new LinkedList();
        Node current1 = head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                intercalatedList.add(current1.data);
                current1 = current1.next;
            } else {
                intercalatedList.add(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            intercalatedList.add(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            intercalatedList.add(current2.data);
            current2 = current2.next;
        }
        return intercalatedList;

    }
}
