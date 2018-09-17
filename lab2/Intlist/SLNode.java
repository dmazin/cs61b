import java.util.Formatter;

/**
 * A naked recursive list of integers, similar to what we saw in lecture 3, but
 * with a large number of additional methods.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class SLNode {
    /**
     * First element of list.
     */
    public int first;
    /**
     * Remaining elements of list.
     */
    public SLNode rest;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public SLNode(int first0, SLNode rest0) {
        first = first0;
        rest = rest0;
    }

    public void addFirst(int intToAdd) {
        int oldFirst = first;
        first = intToAdd;
        rest = new SLNode(oldFirst, rest);
    }

    /**
     * A List with null rest, and first = 0.
     */
    public SLNode() {
    /* NOTE: public SLNode () { }  would also work. */
        this(0, null);
    }

    public int size() {
        if (rest == null) {
            return 1;
        } else {
            return 1 + rest.size();
        }
    }

    public int sizeIterative() {
        int accumulator = 1;

        SLNode list = rest;
        while (list != null) {
            accumulator = accumulator + 1;
            list = list.rest;
        }

        return accumulator;
    }

    public int get(int index) {
        if (index == 0) {
            return first;
        }

        return rest.get(index - 1);
    }

    /**
     * Returns a list equal to L with all elements squared. Destructive.
     */
    public static void dSquareList(SLNode L) {

        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static SLNode squareListIterative(SLNode L) {
        if (L == null) {
            return null;
        }
        SLNode res = new SLNode(L.first * L.first, null);
        SLNode ptr = res;
        L = L.rest;
        while (L != null) {
            ptr.rest = new SLNode(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return res;
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static SLNode squareListRecursive(SLNode L) {
        if (L == null) {
            return null;
        }
        return new SLNode(L.first * L.first, squareListRecursive(L.rest));
    }

    /** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */


    /**
     * Returns a list consisting of the elements of A followed by the
     * *  elements of B.  May modify items of A. Don't use 'new'.
     */

    public static SLNode dcatenate(SLNode A, SLNode B) {
        //TODO:  fill in method
        return null;
    }

    /**
     * Returns a list consisting of the elements of A followed by the
     * * elements of B.  May NOT modify items of A.  Use 'new'.
     */
    public static SLNode catenate(SLNode A, SLNode B) {
        //TODO:  fill in method
        return null;
    }
















    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return first;
    }

    /**
     * Returns a new SLNode containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static SLNode of(Integer... args) {
        SLNode result, p;

        if (args.length > 0) {
            result = new SLNode(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new SLNode(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an SLNode containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof SLNode)) {
            return false;
        }
        SLNode L = (SLNode) x;
        SLNode p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the SLNode, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an SLNode into a String and that SLNode has a loop, your computer
     * doesn't get stuck in an infinite loop.
     */

    private int detectCycles(SLNode A) {
        SLNode tortoise = A;
        SLNode hare = A;

        if (A == null) {
            return 0;
        }

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null) {
                hare = hare.rest.rest;
            } else {
                return 0;
            }

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    @Override
    /** Outputs the SLNode as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (SLNode p = this; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }
}

