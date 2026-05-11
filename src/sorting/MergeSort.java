package sorting;

public class MergeSort {
    public static void sort(int[] number, int left, int right) {
        if (left >= right) { // Base case: if the array has one or zero elements, it's already sorted
            return;
        }
        int middle = left + (right - left) / 2; // Find the middle point to divide the array into two parts
        sort(number, left, middle); // Recursively sort the first half
        sort(number, middle + 1, right); // Recursively sort the second half
        merge(number, left, middle, right); // Merge the sorted parts
    }

    public static void merge(int[] number, int left, int middle, int right) {
        // Create temporary arrays to hold the left and right parts of the original array
        int[] leftArray = new int[middle - left + 1];
        int[] rightArray = new int[right - middle];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = number[left + i];
        }     
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = number[middle + 1 + j];
        }

        // set up three index variables
        int i = 0, j = 0, k = left;
        // compare and copy the smaller element back into the original array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                number[k++] = leftArray[i++];
            } else {
                number[k++] = rightArray[j++];
            }
        }
        // Copy any remaining elements from either the left or right array
        while (i < leftArray.length) {
            number[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            number[k++] = rightArray[j++];
        }
    }
}
