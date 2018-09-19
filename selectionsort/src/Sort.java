public class Sort {
    public static void sort(String[] input) {
        sort(input, 0);
    }

    public static void sort(String[] input, int startIndex) {
        if (startIndex == input.length) {
            return;
        }

        int smallestIndex = findSmallest(input, startIndex);
        swap(input, smallestIndex, startIndex);

        sort(input, startIndex + 1);
    }

    public static int findSmallest(String[] input, int startIndex) {
        int smallestIndex = startIndex;

        for (int i = startIndex + 1; i < input.length; i++) {
            if (input[i].compareTo(input[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
