package sorting;

public class InsertionSort {
    public static void sort(int[] number) {
        int n = number.length;
        for (int i = 1; i < n; i++) {
            int key = number[i]; // The current element to be compared
            int j = i - 1; // The index of the last sorted element
            // Move elements of number[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && number[j] > key) {
                number[j + 1] = number[j]; // Shift the element one position to the right
                j = j - 1; // Move to the previous element
            }
            number[j + 1] = key; // Place the key in its correct position
        }
    }
}
