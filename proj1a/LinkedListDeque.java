public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node next;
        private Node previous;

        public Node(T item0, Node next0, Node previous0) {
            item = item0;
            next = next0;
            previous = previous0;
        }
    }

    private Node sentinel;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    public T get(int index) {
        Node node = sentinel;

        for (int i = 0; i <= index; i++) {
            node = node.next;
        }

        return node.item;
    }

    private Node getRecursiveHelper(Node node, int i) {
        if (i == 0) {
            return node;
        }

        return getRecursiveHelper(node.next, i - 1);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index).item;
    }

    public void addFirst(T item0) {
        size += 1;

        Node currentFirst = sentinel.next;
        currentFirst.previous = new Node(item0, currentFirst, sentinel);
        sentinel.next = currentFirst.previous;
    }

    public void addLast(T item0) {
        size += 1;

        Node currentLast = sentinel.previous;
        currentLast.next = new Node(item0, sentinel, currentLast);
        sentinel.previous = currentLast.next;
    }

    public T removeFirst() {
        Node first = sentinel.next;

        sentinel.next = first.next;
        first.next.previous = first.previous;

        if (size > 0) {
            size -= 1;
        }

        return first.item;
    }

    public T removeLast() {
        Node last = sentinel.previous;

        sentinel.previous = last.previous;
        last.previous.next = last.next;

        if (size > 0) {
            size -= 1;
        }

        return last.item;
    }

    public void printDeque() {
        Node node = sentinel;

        for (int i = 1; i <= size; i++) {
            node = node.next;
            System.out.print(node.item + ",");
        }
    }
}