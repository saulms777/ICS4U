public class IntegerList {

    private Node head;

    public void addToFront(int num) {
        Node newNode = new Node(num);
        newNode.setNext(head);
        head.setNext(newNode);
    }

    public void addToRear(int num) {
        Node last = head;
        while (last.getNext() != null)
            last = last.getNext();
        last.setNext(new Node(num));
    }

    public void insertInOrder(int num) {
        if (head == null)
            head = new Node(num);
        else if (num < head.getData())
            addToFront(num);
        else
            head.insertInOrder(num);
    }

    public void removeLastItem() {
        if (head == null)
            return;
        else if (head.getNext() == null)
            head = null;
        else
            head.removeLastItem();
    }

    private static final class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void insertInOrder(int num) {
            if (next == null)
                next = new Node(num);
            else if (num < next.getData()) {
                Node newNode = new Node(num);
                newNode.setNext(next);
                setNext(newNode);
            } else
                next.insertInOrder(num);
        }

        public void removeLastItem() {
            if (next.getNext() == null)
                next = null;
            else
                next.removeLastItem();
        }

    }

}
