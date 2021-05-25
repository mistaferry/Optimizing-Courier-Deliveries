public class Stack {
    int size = 10;
    int[] stack;
    int top;

    public Stack(){
        stack = new int[size];
        top = -1;
    }

    //додаємо елемент і стек
    public void push(int i){
        stack[++top] = i;
    }

    //видаляємо елемент із стеку
    public int pop(){
        return stack[top--];
    }

    //вершина стеку
    public int peek(){
        return stack[top];
    }

    //перевірка чи стек пустий
    public boolean isEmpty(){
        return (top == -1);
    }
}
