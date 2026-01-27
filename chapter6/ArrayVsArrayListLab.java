package chapter6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVsArrayListLab {
    public static void main(String[] args) throws IOException {
        int arr[] = DataLoader.loadArray("numbers.txt");
        System.out.println("Loaded " + arr.length);

        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        System.out.println("Loaded " + list.size());

        Random r = new Random();
        int indicies[] = new int[100_000];
        for (int i = 0; i < indicies.length; i++) {
            indicies[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter(new File("results.csv"));

        Target tests[] = new Target[8];
        double testAverages[] = new double[8];

        // you need to compare results of the Array versions of a test
        // with the arraylist version of the tests
        // alternate lines in the tests (array, arraylist, array, arraylist, ...)
        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array,random_access");
        tests[1] = new ListRandom(arr, new ArrayList<>(list), "arraylist,random_access");
        tests[2] = new ArrayAppend(arr, new ArrayList<>(list), "array,append");
        tests[3] = new ListAppend(arr, new ArrayList<>(list), "arraylist,append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array,insert");
        tests[5] = new ListInsert(arr, new ArrayList<>(list), "arraylist,insert");  
        tests[6] = new ArrayRemove(arr, new ArrayList<>(list), "array,remove");
        tests[7] = new ListRemove(arr, new ArrayList<>(list), "arraylist,remove");  

        for (int i = 0; i < tests.length; i++) {
            Target target = tests[i];
            if (target != null){
                testAverages[i] = target.runTrials(indicies);
                target.writeResults(fileOut);
            }
        }

        if (testAverages[0] < testAverages[1]){
            System.out.println("Array random access was faster than ArrayList random access");
        } else {
            System.out.println("ArrayList random access was faster than Array random access");
        }

        if (testAverages[2] < testAverages[3]){
            System.out.println("Array append was faster than ArrayList append");
        } else {
            System.out.println("ArrayList append was faster than Array append");
        }

        if (testAverages[4] < testAverages[5]){
            System.out.println("Array insert was faster than ArrayList insert");
        } else {
            System.out.println("ArrayList insert was faster than Array insert");
        }

        if (testAverages[6] < testAverages[7]){
            System.out.println("Array remove was faster than ArrayList remove");
        } else {
            System.out.println("ArrayList remove was faster than Array remove");
        }

        fileOut.close();
    }
    
}
