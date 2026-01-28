package chapter6;

import java.util.ArrayList;

public class ListAppend extends Target{
    public ListAppend(int arr[], ArrayList<Integer> list, String name){
        super(arr, list, name);
    }

    @Override
    public int method(int indiciesOrNums[]){
        int result = 0;

        for(int i = 0; i < indiciesOrNums.length; i++){
            result += list.get(indiciesOrNums[i]);
            list.add(indiciesOrNums[i]);
        }
        
        return result;
    }

}
