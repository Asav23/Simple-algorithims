import java.util.*;

public class KthLargest {

    public static int findKthLargest(int[] arr, int k) {
      Arrays.sort(arr);
      
      return arr[arr.length - k];
    }
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19, 2, 10};  // Example array
        int k = 3;  // Example: Find the 3rd largest element

        int result = findKthLargest(arr, k);

        System.out.println("The " + k + "th largest element is: " + result);
    }
}
