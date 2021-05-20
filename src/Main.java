import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        Graph graph = new Graph();
        WeightGraph weightgraph = new WeightGraph();

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

        weightgraph.addVert("street1");//0
        weightgraph.addVert("street2");//1
        weightgraph.addVert("street3");//2
        weightgraph.addVert("street4");//3
        weightgraph.addVert("street5");//4
        weightgraph.addVert("street6");//5
        weightgraph.addVert("street7");//6

        weightgraph.addEdge(0, 6, 30);
        weightgraph.addEdge(0, 4, 47);
        weightgraph.addEdge(4, 2, 20);
        weightgraph.addEdge(2, 1, 100);
        weightgraph.addEdge(3, 5, 90);
        weightgraph.addEdge(3, 4, 25);
        weightgraph.addEdge(1, 3, 46);
        weightgraph.addEdge(5, 0, 88);
        weightgraph.addEdge(6, 1, 69);
        weightgraph.addEdge(1, 4, 12);
        weightgraph.addEdge(6, 4, 30);
        weightgraph.addEdge(2, 5, 10);


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
            int pathBfs = graph.BFS(clientAddress, storeAddress);
            System.out.println();
            System.out.println("Магазин успішно знайдено!");
            System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathBfs));
            System.out.println();
            System.out.println("Використовуємо DFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int pathDfs = graph.DFS(clientAddress, storeAddress);
            System.out.println();
            System.out.println("Магазин успішно знайдено!");
            System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathDfs));
            System.out.println();
            System.out.println("Використовуємо Алгоритм Дейкстрі");
            System.out.println("Шукаємо найкоротший шлях від клієнта на магазину ");
            int f = weightgraph.distance(clientAddress, storeAddress);
            System.out.println("Мінімальною відстань буде до магазину за адресом  - " + storeAddress.findByIndex(f));


            graph.deleteVertex("street3");
            weightgraph.deleteVertex("street7");


            System.out.println("Використовуємо BFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int pathBfs1 = graph.BFS(clientAddress, storeAddress);
            System.out.println();
            System.out.println("Магазин успішно знайдено!");
            System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathBfs1));
            System.out.println();
            System.out.println("Використовуємо DFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int pathDfs1 = graph.DFS(clientAddress, storeAddress);
            System.out.println();
            System.out.println("Магазин успішно знайдено!");
            System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathDfs1));
            System.out.println();
            System.out.println("Використовуємо Алгоритм Дейкстрі");
            System.out.println("Шукаємо найкоротший шлях від клієнта на магазину ");
            f = weightgraph.distance(clientAddress, storeAddress);
            System.out.println("Мінімальною відстань буде до магазину за адресом  - " + storeAddress.findByIndex(f));

        } else {
            System.out.println("Такого клієнта не знайдено.");
        }
    }
}

