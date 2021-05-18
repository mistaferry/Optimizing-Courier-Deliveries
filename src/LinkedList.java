import java.util.Iterator;

public class LinkedList<String> {

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

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
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

    //показує всі елементи, які присутні в списку
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Список пустий");
        } else {
            //друк кожного елемента, збільшуючи вказівник
            System.out.println("Список адрес магазинів");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
                System.out.println("");
            }
        }
    }

    public String findByIndex(int index) {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i<index; i++) {
                current = current.next;
            }
            return current.getData();
        }
        return null;
    }

    public void index(int index) {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i<index; i++) {
                current = current.next;
            }
        }
    }
    
    public boolean wasVisited(int index){
        Node current = head;
        boolean wasVisited = false;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return true;
    }

//    public LiIterator iterator() {
//    }

    public int size() {
        //к-ть елементів
        int listSize = 0;
        Iterator<String> iterator = new Iterator<>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
        //значення змінної listSize збільшується поки існує наступний елемент
        while (iterator.hasNext()) {
            iterator.next();
            listSize++;
        }
        return listSize;
    }


}
