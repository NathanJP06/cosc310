package chapter6;

import java.util.ArrayList;

public class ArrayRemove extends Target {

    public ArrayRemove(int arr[], ArrayList<Integer> list, String name){
        super(arr, list, name);
    }

    @Override
    public int method(int indiciesOrNums[]){
        int result = 0;
        int smallerArr[] = new int[arr.length - 20_000];

        for (int i = 20_000; i < indiciesOrNums.length; i++) {
            smallerArr[i-20_000] = arr[i];
            result++;
        }

        return result;
    }
}
