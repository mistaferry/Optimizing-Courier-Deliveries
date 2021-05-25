public class Graph {

    //клас для вершини
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
    Stack stack; //стек для DFS
    Queue queue; //стек для BFS


    //конструктор
    public Graph() {
        vertexList = new Vertex[size]; //список вершин
        matrix = new int[size][size]; //матриця сум.
        nVertex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //заповнюємо нулями матрицю суміжності
                matrix[i][j] = 0;
            }
        }
        stack = new Stack();
        queue = new Queue();
    }

    //додаємо вершину, передається в метод мітка
    public void addVert(String marker) {
        vertexList[nVertex++] = new Vertex(marker);
    }

    //додаємо ребра, вказуємо напрям
    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
    }

    //вивід вмісту вершини
    public void displayVertex(int index) {
        System.out.print("" + vertexList[index].mark + "\t");
    }


    //за допомогою індекса, повертаємо аргумент вершини
    String getMark(int index) {
        return vertexList[index].mark;
    }

    //за допомогою адреса, отримуємо його індекс
    int getIndexByMark(String startNode) {
        int i = 0;
        while (i < nVertex) {
            //якщо адреси співпадають
            if (getMark(i).equals(startNode)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    //отримуємо суміжну, невідвідувану до заданої, вершину
    int unvisitedNeigh(int v) {
        for (int i = 0; i < nVertex; i++) {
            if ((matrix[v][i] == 1) && (!vertexList[i].wasVisited)) {
                return i;
            }
        }
        return -1;
    }

    //пошук в ширину
    int BFS(String startNode, LinkedList<String> list) {
        //отримуємо індекс вершини, з якої будемо починати пошук
        int indexStart = getIndexByMark(startNode);

        vertexList[indexStart].wasVisited = true;   //клієнт = true
        displayVertex(indexStart);  //вивід вершини
        queue.insert(indexStart);   //вставка в чергу
        int vertex1;

        while (!queue.isEmpty()) {  //пока черга не пуста
            int vertex2 = queue.remove();   //видаляємо перший елемент з черги

            //якщо є суміжні вершини
            while ((vertex1 = unvisitedNeigh(vertex2)) != -1) {

                vertexList[vertex1].wasVisited = true;  //позначаємо як відвідувану
                displayVertex(vertex1); //виводимо вміст вершини
                queue.insert(vertex1);  //вносимо вершину в чергу

                //якщо вершина є адресом магазину, закінчуємо обхід
                //ціль досягнено
                if (list.compare(getMark(vertex1), list) != -1) {
                    //позначаємо всі вершини невідвідуваними
                    for (int i = 0; i < nVertex; i++) {
                        vertexList[i].wasVisited = false;
                    }
                    //очищаємо чергу
                    while (!queue.isEmpty()) {
                        queue.remove();
                    }
                    //повертаємо індекс кінцевої адреси
                    return list.compare(getMark(vertex1), list);
                }
            }
        }
        //посначаємо всі вершини невідвідуваними
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
        //очищаємо чергу
        while (!queue.isEmpty()) {
            queue.remove();
        }

        //якщо адреси магазину не знайдено
        return -1;
    }

    //пошук в глибину
    int DFS(String startNode, LinkedList<String> list) {
        //отримуємо індекс вершини, з якої будемо починати пошук
        int indexStart = getIndexByMark(startNode);

        vertexList[indexStart].wasVisited = true;   //клієнт = true
        displayVertex(indexStart);  //вивід вершини
        stack.push(indexStart); //вставка в стек

        while (!stack.isEmpty()) { //пока черга не пуста
            int v = unvisitedNeigh(stack.peek());   //отримуємо суміжну вершину

            if (v == -1) {
                stack.pop();    //видаляємо зі стека
            } else {
                vertexList[v].wasVisited = true;    //позначаємо як відвідувану
                displayVertex(v);   //виводимо зміст вершини
                stack.push(v);  //вносимо вершину в стек

                //якщо вершина є адресом магазину, закінчуємо обхід
                //ціль досягнено
                if (list.compare(getMark(v), list) != -1) {
                    //позначаємо всі вершини невідвідуваними
                    for (int i = 0; i < nVertex; i++) {
                        vertexList[i].wasVisited = false;
                    }
                    //очищаємо стек
                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    //повертаємо індекс кінцевої адреси
                    return list.compare(getMark(v), list);
                }
            }
        }

        //позначаємо всі вершини невідвідуваними
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
        //очищаємо стек
        while (!stack.isEmpty()) {
            stack.pop();
        }

        //якщо адреси магазину не знайдено
        return -1;
    }

    public void deleting(int start, int end) {
        matrix[start][end] = 0;
    }

}
