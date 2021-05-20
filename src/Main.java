import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree(); //key - клієнт, data - його вулиця
        Graph graph = new Graph();
        WeightGraph weightgraph = new WeightGraph();



        try {
            File address = new File("src/Address");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(address);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String string = reader.readLine();
            while (string != null) {
                // считываем остальные строки в цикле
                graph.addVert(string);
                weightgraph.addVert(string);
                string = reader.readLine();
            }

            File clients = new File("src/Clients");
            fr = new FileReader(clients);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            reader = new BufferedReader(fr);
            // считаем сначала первую строку
            string = reader.readLine();
            int index = 0;
            while (string != null) {
                // считываем остальные строки в цикле
                tree.add(string, graph.getMark(index));
                index += 2;
                string = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedList<String> storeAddress = new LinkedList<>();
        storeAddress.addFirst(graph.getMark(1));
        storeAddress.addFirst(graph.getMark(5));

        graph.addEdge(0, 6);
        graph.addEdge(0, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 1);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(1, 3);
        graph.addEdge(5, 0);
        graph.addEdge(6, 1);
        graph.addEdge(1, 4);
        graph.addEdge(6, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);

        weightgraph.addEdge(0, 6, 30);
        weightgraph.addEdge(0, 4, 47);
        weightgraph.addEdge(4, 2, 20);
        weightgraph.addEdge(2, 1, 100);
        weightgraph.addEdge(3, 5, 90);
        weightgraph.addEdge(4, 3, 25);
        weightgraph.addEdge(1, 3, 46);
        weightgraph.addEdge(5, 0, 88);
        weightgraph.addEdge(6, 1, 69);
        weightgraph.addEdge(1, 4, 12);
        weightgraph.addEdge(6, 4, 30);
        weightgraph.addEdge(2, 5, 10);
        weightgraph.addEdge(2, 3, 23);


        System.out.println("Будь ласка, введіть ім'я клієнта");
        Scanner scanner = new Scanner(System.in);
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
            weightgraph.distance(clientAddress, storeAddress);

            System.out.println();

            String delete1 = "street4";
            String delete2 = "street7";
            graph.deleteVertex(delete1);
            graph.deleteVertex(delete2);
            weightgraph.deleteVertex(delete1);
            weightgraph.deleteVertex(delete2);
            System.out.println("Перераховуємо шляхи після видалення "+delete1+", "+delete2);
            System.out.println();


            System.out.println("Використовуємо BFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int pathBfs1 = graph.BFS(clientAddress, storeAddress);
            System.out.println();
            if (pathBfs1 != -1) {
                System.out.println("Магазин успішно знайдено!");
                System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathBfs1));
            }else{
                System.out.println("Шляху немає!");
            }
            System.out.println();
            System.out.println("Використовуємо DFS");
            System.out.println("Шлях від клієнта до найближчого магазину");
            int pathDfs1 = graph.DFS(clientAddress, storeAddress);
            System.out.println();
            if(pathBfs1 != -1) {
                System.out.println("Магазин успішно знайдено!");
                System.out.println("Адрес найближчого магазину - " + storeAddress.findByIndex(pathDfs1));
            }else{

                System.out.println("Шляху немає!");
            }
            System.out.println();
            System.out.println("Використовуємо Алгоритм Дейкстрі");
            System.out.println("Шукаємо найкоротший шлях від клієнта на магазину ");
            weightgraph.distance(clientAddress, storeAddress);

        } else {
            System.out.println("Такого клієнта не знайдено.");
        }
    }
}

