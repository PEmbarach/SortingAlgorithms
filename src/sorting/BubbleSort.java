package sorting;

public class BubbleSort {
    public static void sort(int[] number) {
        int n = number.length;
        boolean swapped; // Flag to check if any swapping occurs
        for (int i = 0; i < n - 1; i++){ // controls how many passes you make over the array.
            swapped = false; // Reset the flag for each pass
            for (int j = 0; j < n - i - 1; j++) {// controls how many comparisons you make in each pass.
                if (number[j] > number[j + 1]) {
                    int temp = number[j + 1]; // Save the value into a temporary variable (the next element)
                    number[j + 1] = number[j]; // Overwrite that slot with the current element (the larger one)
                    number[j] = temp; // Put temp (the smaller one) into the now-free slot
                    swapped = true; // Set the flag to true if a swap occurred
                }
            }
            if (!swapped) {
                break; // If no swapping occurred, the array is sorted
            }
        }   
    }
}
