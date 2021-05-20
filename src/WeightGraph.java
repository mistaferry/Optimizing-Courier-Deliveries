public class WeightGraph {
    public static class DistPar {
        int distance;
        int parentV;

        public DistPar(int dist, int parent) {
            distance = dist;
            parentV = parent;
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
    DistPar[] sPath; //масив коротких шляхів
    int currVert; //поточна вершина вершина
    int length; //відстань від поч. до кінц. вершини


    public WeightGraph() {
        vertexList = new Vertex[size]; //список вершин
        matrix = new int[size][size]; //матриця сум.
        nVertex = 0;
        nTree = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = infinity;
            }
        }
        sPath = new DistPar[size];
    }

    public void addVert(String marker) {
        vertexList[nVertex++] = new Vertex(marker);
    }

    public void addEdge(int start, int finish, int weight) {
        matrix[start][finish] = weight;
    }


    public void displayVertex(int i) {
        System.out.print("" + vertexList[i].mark + "\t");
    }

    String getMark(int index) {
        return vertexList[index].mark;
    }

    int getIndexByMark(String start_node) {
        int i = 0;
        while (i < nVertex) {
            if (getMark(i).equals(start_node)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int minLength() // Поиск в sPath элемента
    { // с наименьшим расстоянием
        int minDist = infinity; // Исходный высокий "минимум"
        int min = 0;
        for (int j = 1; j < nVertex; j++) // Для каждой вершины
        { // Если она не включена в дерево
            if (!vertexList[j].inTree && // и ее расстояние меньше
                    sPath[j].distance < minDist) // старого минимума
            {
                minDist = sPath[j].distance;
                min = j; // Обновление минимума
            }
        }
        return min; // Метод возвращает индекс
    }

    public void adjust_sPath() {
// Обновление данных в массиве кратчайших путей sPath
        int column = 1; // Начальная вершина пропускается
        while (column < nVertex) // Перебор столбцов
        {
// Если вершина column уже включена в дерево, она пропускается
            if (vertexList[column].inTree) {
                column++;
                continue;
            }
// Вычисление расстояния для одного элемента sPath
// Получение ребра от currentVert к column
            int currentToFringe = matrix[currVert][column];
// Суммирование расстояний
            int startToFringe = length + currentToFringe;
// Определение расстояния текущего элемента sPath
            int sPathDist = sPath[column].distance;
// Сравнение расстояния от начальной вершины с элементом sPath
            if (startToFringe < sPathDist) // Если меньше,
            { // данные sPath обновляются
                sPath[column].parentV = currVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(LinkedList<String> lst) {
        int index;
        for (int j = 0; j < nVertex; j++) // display contents of sPath[]
        {
            index = lst.compare(getMark(j), lst);
            if(index != -1) {
                if (sPath[j].distance == infinity)
                    System.out.print("Шлях до " + vertexList[j].mark + " нескінченний\n"); // inf
                else
                System.out.print("До магазину за адресом - " + vertexList[j].mark + " найкоротший шлях - " + sPath[j].distance+"км.\n"); // B=

            }
        }

    }

    int distance(String start_node, LinkedList<String> lst) {
        int startTree = getIndexByMark(start_node);
        vertexList[startTree].inTree = true;
        nTree = 1;

        for (int i = 0; i < nVertex; i++) {
            int temp = matrix[startTree][i];
            sPath[i] = new DistPar(temp, startTree);
        }

        while (nTree < nVertex) {
            int indexMin = minLength();
            int minDist = sPath[indexMin].distance;

            if (minDist == infinity) {
                break;
            } else {
                currVert = indexMin;
                length = sPath[indexMin].distance;

            }

            vertexList[currVert].inTree = true;
            nTree++;
            adjust_sPath();


        }
        displayPaths( lst);
        nTree = 0;
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].inTree = false;
        }
        return  -1;
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
