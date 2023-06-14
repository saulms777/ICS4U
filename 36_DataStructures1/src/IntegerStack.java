import java.util.EmptyStackException;

public class IntegerStack {

    private final int[] data;
    private int top = 0;

    public IntegerStack() {
        data = new int[5];
    }

    public IntegerStack(int[] data) {
        this.data = data;
    }

    public IntegerStack(int size) {
        data = new int[size];
    }

    public int top() {
        if (isEmpty()) throw new EmptyStackException();
        return data[top - 1];
    }

    public void push(int n) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("stack is full");
        data[top++] = n;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data[--top];
    }

    public int size() {
        return top;
    }

    public void clear() {
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == data.length;
    }

}
