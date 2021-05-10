public class Stack {
    int size = 10;
    int[] stack;
    int top;

    public Stack(){
        stack = new int[size];
        top = -1;
    }

    public void input(int into){
        stack[top++] = into;
    }

    public int output(){
        return stack[top--];
    }

    public int top(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }
}
