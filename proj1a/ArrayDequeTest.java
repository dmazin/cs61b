import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void testEmptySize() {
        ArrayDeque L = new ArrayDeque();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        ArrayDeque L = new ArrayDeque();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }


    @Test
    public void testAddAndGetLast() {
        ArrayDeque L = new ArrayDeque();
        L.addLast(99);
        assertEquals(99, L.getLast());
        L.addLast(36);
        assertEquals(36, L.getLast());
    }


    @Test
    public void testGet() {
        ArrayDeque L = new ArrayDeque();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        assertEquals(36, L.get(1));
    }


    @Test
    public void testRemove() {
        ArrayDeque L = new ArrayDeque();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        L.removeLast();
        assertEquals(99, L.getLast());
        L.addLast(100);
        assertEquals(100, L.getLast());
        assertEquals(2, L.size());
    }

    /** Resizing up when both addFirst and addLast have been called */
    @Test
    public void testResizeUpNormal() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 8;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }
        for (int i = 0; i < N; i += 1) {
            L.addFirst(i);
        }
        assertEquals(16, L.size());
    }

    public void testResizeDownNormal() {

    }

    public void testResizeUpNoAddFirst() {

    }

    public void testResizeDownNoAddFirst() {

    }

    public void testResizeUpNoAddLast() {

    }

    public void testResizeDownNoAddLast() {

    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        int N = 100;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }

        for (int i = 0; i < (N * 1.5); i += 1) {
            L.removeLast();
        }
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
} 