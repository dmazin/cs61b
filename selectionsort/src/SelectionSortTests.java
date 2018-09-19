import org.junit.Test;
import static org.junit.Assert.*;


public class SelectionSortTests {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int smallest = Sort.findSmallest(input, 0);

        assertEquals(expected, smallest);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"i", "an", "have", "egg"};

        int a = 1;
        int b = 2;

        Sort.swap(input, a, b);

        assertArrayEquals(expected, input);
    }
}
