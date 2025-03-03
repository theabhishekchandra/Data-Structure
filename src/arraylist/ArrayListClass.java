package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListClass {
    /** ArrayList -> ArrayList is a non-primitive data type. <p>
     * ArrayList<Integer> arrayList = new ArrayList<>(); <p>*/
    public static void main(String[] args) {
//        int[] list = {9,12,5,10,14,3,10};
//        int[] list = {1,8,6,2,5,4,8,3,7};
        int[] list = {1,2,3,4,5,6};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : list){
            arrayList.add(i);
        }
        pairSum(arrayList, 5);
    }

    static void operation(ArrayList<Integer> arrayList){
        /// Add in ArrayList
        arrayList.add(1); // add(value)   {O(1)}
        arrayList.add(1, 2); // add(index, value)   {O(n)}

        ///  Get
        arrayList.get(1); // get(Index)    {O(1)}

        ///  Set
        arrayList.set(1, 2); // set(index, value)

        ///  Remove
        arrayList.remove(0); // remove(index)  {O(n)}

    }
    static void sortArrayList(ArrayList<Integer> arrayList){
        arrayList.sort(Collections.reverseOrder());
        System.out.println(arrayList);
    }

    static void multiDimensional(){
        /// ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mArr = new ArrayList<>();
    }

    /** Container with most water.*/

    static void mostWaterContain(ArrayList<Integer> container){
        int mWater = 0;
        int start = 0;
        int last = container.size() -1;

        while (start < last){
            int minHeight = Math.min(container.get(start),container.get(last));
            int width = last - start ;
            mWater = Math.max(mWater, minHeight * width);
            if (container.get(start) < container.get(last)){
                start++;
            }else {
                last--;
            }
        }
        /* This Is Correct but we need to improvement.
        for (int i = 0; i < container.size(); i++){
            for (int j = i; j < container.size(); j++){
                if (i != j) {
                    int minHeight = Math.min(container.get(i),container.get(j));
                    int width = j - i ;
                    mWater = Math.max(mWater, minHeight * width);
                }
            }
        }*/

        System.out.println(mWater);

    }

    static void pairSum(ArrayList<Integer> arrayList, int target){
        int start = 0;
        int end = arrayList.size() -1;

        while (start < end){
            if (arrayList.get(start) + arrayList.get(end) == target){
                System.out.println(start);
                System.out.println(end);
                start++;
                end--;
            }else if(arrayList.get(start) + arrayList.get(end) > target){
                end--;
            }else {
                start++;
            }
        }

    }
}
