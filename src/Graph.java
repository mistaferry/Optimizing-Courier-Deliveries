public class Graph {
    public static class Vertex {
        public String mark;
        public boolean wasVisited;

        public Vertex(String marker) {
            mark = marker;
            wasVisited = false;
        }
    }

    final int amount = 10;
    AddressList<String> vertexList = new AddressList<>(); // Список вершин
    int[][] matrix; // Матрица смежности
    int nVertex; // Текущее количество вершин
    Stack stack;
//    public char sortedArray[];

    public Graph() {
        matrix = new int[amount][amount];
        nVertex = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                matrix[i][j] = 0;
            }
        }
        stack = new Stack();
    }

    public void addVert(String marker) {
        vertexList.addFirst(marker);
    }

    public void addEdge(int start, int finish) {
        matrix[start][finish] = 1;
    }

    public int findAddress(String marker) {
        int index = 0;
        while (marker.compareTo(vertexList.findByIndex(index)) != 0) {
            index++;
        }
        if(marker.compareTo(vertexList.findByIndex(index)) == 0){
            return index;
        }
        return -1;
    }

    public void dfs(int start, int end){
        int length = 0;
        vertexList.index(length).;
    }
}
