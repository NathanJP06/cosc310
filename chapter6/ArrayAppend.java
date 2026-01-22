package chapter6;

import java.util.ArrayList;

public class ArrayAppend extends Target {

    public ArrayAppend(int arr[], ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indiciesOrNums) {
        int result = 0;
        int largerArr[] = java.util.Arrays.copyOf(arr, arr.length + indiciesOrNums.length);

        for (int i = 0; i < indiciesOrNums.length; i++) {
            result += arr[indiciesOrNums[i]];
            largerArr[arr.length + i] = indiciesOrNums[i];
        }
        return result;
    }
    
    
}
