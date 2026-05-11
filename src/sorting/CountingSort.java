package sorting;

public class CountingSort {
    public static void sort(int[] number) {
        int n = number.length; // Get the length of the input array
        int max = 0; // Initialize max to the smallest possible value
        
        // Find the maximum value in the input array to determine the size of the count array
        for (int i = 0; i < n; i++) {
            if (number[i] > max) { // If the current element is greater than max, update max
                max = number[i];
            }
        }

        int[] count = new int[max + 1]; // Create a count array to store the count of each unique value
        
        // Count each element in the input array and store the count in the count array
        for (int i = 0; i < n; i++) {
            count[number[i]]++; // Increment the count for the current element
        }

        int index = 0; //  Variable to track the current position in number

        // Build the output array by iterating through the count array and placing each value back into number
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) { // While there are still occurrences of the current element
                number[index++] = i; // Place each value back into the original array the correct number of times
                count[i]--; // Decrease the count for the current element
            }
        }
    }
}
