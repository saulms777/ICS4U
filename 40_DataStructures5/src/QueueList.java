import java.util.*;

public class QueueList<T> {

    private final LinkedList<T> queue = new LinkedList<>();

    public QueueList() {}

    public QueueList(Collection<? extends T> c) {
        queue.addAll(c);
    }

    public QueueList(T[] arr) {
        queue.addAll(Arrays.asList(arr));
    }

    public void enqueue(T element) {
        queue.addLast(element);
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public T front() {
        return queue.getFirst();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (final T item : queue)
            sj.add(item.toString());
        return sj.toString();
    }

    public void clear() {
        queue.clear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
