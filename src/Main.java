import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        Graph graph = new Graph();
        tree.add("client1", "street 2");
        tree.add("client2", "street 6");

        LinkedList<String> storeAddress = new LinkedList<>();
        storeAddress.addFirst("street4");
        storeAddress.addFirst("street6");

        graph.addVert("street1");//0
        graph.addVert("street2");//1
        graph.addVert("street3");//2
        graph.addVert("street4");//3
        graph.addVert("street5");//4
        graph.addVert("street6");//5
        graph.addVert("street7");//6

        graph.addEdge(0, 6);
        graph.addEdge(0, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 1);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(1, 3);
        graph.addEdge(5, 0);
        graph.addEdge(6, 1);

//        client.displayTree();
        System.out.println("Будь ласка, введіть ім'я клієнта");
        String clientName = scanner.nextLine();
        System.out.println("Ви ввели ім'я " + clientName);
        TreeNode found = tree.findClient(clientName);
        if (found != null) {
            System.out.println("Пошук успішний!");
            found.printNode();
            storeAddress.display();

//            //з дерева отримуєсо вулицю клієнта і магазину
//            String clientAddress = found.getAddress(0);
//            String storeAddress = found.getAddress(1);
//            //виводимо ці вулиці
//            System.out.println(clientAddress);
//            System.out.println(storeAddress);
//
//            int clientIndex = graph.findInGraph(clientAddress);
//            int storeIndex = graph.findInGraph(storeAddress);
//            System.out.println(clientIndex);
//            System.out.println(storeIndex);



        } else {
            System.out.println("Такого клієнта не знайдено.");
        }
    }
}
