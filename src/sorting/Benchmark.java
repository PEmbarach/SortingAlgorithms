package sorting;

public class Benchmark {
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        
        System.out.println();
        BubbleSort.sort(numbers);
        System.out.println("Sorted array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        
    }
}