package chapter6;

import java.util.ArrayList;

public class ArrayInsert extends Target {

    public ArrayInsert(int arr[], ArrayList<Integer> list, String name){
        super(arr, list, name);
    }

    // insert new items at beginning of arr
    @Override
    public int method(int[] indiciesOrNums){
        int sum = 0; // will overflow
        int largerArr[] = new int[arr.length + indiciesOrNums.length];

        for (int i = 0; i < indiciesOrNums.length; i++){
            largerArr[i] = indiciesOrNums[i];
            sum += largerArr[i];
        }

        for (int i = 0; i < arr.length; i++){
            largerArr[i + indiciesOrNums.length] = arr[i];
            sum += arr[i];
        }
            
        return sum;
    }
}
