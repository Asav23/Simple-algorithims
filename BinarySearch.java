import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class BinarySearch {
    
    /**
     * Performs an iterative binary search on a sorted array.
     * The method takes a generic array, an element to search for, and a comparator for ordering.
     * It repeatedly divides the search space in half until the element is found or the search space is empty.
     * Returns the index of the element if found, otherwise returns -1.
     */
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T elem, final Comparator<T> comparator) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(array[mid], elem);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }

    /**
     * Performs a recursive binary search on a sorted array.
     * This method calls a helper function that performs the actual recursive search.
     * The function takes a generic array, an element to search for, and a comparator.
     * It reduces the search space recursively until the element is found or the space is empty.
     * Returns the index of the element if found, otherwise returns -1.
     */
    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T elem, final Comparator<T> comparator) {
        return binarySearchRecursiveHelper(array, elem, comparator, 0, array.length - 1);
    }

    /**
     * Helper function for recursive binary search.
     * It takes additional parameters: left and right indices that define the search range.
     * The function continues reducing the search space by calling itself recursively until the element is found.
     * Returns the index of the element if found, otherwise returns -1.
     */
    private static <T extends Comparable<T>> int binarySearchRecursiveHelper(final T[] array, final T elem, final Comparator<T> comparator, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        int cmp = comparator.compare(array[mid], elem);
        if (cmp == 0) return mid;
        if (cmp < 0) return binarySearchRecursiveHelper(array, elem, comparator, mid + 1, right);
        else return binarySearchRecursiveHelper(array, elem, comparator, left, mid - 1);
    }

    /**
     * Performs an iterative binary search on a sorted list.
     * Similar to the array-based version, but it works with a List<T>.
     * This method takes a generic list, an element to search for, and a comparator for ordering.
     * It repeatedly divides the search space in half until the element is found or the search space is empty.
     * Returns the index of the element if found, otherwise returns -1.
     */
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, final Comparator<T> comparator) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(list.get(mid), elem);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }

    /**
     * Main method to test the binary search functions.
     * Creates a sorted Integer array and a corresponding List<Integer>.
     * Uses Integer::compareTo as the comparator for ordering.
     * Searches for a target value using all three binary search methods and prints the results.
     */
    public static void main(String[] args) {
        // Sample sorted array and list
        Integer[] array = {1, 3, 5, 7, -9};
        List<Integer> list = Arrays.asList(array);
        int target = -9;

        // Comparator for natural ordering
        Comparator<Integer> comparator = Integer::compareTo;

        // Testing binary search methods
        System.out.println("Binary Search (Array): " + binarySearch(array, target, comparator));
        System.out.println("Binary Search Recursive (Array): " + binarySearchRecursive(array, target, comparator));
        System.out.println("Binary Search (List): " + binarySearch(list, target, comparator));
    }
}
