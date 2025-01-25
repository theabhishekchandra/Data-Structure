package search;

public class Binary {
    public static void main(String[] args) {
        Binary binary = new Binary();
        int[] numberSorted = {1,2,3,4,5,6,7,8,9};
        System.out.println("Binary: " + binarySearch(numberSorted,1));

    }

    private static int binarySearch(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
