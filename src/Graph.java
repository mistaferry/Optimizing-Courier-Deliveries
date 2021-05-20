public class Graph {


    public static class Vertex {
        public String mark;
        public boolean wasVisited;

        public Vertex(String marker) {
            mark = marker;
            wasVisited = false;
        }
    }

    final int size = 10; //розмір масиву
    Vertex[] vertexList; //масив вершин
    int[][] matrix; //матриця суміжності
    int nVertex; //поточна к-ть вершин
    Stack theStack; //стек для DFS
    Queue theQueue; //стек для BFS


    public Graph() {
        vertexList = new Vertex[size]; //список вершин
        matrix = new int[size][size]; //матриця сум.
        nVertex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //заповнюємо нулями
                matrix[i][j] = 0;
            }
        }
        theStack = new Stack();
        theQueue = new Queue();
    }

    public void addVert(String marker) {
        vertexList[nVertex++] = new Vertex(marker);

    }

    public void addEdge(int start, int finish) {
        matrix[start][finish] = 1;
    }


    public void displayVertex(int i) {
        System.out.print(""+vertexList[i].mark+"\t");
    }

//    public int findInGraph(String address) {
//        int index = 0;
//        while (vertexList[index].mark != null) {
//            if (address.compareTo(vertexList[index].mark) == 0) {
//                return index;
//            } else {
//                index++;
//            }
//        }
//        if (vertexList[index].mark == null) {
//            System.out.println("Такого адресу не знайдено!\n");
//        }
//        return -1;
//    }

    String getMark(int index){
        return vertexList[index].mark;
    }

    int getIndexByMark(String start_node){
        int i = 0;
        while(i < nVertex){
            if(getMark(i).equals(start_node)){
                return i;
            }
            i++;
        }
        return -1;
    }


    int getAdjUnvisitedVertex(int vertex){
        for (int i = 0; i < nVertex; i++) {
            if((matrix[vertex][i] == 1) && (!vertexList[i].wasVisited)){
                return i;
            }
        }
        return -1;
    }

    int BFS(String start_node, LinkedList<String> lst) {

        int indexStart = getIndexByMark(start_node);

        vertexList[indexStart].wasVisited = true; //клієнт = true
        displayVertex(indexStart); //вивід вершини
        theQueue.insert(indexStart); //вставка в чергу
        int v2;

        while(! theQueue.isEmpty() ) { // пока черга не пуста
            int v1 = theQueue.remove();// извлечь первый элемент в очереди


            while((v2 = getAdjUnvisitedVertex(v1)) != -1){

                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
                if(lst.compare(getMark(v2),lst) != -1){
                    for (int i = 0; i < nVertex; i++) {
                        vertexList[i].wasVisited = false;
                    }
                    while (!theQueue.isEmpty()){
                         theQueue.remove();
                    }
                    return lst.compare(getMark(v2),lst);
                }
            }
        }
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
        while (!theQueue.isEmpty()){
            theQueue.remove();
        }
        return indexStart;
    }

    int DFS(String start_node, LinkedList<String> lst) {

        int indexStart = getIndexByMark(start_node);

        vertexList[indexStart].wasVisited = true; //клієнт = true
        displayVertex(indexStart); //вивід вершини
        theStack.push(indexStart); //вставка в стек

        while(! theStack.isEmpty() ) { // пока черга не пуста
            int v = getAdjUnvisitedVertex(theStack.peek()); //отримуємо зміжну вершину

            if(v == -1){
                theStack.pop();
            }else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
                if(lst.compare(getMark(v),lst) != -1){
                    for (int i = 0; i < nVertex; i++) {
                        vertexList[i].wasVisited = false;
                    }
                    while (!theStack.isEmpty()){
                        theStack.pop();
                    }
                    return lst.compare(getMark(v),lst);
                }
            }
        }
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
        return indexStart;
    }

    void rowUp(int row, int n) {
        for(int column =0; column<n; column++) {
            matrix[row][column] = matrix[row + 1][column];
        }
    }

    void columnLeft(int column, int n) {
        for(int row=0; row<n; row++) {
            matrix[row][column] = matrix[row][column + 1];
        }
    }

    void deleteVertex(String address){
        int index = getIndexByMark(address);
        if(index != nVertex - 1){
            for (int i = index; i < nVertex-1; i++) {
                vertexList[i] = vertexList[i+1];
            }
            for (int row = index; row < nVertex-1; row++) {
                rowUp(row, nVertex);
            }
            for (int column = index; column < nVertex-1; column++) {
                columnLeft(column, nVertex-1);
            }
        }
        nVertex--;
    }


}
