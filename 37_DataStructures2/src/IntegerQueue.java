import java.util.*;

public class IntegerQueue {

    int[] data;
    int back = 0;

    public IntegerQueue() {
        data = new int[4];
    }

    public IntegerQueue(int size) {
        data = new int[size];
    }

    public IntegerQueue(int[] data) {
        this.data = data;
    }

    public void enqueue(int n) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException();
        data[back++] = n;
    }

    public int dequeue() {
        if (isEmpty()) throw new EmptyStackException();
        int front = data[0];
        for (int i = 1; i < data.length; i++)
            data[i - 1] = data[i];
        return front;
    }

    public int front() {
        if (isEmpty()) throw new EmptyStackException();
        return data[0];
    }

    public int size() {
        return back;
    }

    public void clear() {
        back = 0;
    }

    public boolean isEmpty() {
        return back == 0;
    }

    public boolean isFull() {
        return back == data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(
                Arrays.stream(data)
                        .filter(num -> num != 0)
                        .toArray()
        );
    }

}
