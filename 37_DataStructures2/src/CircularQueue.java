public class CircularQueue {

    int[] data;
    int front = 0;
    int back = -1;

    public CircularQueue() {
        data = new int[5];
    }

    public CircularQueue(int size) {
        data = new int[size];
    }

    public CircularQueue(int[] data) {
        this.data = data;
    }

    public void enqueue(int n) {
        if (back == -1) back = front - 1;
        else if (back < front || (front == 0 && back == data.length - 1))
            throw new ArrayIndexOutOfBoundsException("full queue");
        if (++back == data.length) back = 0;
        data[back] = n;
    }

    public int dequeue() {
        int n = data[front];
        if (++front == data.length) front = 0;
        if (front > back || (front == 0 && back == data.length - 1)) back = -1;
        return n;
    }

    public int front() {
        return data[front];
    }

    public int size() {
        return (data.length + back - front) % data.length + 1;
    }

    public void clear() {
        front = 0;
        back = -1;
    }

    @Override
    public String toString() {
        if (back == -1) return "Empty queue";
        StringBuilder s = new StringBuilder("Queue: ");
        for (int i = front; i <= back; i = (i + 1) % data.length)
            s.append(data[i]).append(" ");
        return s.toString();
    }

}
