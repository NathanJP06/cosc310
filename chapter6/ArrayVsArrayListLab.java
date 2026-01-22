package chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));
        for (int i = 0; i < 5; i++) {
            // arrayRandomAccess
            long start = System.nanoTime();
            int result = arrayRandomAccess(indicies, arr);
            long end = System.nanoTime();
            long duration = end - start;
            System.out.println(result);
            System.out.println("Array: " + duration + " ns");
            fileOut.printf("array,random_access,%d,%.2f,%d\n", i+1, duration / 1_000.0, result);
        }

        for (int i = 0; i < 5; i++) {
            // listRandomAccess
            long start = System.nanoTime();
            int result = listRandomAccess(indicies, list);
            long end = System.nanoTime();
            long duration = end - start;
            System.out.println(result);
            System.out.println("DataLoader.loadArrayList: " + duration + " ns");
            fileOut.printf("arraylist,random_access,%d,%.2f,%d\n", i+1, duration / 1_000.0, result);
        }   

        fileOut.close();
    }
    
}
