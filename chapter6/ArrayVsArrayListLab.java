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
        tests[0] = new ArrayRandom(arr, list, "array,random_access");
        tests[1] = new ListRandom(arr, list, "arraylist,random_access");
        tests[2] = new ArrayAppend(arr, list, "array,append");
        // tests[3] = new ListAppend(arr, list, "arraylist,append");

        for (Target target : tests) {
            if (target != null){
                target.runTrials(indicies);
                target.writeResults(fileOut);
            }
        }
        


        fileOut.close();
    }
    
}
