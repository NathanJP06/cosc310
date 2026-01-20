package chapter6;

import java.io.IOException;
import java.util.ArrayList;

public class RuntimeLab {
    protected static int arrayTest(int n) {
        int nums[] = new int[n];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // Benchmarking
        long start = System.nanoTime();
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Empty run: " + duration + " ns");

        // Measure time taken to print "hello world!"
        start = System.nanoTime();
        System.out.println("hello world!");
        end = System.nanoTime();
        duration = end - start;
        System.out.println("println: " + duration + " ns");

        // Measure time taken to run arrayTest with different sizes
        start = System.nanoTime();
        arrayTest(30_000);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("arrayTest: " + duration + " ns");

        // Measure time taken to load array from file
        start = System.nanoTime();
        int arr[] = DataLoader.loadArray("numbers.txt");
        end = System.nanoTime();
        duration = end - start;
        System.out.println("DataLoader.loadArray: " + duration + " ns");

        // Measure time taken to load ArrayList from file
        start = System.nanoTime();
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        end = System.nanoTime();
        duration = end - start;
        System.out.println("DataLoader.loadArrayList: " + duration + " ns");

        
    }
}
