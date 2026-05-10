package sorting;

public class SelectionSort {
    public static void sort(int[] number) {
        int n = number.length;
        for (int i = 0; i < n - 1; i++){
            int minIndex = i; // Assume the minimum is the first element of the unsorted portion
            for (int j = i + 1; j < n; j++){
                if (number[j] < number[minIndex]) { // If the current element is smaller than the minimum
                    minIndex = j; // Update the minimum index
                }
            }
            if (minIndex != i) { // If the minimum index has changed, perform the swap
                int temp = number[i]; // Save the current element into a temporary variable
                number[i] = number[minIndex]; // Put the minimum element into the current position
                number[minIndex] = temp; // Put the saved element into the minimum index position
            }
        }
    }
}
