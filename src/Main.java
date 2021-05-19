import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        Graph graph = new Graph();
        tree.add("client1", "street1");

        LinkedList<String> storeAddress = new LinkedList<>();
        storeAddress.addFirst("street2");
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
        graph.addEdge(1, 4);
        graph.addEdge(6, 4);
        graph.addEdge(2, 5);


        System.out.println("Будь ласка, введіть ім'я клієнта");
        String clientName = scanner.nextLine();
        System.out.println("Ви ввели ім'я " + clientName);
        TreeNode found = tree.findClient(clientName);
        if (found != null) {
            System.out.println("Пошук успішний!");
            found.printNode();
            String clientAddress = found.getAddress();
            System.out.println();

            System.out.println("Використовуємо BFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int path = graph.BFS(clientAddress, storeAddress);
            if(path != -1){
                System.out.println();
                System.out.println("Магазин успішно знайдено!");
                System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(path));
            }else{
                System.out.println("Магазин не знайдено!");
            }
        } else {
            System.out.println("Такого клієнта не знайдено.");
        }
    }
}
