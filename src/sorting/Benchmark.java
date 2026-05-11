package sorting;

import java.util.concurrent.ThreadLocalRandom;

public class Benchmark {
    public static void main(String[] args) {
        int[] inputSizes = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
        String[] algorithms = { "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Counting Sort" };
        double[][] results = new double[algorithms.length][inputSizes.length];

        // Loop through each input size and algorithm, run the sorting algorithm 10 times, and average the time taken
        for (int i = 0; i < inputSizes.length; i++) {
            // Run each algorithm 10 times and average the time taken
            for (int j = 0; j < algorithms.length; j++) { 
                double totalTime = 0;
                for (int r = 0; r < 10; r++) {
                    int[] arr = generateArray(inputSizes[i]); // Generate a random array of the specified size
                    long startTime = System.nanoTime(); // Start timing
                    switch (algorithms[j]) { // Call the appropriate sorting method based on the algorithm name
                        case "Bubble Sort":
                            BubbleSort.sort(arr);
                            break;
                        case "Counting Sort":
                            CountingSort.sort(arr);
                            break;
                        case "Insertion Sort":
                            InsertionSort.sort(arr);
                            break;
                        case "Merge Sort":
                            MergeSort.sort(arr, 0, arr.length - 1);
                            break;
                        case "Selection Sort":
                            SelectionSort.sort(arr);
                            break;
                    }
                    long endTime = System.nanoTime(); // End timing
                    totalTime += (endTime - startTime) / 1_000_000.0; // convert to milliseconds
                }
                results[j][i] = totalTime / 10.0; // average time
            }
        }
        // Print results
        // Print input sizes as header
        System.out.printf("%-16s", "Size");
        for (int i = 0; i < inputSizes.length; i++) {
            System.out.printf("%8d", inputSizes[i]);
        }
        System.out.println();

        // Print one row per algorithm
        for (int j = 0; j < algorithms.length; j++) { // Print algorithm name
            System.out.printf("%-16s", algorithms[j]);
            for (int i = 0; i < inputSizes.length; i++) { // Print average time for each input size
                System.out.printf("%8.3f", results[j][i]);
            }
            System.out.println();
        }
    }

    public static int[] generateArray(int n) { // Generate an array of n random integers
        int[] arr = new int[n]; // Create an array of size n
        for (int i = 0; i < n; i++) {
            arr[i] = (ThreadLocalRandom.current().nextInt(1, 100001)); // random integers between 1 and 100000
        }
        return arr;
    }
}