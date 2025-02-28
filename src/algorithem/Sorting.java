package algorithem;

import java.util.Arrays;

public class Sorting {

    public static void main(String[]args){
        Sorting sorting = new Sorting();
        int[] basicArray = {5,4,1,3,2};
//        selectionSort(basicArray);
//        insertionSort(basicArray);
        quickSort(basicArray,0,basicArray.length-1);
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

    static void mergeSort(int[] arr, int si, int ei){
        // Base of Recursion.
        if (si >= ei){
            return;
        }
        // Get Mid of Array
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);

    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right half
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[si + l] = temp[l];
        }
    }

    static void quickSort(int[] arr, int si, int ei){
        if (si>=ei) return;

        int pix = partition(arr,si,ei);

        quickSort(arr,si,pix-1);
        quickSort(arr, pix, ei);

    }
    static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // To make place for els smaller than pivot.

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Swap pivot into its correct position
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

}
