public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private static int RFACTOR = 2;
    private static double MINUTILIZATION = 0.25;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getFirstIndex() {
        return (nextFirst + 1) % items.length;
    }

    private int getLastIndex() {
        return (nextLast - 1) % items.length;
    }

    private void resize() {
        T[] newArray = (T []) new Object[size * RFACTOR];
        int sizeFromFToEnd = items.length - getFirstIndex();
        // sizeFromFToEnd == size when getFirstIndex = 0 and getLastIndex = items.length - 1, so this works even
        // for resizing up
        int numFirstItemsCopied = Math.min(sizeFromFToEnd, size);
        System.arraycopy(items, getFirstIndex(), newArray, 0, numFirstItemsCopied);
        System.arraycopy(items, 0, newArray, numFirstItemsCopied, size - numFirstItemsCopied);
        items = newArray;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T first0) {
        resizeIfNecessary();

        items[nextFirst] = first0;
        nextFirst = (nextFirst - 1) % items.length;
        size += 1;
    }

    public void addLast(T last0) {
        resizeIfNecessary();

        items[nextLast] = last0;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public T get(int index) {
        return items[index];
    }

    public T getFirst() {
        return items[getFirstIndex()];
    }

    public T getLast() {
        return items[getLastIndex()];
    }

    private void resizeIfNecessary() {
        if (size == items.length || (items.length > 16 && (double) size / items.length < MINUTILIZATION)) {
            resize();
        }
    }

    public T removeLast() {
        T last = getLast();

        nextLast = (nextLast - 1) % items.length;
        size -= 1;

        resizeIfNecessary();

        return last;
    }

    public T removeFirst() {
        T first = getFirst();

        nextFirst = (nextFirst + 1) % items.length;
        size -= 1;

        resizeIfNecessary();

        return first;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int idxToPrint = (getFirstIndex() + i) % items.length;
            System.out.print(items[idxToPrint] + ",");
        }
    }
}
