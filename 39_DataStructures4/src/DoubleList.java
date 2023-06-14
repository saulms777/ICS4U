public class DoubleList extends LinkedList<Double> {

    public double sum() {
        return stream().mapToDouble(Double::doubleValue).sum();
    }

    public boolean isIncreasingOrder() {
        double previous = head.data;
        for (final double item : this) {
            if (previous > item) return false;
            else previous = item;
        }
        return true;
    }

    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (get(j) > get(j + 1)) {
                    double temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) return;
        }
    }

}
