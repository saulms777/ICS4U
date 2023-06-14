public class BookLinkedList {

    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void insertInOrder(Book book) {
        size++;

        if (head == null) {
            head = new Node(book);
            return;
        }

        if (book.getCost() < head.getData().getCost()) {
            Node newNode = new Node(book);
            newNode.setNext(head);
            head.setNext(newNode);
            return;
        }

        if (head.getNext() == null) {
            head.setNext(new Node(book));
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (book.getCost() > current.getNext().getData().getCost())
                current = current.getNext();
            else {
                Node newNode = new Node(book);
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                return;
            }
        }

        current.setNext(new Node(book));
    }

    public int averageYear() {
        int totalYears = 0;
        Node current = head;
        while (current != null) {
            totalYears += current.getData().getYearPublished();
            current = current.getNext();
        }
        return totalYears / size;
    }

    public int compare(BookLinkedList list) {
        Node node = head;
        Node otherNode = list.getHead();
        while (node != null && otherNode != null) {
            if (!node.getData().equals(otherNode.getData())) return -1;
            node = node.getNext();
            otherNode = otherNode.getNext();
        }
        return size - list.getSize();
    }

    public void removeLast() {
        if (head == null)
            return;
        else if (head.getNext() == null)
            head = null;
        else
            head.removeLast();
    }

    @Override
    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            str += current.getData().toString() + " ";
            current = current.getNext();
        }
        return str;
    }

    private static class Node {

        private Book data;
        private Node next;

        public Node(Book book) {
            data = book;
        }

        public Book getData() {
            return data;
        }

        public void setData(Book data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void removeLast() {
            if (next.getNext() == null)
                next = null;
            else
                next.removeLast();
        }

    }

}
