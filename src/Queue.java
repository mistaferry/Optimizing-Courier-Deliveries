public class Queue {
    int size = 10;
    int[] theQueue;
    int front;
    int rear;

    public Queue(){
        theQueue = new int[size];
        front = 0;
        rear = -1;
    }

    //додаємо в чергу
    void insert(int index){
        if(rear == size -1)
            rear = -1;
        theQueue[++rear] = index;
    }

    //видаляємо елемент
    int remove(){
        int t = theQueue[front++];
        if(front == size)
            front = 0;
        return t;
    }

    //перевірка чи черга пуста
    boolean isEmpty(){
        return (rear+1 == front || (front+ size -1==rear));
    }
}
