import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        Graph graph = new Graph();
        client.add("Олександра", new String[]{"вул. Солом’янська, 79", "пл. Володимирська, 95"});
        client.add("Роман", new String[]{"вул. Тараса Шевченка, 68", "вул. Хрещатик, 96"});
        graph.addVert("вул. Солом’янська, 79");//0
        graph.addVert("Короленка");//1
        graph.addVert("вул. Тараса Шевченка, 68");//2
        graph.addVert("карано");//3
        graph.addVert("пл. Володимирська, 95");//4
        graph.addVert("іувапіуп");//5
        graph.addVert("вул. Хрещатик, 96");//6

        graph.addEdge(0,6);
        graph.addEdge(0,4);
        graph.addEdge(4,2);
        graph.addEdge(2,1);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(1,3);
        graph.addEdge(5,0);
        graph.addEdge(6,1);



//        client.displayTree();
        System.out.println("Будь ласка, введіть ім'я клієнта");
        String clientName = scanner.nextLine();
        System.out.println("Ви ввели ім'я "+ clientName);
        ClientNode found = client.findClient(clientName);
        if (found != null) {
            System.out.println("Пошук успішний!");
            found.printNode();
            String clientAddress = found.getAddress(0);
            String storeAddress = found.getAddress(1);
            int clientIndex = graph.findAddress(clientAddress);
            int storeIndex = graph.findAddress(storeAddress);

        }else{
            System.out.println("Клієнта з таким іменем не знайдено.");
        }
    }
}
