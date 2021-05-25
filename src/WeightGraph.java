public class WeightGraph {
    public static class Distance {
        int distance;
        int parent;

        public Distance(int dist, int parent) {
            distance = dist;
            this.parent = parent;
        }
    }

    public static class Vertex {
        public String mark;
        public boolean inTree;

        public Vertex(String marker) {
            mark = marker;
            inTree = false;
        }
    }

    final int size = 10; //розмір масиву
    final int infinity = 10000000;
    Vertex[] vertexList; //масив вершин
    int[][] matrix; //матриця суміжності
    int nVertex; //поточна к-ть вершин

    int nTree; //к-ть вершин в дереві
    Distance[] shortRoute; //масив коротких шляхів
    int currentVertex; //поточна вершина вершина
    int length; //відстань від поч. до кінц. вершини


    public WeightGraph() {
        vertexList = new Vertex[size]; //список вершин
        matrix = new int[size][size]; //матриця сум.
        nVertex = 0;
        nTree = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //заповнюємо "нескінченними" числами
                matrix[i][j] = infinity;
            }
        }
        shortRoute = new Distance[size];
    }

    //додаємо вершину
    public void addVert(String marker) {
        vertexList[nVertex++] = new Vertex(marker);
    }

    //додаємо ребро
    public void addEdge(int start, int end, int weight) {
        matrix[start][end] = weight;
    }

    //отримуємо значення за індексом
    String getMark(int index) {
        return vertexList[index].mark;
    }

    //отримуємо індекс за назвою
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

    public int minLength(){ //пошук елемента з найменшою відстанню

        int minDistance = infinity; //початковий мінімум
        int minIndex = 0;
        for (int j = 1; j < nVertex; j++) { //для кожної вершини, яка не включена в дерево та її відстань менша за попередню
            if (!vertexList[j].inTree && shortRoute[j].distance < minDistance) {
                minDistance = shortRoute[j].distance;
                minIndex = j;
            }
        }
        //повертаємо індекс
        return minIndex;
    }

    public void shortPath() {
        int column = 1; //пропускаємо вершину,з якої починаємо
        while (column < nVertex){    //перебираємо стовбці
            //якщо вершина включена, вона пропускається
            if (vertexList[column].inTree) {
                column++;
                continue;
            }
            int currentToFringe = matrix[currentVertex][column]; //отримання ребра
            int startToFringe = length + currentToFringe;   //сумуємо відстані
            int sPathDist = shortRoute[column].distance;    //відстань поточного
            //порівнюємо відстань від початкової вершини є елементом
            if (startToFringe < sPathDist){
                shortRoute[column].parent = currentVertex;
                shortRoute[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(LinkedList<String> lst) {
        int index;
        for (int j = 0; j < nVertex; j++) { //виводимо зміст
            index = lst.compare(getMark(j), lst);
            //якщо вершина, на якій ми знаходимо є магазином
            if(index != -1) {
                if (shortRoute[j].distance == infinity) {
                    System.out.print("Шлях до " + vertexList[j].mark + " нескінченний\n");  //якщо шлях нескінченний
                } else {
                    System.out.print("До магазину за адресом - " + vertexList[j].mark + " найкоротший шлях - " + shortRoute[j].distance + "км.\n");
                }
            }
        }
    }

    void distance(String startNode, LinkedList<String> list) {
        //отримуємо індекс вершини, з якої будемо починати пошук
        int startTree = getIndexByMark(startNode);

        vertexList[startTree].inTree = true;    //якщо вершина включена в дерево
        nTree = 1;


        for (int i = 0; i < nVertex; i++) {
            int temp = matrix[startTree][i];
            shortRoute[i] = new Distance(temp, startTree);
        }

        while (nTree < nVertex) {
            //отримуємо індекс мінімума
            int indexMin = minLength();
            //отримуємо значення мінімума
            int minDist = shortRoute[indexMin].distance;

            //якщо мінімум = нескінченності
            if (minDist == infinity) {
                break;
            } else {
                //поверт. до ближчої вершини
                currentVertex = indexMin;
                length = shortRoute[indexMin].distance;
            }
            //включення поточної вершини в дерево
            vertexList[currentVertex].inTree = true;
            nTree++;
            shortPath();
        }
        //вивід значення
        displayPaths( list);
        nTree = 0;
        //очищення дерева
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].inTree = false;
        }
    }

    public void deleting(int start, int end) {
        matrix[start][end] = infinity;
    }
}
