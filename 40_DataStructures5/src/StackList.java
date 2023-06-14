import java.util.*;

public class StackList<T> {

    private final LinkedList<T> list = new LinkedList<>();

    public StackList() {}

    public StackList(Collection<? extends T> c) {
        list.addAll(c);
    }

    public StackList(T[] arr) {
        list.addAll(Arrays.asList(arr));
    }

    public void push(T element) {
        list.addFirst(element);
    }

    public T pop() {
        return list.pop();
    }

    public T top() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (final T item : list)
            sj.add(item.toString());
        return sj.toString();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
