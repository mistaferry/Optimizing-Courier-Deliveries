import java.util.Iterator;

public class LinkedList<String> {

    //ітератор
    public class LiIterator implements Iterator {

        private Node current;

        public LiIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            Node tempo = current;
            current = current.getNext();
            return tempo;
        }
    }

    public class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            next = null;

        }

        public String getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public java.lang.String toString() {
            return data + "";
        }
    }

    Node head;

    public void addFirst(String data) {
        Node node = new Node(data);
        node.next = head; //перший елемент робимо другим
        head = node; // новий елемент стає першим
    }

    public String findByIndex(int index) {
        Node current = head;
        //якщо переший елемент пустий
        if (head == null) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.getData();
        }
        return null;
    }

    public LiIterator iterator() {
        return new LiIterator(head);
    }

    public int size() {
        //к-ть елементів
        int listSize = 0;
        LiIterator iterator = iterator();
        //значення змінної listSize збільшується поки існує наступний елемент
        while (iterator.hasNext()) {
            iterator.next();
            listSize++;
        }
        return listSize;
    }

    int compare(String address, LinkedList<String> lst) {
        for (int i = 0; i < size(); i++) {
            //якщо адреси співпадають
            if (lst.findByIndex(i).equals(address)) {
                return i;
            }
        }
        return -1;
    }

}
