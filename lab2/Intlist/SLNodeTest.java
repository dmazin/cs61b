import static org.junit.Assert.*;

import org.junit.Test;

public class SLNodeTest {

    /**
     * Example test that verifies correctness of the SLNode.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        SLNode one = new SLNode(1, null);
        SLNode twoOne = new SLNode(2, one);
        SLNode threeTwoOne = new SLNode(3, twoOne);

        SLNode x = SLNode.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        SLNode L = SLNode.of(1, 2, 3);
        SLNode.dSquareList(L);
        assertEquals(SLNode.of(1, 4, 9), L);
    }

    @Test
    public void testSize() {
        SLNode L = SLNode.of(1, 2, 3);
        int size = L.size();
        assertEquals(3, size);
    }

    @Test
    public void testSizeIterative() {
        SLNode L = SLNode.of(1, 2, 3);
        int size = L.sizeIterative();
        assertEquals(3, size);
    }

    @Test
    public void getTest() {
        SLNode L = SLNode.of(1, 2, 3);
        int gotten = L.get(1);
        assertEquals(2, gotten);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy SLNode.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty of, which
     * can be instantiated, for example, with
     * SLNode empty = SLNode.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        SLNode L = SLNode.of(1, 2, 3);
        SLNode res = SLNode.squareListRecursive(L);
        assertEquals(SLNode.of(1, 2, 3), L);
        assertEquals(SLNode.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        SLNode A = SLNode.of(1, 2, 3);
        SLNode B = SLNode.of(4, 5, 6);
        SLNode exp = SLNode.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, SLNode.dcatenate(A, B));
        assertEquals(SLNode.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        SLNode A = SLNode.of(1, 2, 3);
        SLNode B = SLNode.of(4, 5, 6);
        SLNode exp = SLNode.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, SLNode.catenate(A, B));
        assertEquals(SLNode.of(1, 2, 3), A);
    }

}
