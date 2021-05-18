//import java.util.Iterator;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collection;


import java.util.Iterator;

public class Graph {
    public static class Vertex {
        public String mark;
        public boolean wasVisited;

        public Vertex(String marker) {
            mark = marker;
            wasVisited = false;
        }
    }

    public static class Distance {
        public int distance; //відстань
        public int parent; //батько вершини

        public Distance(int dist, int par) {
            distance = dist;
            parent = par;
        }
    }

//    public static class Edge{
//        public int firstVert;
//        public int endVert;
//        public int distance;
//
//        public Edge(int fVert, int eVert, int dist){
//            firstVert = fVert;
//            endVert = eVert;
//            distance= dist;
//        }
//    }

    final int amount = 10;
    final int infinity = 10000000;
    Vertex[] vertexList; // Масив вершин
    int[][] matrix; // Матрица смежности
    int nVertex; // Текущее количество вершин
    int nTree; //к-ть вершин в дереві
    Distance[] shortDist; //масив коротких шляхів
    int currVert; //тек вершина
    int length; //відстань від поч до кінц вершини
    Stack stack;
//    public char sortedArray[];

    public Graph() {
        vertexList = new Vertex[amount];
        matrix = new int[amount][amount];
        nVertex = 0;
        nVertex = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                matrix[i][j] = 0;
            }
        }
        stack = new Stack();
        shortDist = new Distance[amount];
    }

    public void addVert(String marker) {
        nVertex++;
        vertexList[nVertex] = new Vertex(marker);
    }

    public void addEdge(int start, int finish) {
        matrix[start][finish] = 1;
    }

//    public int findAddress(String marker) {
//        int index = 0;
//        while (marker.compareTo(vertexList[index].mark) != 0 && index<amount) {
//            index++;
//        }
//        if(marker.compareTo(vertexList[index].mark) == 0){
//            return index;
//        }
//        for (int i = 0; i < amount; i++) {
//            if(marker.compareTo(vertexList[i].mark) == 0){
//                return i;
//            }
//        }
//        return -1;
//    }

//    public void dfs(int start, int end){
//        //вершина зназвою вулиці клієнта, позначається, як відвідувана
//        vertexList[start].wasVisited = true;
//        //виводимо цю вершину
//        vertexPrint(start);
//        //заносимо її в стек
//        stack.push(start);
//
//        while(!vertexList[end])
//    }

    public void vertexPrint(int i) {
        System.out.print(vertexList[i].mark);
    }

    public int findInGraph(String address) {
        int index = 0;
        while (vertexList[index].mark != null) {
            if (address.compareTo(vertexList[index].mark) == 0) {
                return index;
            } else {
                index++;
            }
        }
        if (vertexList[index].mark == null) {
            System.out.println("Такого адресу не знайдено!\n");
        }
        return -1;
    }



//    void bfs(int start, int end, String startAdd, String endAd, LinkedList<String> path) {
////        if(start == end){
////            System.out.println(path);
////            return;
////        }
//        LinkedList<String> list;
//
//        //позначаємо всі вершини, невідвідуваними
//        boolean[] isVisited = new boolean[nVertex];
//
//        //створюємо чергу для bfs
//        LinkedList<String> queueList = new LinkedList<>();
//
//        //позначаємо початкову вершину, як відвідувану
//        isVisited[start] = true;
//        queueList.addFirst(startAdd);
//
//        Iterator<String> i;
//        while(queueList.size() != 0){
//            startAdd = queueList.poll();
//            int n;
//            i =
//        }
//
//            for (int j = 0; j < amount; j++) {
//                if(matrix[start][j] != 0){
//                    int adj = j;
//                    if(!vertexList[adj].wasVisited){
//                        int
//                    }
//
//                }
//            }
//
//
//        }

    void BFS(String start_node, LinkedList<String> list) {
        for(int i=0; i<nVertex; i++) {
            vertexList[i].wasVisited = false;
        } // изначально список посещённых узлов пуст
        Queue<String> queue = new LinkedList<>();

        queue.offer(start_node);              // начиная с узла-источника
        vertexList[start_node].wasVisited = true;
        while(! queue.empty() ) {            // пока очередь не пуста
            node = queue.pop();                 // извлечь первый элемент в очереди
            if(node == goal_node) {
                return true;                       // проверить, не является ли текущий узел целевым
            }
            foreach(child in expand(node)) {    // все преемники текущего узла, ...
                if(visited[child] == false) {      // ... которые ещё не были посещены ...
                    queue.push(child);                // ... добавить в конец очереди...
                    visited[child] = true;            // ... и пометить как посещённые
                }
            }
        }
        return false;                        // Целевой узел недостижим
    }


}