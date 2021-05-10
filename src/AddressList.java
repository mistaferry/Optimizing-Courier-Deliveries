public class AddressList<String> {

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
            System.out.println("List is empty");
        } else {
            //друк кожного елемента, збільшуючи вказівник
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
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
}
