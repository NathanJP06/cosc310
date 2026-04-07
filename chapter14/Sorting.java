package chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sorting {

    private static <T extends Comparable<T>> void swap(ArrayList<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);    
    }
    
    // Comparable
    // o1.compareTo(o2) ... returns -1 if o1 is "less than" o2
    // o1.compareTo(o2) ... returns 0 if o1 is "equal to" o2
    // o1.compareTo(o2) ... returns 1 if o1 is "great than" o2
    // destructive method (i.e., it modifies the original list)
    public static <T extends Comparable<T>> void selectionSort(ArrayList<T> list) {
        // some optimizations
        if (list.size()<2) {
            return;
        }

        for (int i=0; i<list.size()-1; i++) {
            T smallest = list.get(i);
            int smallesti = i;
            for (int j=i+1; j<list.size(); j++) {
                T c = list.get(j);
                if (c.compareTo(smallest)<0) {
                    smallest = c;
                    smallesti = j;
                }
            }
            swap(list, i, smallesti);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(ArrayList<T> list) {
        // some optimizations
        if (list.size()<2) {
            return;
        }

        // This is the "true-to-name" version of insertion sort
        for (int i = 1; i<list.size(); i++) {
            T next = list.remove(i); // remove the item we are trying to insert
            int j=i-1;
            for (; j>=0 && list.get(j).compareTo(next)>0; j--); // this empty for loop finds the right spot for next
            list.add(j+1, next); // insert it at the right spot
        }
 
    }

    public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list) {
        for (int i=0; i<list.size(); i++)
            for (int j=0; j<list.size()-i-1; j++)
                if (list.get(j).compareTo(list.get(j+1))>0) 
                    swap(list, j, j+1);
    }

    public static <T extends Comparable<T>> void quickSort(ArrayList<T> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSort(ArrayList<T> list, int low, int high) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { low, high });
        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int start = range[0];
            int end = range[1];
            if (start >= end) {
                continue;
            }
            if (end - start < 16) {
                insertionSortRange(list, start, end);
                continue;
            }
            int pivotIndex = medianOfThree(list, start, end);
            swap(list, pivotIndex, end);
            int partitionIndex = partition(list, start, end);
            int leftSize = partitionIndex - 1 - start;
            int rightSize = end - (partitionIndex + 1);
            if (leftSize > rightSize) {
                if (leftSize > 0) {
                    stack.push(new int[] { start, partitionIndex - 1 });
                }
                if (rightSize > 0) {
                    stack.push(new int[] { partitionIndex + 1, end });
                }
            } else {
                if (rightSize > 0) {
                    stack.push(new int[] { partitionIndex + 1, end });
                }
                if (leftSize > 0) {
                    stack.push(new int[] { start, partitionIndex - 1 });
                }
            }
        }
    }

    private static <T extends Comparable<T>> int partition(ArrayList<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T extends Comparable<T>> int medianOfThree(ArrayList<T> list, int low, int high) {
        int mid = low + (high - low) / 2;
        T a = list.get(low);
        T b = list.get(mid);
        T c = list.get(high);
        if (a.compareTo(b) > 0) {
            if (a.compareTo(c) < 0) {
                return low;
            }
            if (b.compareTo(c) > 0) {
                return mid;
            }
            return high;
        } else {
            if (a.compareTo(c) > 0) {
                return low;
            }
            if (b.compareTo(c) < 0) {
                return mid;
            }
            return high;
        }
    }

    private static <T extends Comparable<T>> void insertionSortRange(ArrayList<T> list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            T next = list.get(i);
            int j = i - 1;
            while (j >= low && list.get(j).compareTo(next) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, next);
        }
    }

    // because this is recursive, it cannot modify the list, it must return a new sorted list
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size()<=1)
            return list; // it's already sorted ... guaranteed!

        int mid = list.size()/2;
        List<T> leftSorted = mergeSort(list.subList(0,mid));
        List<T> rightSorted = mergeSort(list.subList(mid,list.size()));
        return merge(leftSorted, rightSorted);
    }
    
    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        ArrayList<T> sortedList = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<left.size() && j<right.size()) {
            T leftval = left.get(i);
            T rightval = right.get(j);
            if (leftval.compareTo(rightval)<0) {
                sortedList.add(leftval);
                i++;
            } else {
                sortedList.add(rightval);
                j++;
            }
        }
        for (;i<left.size();i++)
            sortedList.add(left.get(i));
        for (;j<right.size();j++)
            sortedList.add(right.get(j));
        return sortedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(7);
        test.add(32);
        test.add(2);
        test.add(15);
        System.out.println(test);
        List<Integer> sorted = mergeSort(test);
        System.out.println(sorted);
        bubbleSort(test);
        System.out.println(test);
        insertionSort(test);
        System.out.println(test);
        selectionSort(test);
        System.out.println(test);
    }


}
