package algorithem;

import java.util.Arrays;

public class Sorting {

    public static void main(String[]args){
        Sorting sorting = new Sorting();
        int[] basicArray = {5,4,1,3,2};
//        selectionSort(basicArray);
//        insertionSort(basicArray);
        countingSort(basicArray);
        System.out.println(Arrays.toString(basicArray));

    }

    /** Largest Array came to end of Array by swapping with adjacent element.*/
    static void bubbleSort(int[] data){


    }

    /** Pick the smallest(from unsorted array), put it at the beginning*/
    static void selectionSort(int[] arr){
        for (int i =0; i< arr.length -1; i++){
            int minPos = i;
            for (int j= i+1; j < arr.length; j++){
                if (arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    /** Pick an element(from unsorted part) & place in the right pos in sorted part.*/
    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int pre = i-1;

            while (pre >= 0 && arr[pre] > curr){
                arr[pre +1] = arr[pre];
                pre--;
            }
            arr[pre+1] = curr;
        }
    }

    /** */
    static void countingSort(int[] arr){
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i< arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest +1];
        for (int i= 0; i<arr.length; i++){
            count[arr[i]]++;
        }

        // sorting
        int j = 0;
        for (int i =0; i< count.length; i++){
            while (count[i] > 0){
                arr[j] =i;
                j++;
                count[i]--;
            }
        }
    }
}
