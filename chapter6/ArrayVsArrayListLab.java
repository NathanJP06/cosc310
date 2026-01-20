package chapter6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {
    protected static int arrayRandomAccess(int indices[], int arr[]){
        int result = 0;
        for (int i = 0; i < indices.length; i++) {
            result += arr[indices[i]];
        }
        return result;
    }

    protected static int listRandomAccess(int indices[], ArrayList<Integer> list){
        int result = 0;
        for (int i = 0; i < indices.length; i++) {
            result += list.get(indices[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int arr[] = DataLoader.loadArray("numbers.txt");
        System.out.println("Loaded " + arr.length);

        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        System.out.println("Loaded " + list.size());

        Random r = new Random();
        int indicies[] = new int[100];
        for (int i = 0; i < indicies.length; i++) {
            indicies[i] = r.nextInt(arr.length);
        }

        // Benchmarking random access for array
        long start = System.nanoTime();
        int result = 0;
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Empty run: " + duration + " ns");

        // arrayRandomAccess
        start = System.nanoTime();
        result = arrayRandomAccess(indicies, arr);
        end = System.nanoTime();
        duration = end - start;
        System.out.println(result);
        System.out.println("Array: " + duration + " ns");

        //listRandomAccess
        start = System.nanoTime();
        result = listRandomAccess(indicies, list);
        end = System.nanoTime();
        duration = end - start;
        System.out.println(result);
        System.out.println("DataLoader.loadArrayList: " + duration + " ns");
        
    }
    
}
