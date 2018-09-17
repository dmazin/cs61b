public class SLList {
    public SLNode first;

    public SLList(int first0) {
        first = new SLNode(first0, null);
    }

    public void addFirst(int intToAdd) {
        first = new SLNode(intToAdd, first);
    }

    public void addLast(int intToAdd) {
        SLNode currentNode = first;
        while (currentNode.rest != null) {
            currentNode = currentNode.rest;
        }
        currentNode.rest = new SLNode(intToAdd, null);
    }

    private static int size(SLNode list) {
        if (list.rest == null) {
            return 1;
        }

        return 1 + size(list.rest);
    }

    public int size() {
        return size(first);
    }

    public int getFirst() {
        return first.first;
    }

    public static void main(String[] args) {
        SLList L = new SLList(1);
        L.addFirst(0);
        L.addFirst(-1);

        System.out.println(L.getFirst());
    }
}
