/**
 * Project 3 - Sorting
 * 
 * @ Emma Chiu
 * @ 3/13/19
 */

public class QuickSorter extends Sorter {
    /**
     * Constructor for objects of class QuickSorter
     */
    public QuickSorter() {
        super();
    }

    public void onePass1(int[] a, int initialLeftIndex, int limitRightIndex) {
        int pivotValue = a[initialLeftIndex];
        int rightIndex = limitRightIndex - 1;
        int leftIndex = initialLeftIndex + 1;
        while (leftIndex <= rightIndex) {
            if (less(pivotValue, a[leftIndex])) {
                while ((rightIndex >= leftIndex) && less(pivotValue, a[rightIndex])) {
                    rightIndex--;
                }
                if (leftIndex < rightIndex) {
                    swap(a, leftIndex, rightIndex);
                    rightIndex--;
                    leftIndex++;
                }
            } else {
                leftIndex++;
            }
        }
        if (initialLeftIndex < leftIndex - 1) {
            swap(a, initialLeftIndex, leftIndex - 1);
            onePass(a, initialLeftIndex, leftIndex - 1);
        }
        if (leftIndex < limitRightIndex) {
            onePass(a, leftIndex, limitRightIndex);
        }
    }

    private void setPivot(int[] a, int initialLeftIndex, int limitRightIndex) {
        int elementCount = limitRightIndex - initialLeftIndex;
        int rightIndex = limitRightIndex - 1;
        if (elementCount >= 3) {
            int middleIndex = initialLeftIndex + elementCount/2;
            int leftValue = a[initialLeftIndex];
            int rightValue = a[rightIndex];
            int middleValue = a[middleIndex];
            if (less(a[rightIndex], a[middleIndex])) {
                if (less(a[initialLeftIndex], a[rightIndex])) {
                    swap(a, initialLeftIndex, rightIndex);
                }
            }
            if (less(a[initialLeftIndex], a[middleIndex])) {
                swap(a, initialLeftIndex, middleIndex);
            }
        }
    }

    public void onePass(int[] a, int initialLeftIndex, int limitRightIndex) {
        // By eliminating the smart pivot code, sorted arrays produce
        // worst case behavior
        // setPivot(a, initialLeftIndex, limitRightIndex);
        int pivotValue = a[initialLeftIndex];
        int rightIndex = limitRightIndex - 1;
        int leftIndex = initialLeftIndex + 1;
        while (leftIndex <= rightIndex) {
            while ((leftIndex <= rightIndex) && lessEqual(a[leftIndex], pivotValue)) {
                leftIndex++;
            }
            while ((leftIndex <= rightIndex) && less(pivotValue, a[rightIndex])) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(a, leftIndex, rightIndex);
                rightIndex--;
                leftIndex++;
            }
        }
        if (initialLeftIndex < leftIndex - 1) {
            swap(a, initialLeftIndex, leftIndex - 1);
            onePass(a, initialLeftIndex, leftIndex - 1);
        }
        if (leftIndex < limitRightIndex) {
            onePass(a, leftIndex, limitRightIndex);
        }
    }

    public void sort(int[] a) {
        onePass(a, 0, a.length);
    }
}
