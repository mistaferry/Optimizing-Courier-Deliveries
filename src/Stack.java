public class Stack {
    int size = 10;
    int[] stack;
    int top;

    public Stack(){
        stack = new int[size];
        top = -1;
    }

    public void push(int i){
        stack[top++] = i;
    }

    public int pop(){
        return stack[top--];
    }

    public int top(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }
}
